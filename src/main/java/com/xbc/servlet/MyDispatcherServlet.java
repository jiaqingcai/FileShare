package com.xbc.servlet;



import com.xbc.annatation.MyController;
import com.xbc.annatation.MyRequestMapping;
import com.xbc.annatation.MyRequestParam;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

public class MyDispatcherServlet extends HttpServlet {

    public static final String LOCATION = "contextConfigLocation";

    //存储读取到的配置文件信息：要扫描的包信息
    public static Properties properties = new Properties();

    //包下所有类
    public static List<String> classNames = new ArrayList<String>();

    //ioc容器，存储beanName和类
    public static Map<String, Object> ioc = new HashMap<String, Object>();

    //存储url和Controller类中的方法
    public static Map<String, Method> handerMapping = new HashMap<String, Method>();


    public MyDispatcherServlet() {
        super();
    }

    //    在 Servlet 的生命期中，仅执行一次 init() 方法。它是在服务器装入 Servlet
//    时执行的。可以配置服务器，以在启动服务器或客户机首次访问 Servlet 时装入 Servlet。 无论有多少客户机访问
//    javax.servlet.Servlet，都不会重复执行 init()
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init开始----");
        //1.通过LOCATION 找到配置文件，并加载配置文件到 properties变量
        doLoadConfig(config.getInitParameter(LOCATION));

        //2.初始化所有相关联的类，扫描用户设定的包下面所有的类，并加到classNames变量
        doScanner(properties.getProperty("scanPackage"));

        //3.循环classNames，拿到扫描到的类，通过反射机制，实例化，并且放到ioc容器变量中(k-v beanName-bean)
        //beanName为首字母小写
        //有注解MyController的类加入到ioc中
        doInstance();

        //4初始化handlerMapping(将url和method对应上)
        initHanderMapping();
        System.out.println("init结束----");
    }

    //加载web.xml配置文件中contextConfigLocation的值，即classpath:application.properties
    public void doLoadConfig(String location) {
        properties = new Properties();

        if (location.startsWith("classpath")) {
            location = location.replaceAll("classpath\\:", "");
        }
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(location);
        try {
            properties.load(inputStream);//输入流中读取属性列表,装在成k-v值
            //key=scanPackage,value=com.liugh.core.controller
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void doScanner(String scanPackage) {
        String packages = "/" + scanPackage.replaceAll("\\.", "/");
        //类加载器
        //Java 文件被运行，第一步，需要通过 javac 编译器编译为 class 文件；
        // 第二步，JVM 加载 class 文件
        String dir = this.getClass().getClassLoader().getResource(packages).toString();

        System.out.println("扫描包名doScanner-scanPackage:" + scanPackage);
        System.out.println("解析成扫描包的路径doScanner-packages:" + packages);
        System.out.println("通过类加载器获取包路径doScanner-dir:" + dir);
        File file = new File(dir.replaceAll("file:", ""));
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                System.out.println("循环里File路径:" + f.getAbsolutePath());
                if (f.isDirectory()) {
                    doScanner(f.getAbsolutePath());
                } else {
                    classNames.add(scanPackage + "." + f.getName().replace(".class", ""));
                }
            }
        }
    }

    public void doInstance() {
        System.out.println("classNames.size()"+classNames.size());
        if (classNames.size() > 0) {
            try {
                for (String className : classNames) {
                    Class<?> clazz = Class.forName(className);
                    MyController myController = clazz.getAnnotation(MyController.class);
                    if (myController != null) {
                        String beanName = lowerFirstChar(clazz.getSimpleName());
                        ioc.put(beanName, clazz.newInstance());
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    private String lowerFirstChar(String val) {
        return val.substring(0, 1).toLowerCase() + val.substring(1);
    }

    public void initHanderMapping() {
        if (!ioc.isEmpty()) {
            for (Map.Entry<String, Object> entry : ioc.entrySet()) {
                Class<?> clazz = entry.getValue().getClass();
                MyRequestMapping requestMapping = clazz.getAnnotation(MyRequestMapping.class);

                if (null != requestMapping) {
                    String baseUrl = requestMapping.value();
                    System.out.println("baseUrl"+baseUrl);
                    if (baseUrl == null) {
                        baseUrl = "";
                    }

                    Method[] methods = clazz.getMethods();
                    System.out.println("methods"+methods);
                    for (Method method : methods) {
                        requestMapping = method.getAnnotation(MyRequestMapping.class);
                        if (null != requestMapping) {
                            String url = requestMapping.value();

                            handerMapping.put(baseUrl + url, method);
                        }
                    }
                }

            }
        }
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost开始----");
        doDispatch(req, resp);
        System.out.println("doPost结束----");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet开始----");
        doDispatch(req, resp);
        System.out.println("doGet结束----");
    }


    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();//域名后内容|| req.getRequestURL()返回全网址
        System.out.println("url"+url);
        String contextPath = req.getContextPath();//可以返回当前页面所在的应用的名字;
        System.out.println("contextPath"+contextPath);
        url = url.replace(contextPath, "").replaceAll("//+", "/");
        System.out.println("urk2"+url);
        Method method = handerMapping.get(url);

        if (method == null) {
            resp.getWriter().write("404 not found!");
            return;
        }

        Map<String, String[]> parameterMap = req.getParameterMap();
        Parameter[] parameters = method.getParameters();

        Class<?>[] classes = method.getParameterTypes();
        Object[] paramters = null;
        Object result = null;
        if (classes == null || classes.length == 0) {
            try {
                result = method.invoke(ioc.get(lowerFirstChar(method.getDeclaringClass().getSimpleName())));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } else {
            paramters = new Object[classes.length];
            for (int i = 0; i < paramters.length; i++) {
                if (classes[i] == HttpServletRequest.class) {
                    paramters[i] = req;
                } else if (classes[i] == HttpServletResponse.class) {
                    paramters[i] = resp;
                } else if (classes[i] == String.class) {
                    for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
                        MyRequestParam myRequestParam = parameters[i].getAnnotation(MyRequestParam.class);
                        if(myRequestParam!=null) {
                            if (entry.getKey().equals(myRequestParam.value())) {
                                paramters[i] = Arrays.toString(entry.getValue()).replaceAll("\\[|\\]", "").replaceAll(",\\s", ",");
                                break;
                            }
                        }
                    }
                } else {
                    try {
                        Object object = classes[i].newInstance();
                        Field[] fields = classes[i].getDeclaredFields();
                        for (Field field : fields) {
                            if (parameterMap.get(field.getName()) != null) {
                                boolean isAccessible = false;
                                if (!field.isAccessible()) {
                                    field.setAccessible(true);
                                    isAccessible = true;
                                }

                                field.set(object, Arrays.toString(parameterMap.get(field.getName())).replaceAll("\\[|\\]", "").replaceAll(",\\s", ","));
                                if (isAccessible) {
                                    field.setAccessible(false);
                                }
                            }
                        }
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }

            try {
                result = method.invoke(ioc.get(lowerFirstChar(method.getDeclaringClass().getSimpleName())), paramters);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        //通过判断方法的返回值类型，确认是否是void，如果是，在这里write到界面，否则由controller自己处理
        if (!method.getReturnType().equals(Void.TYPE)) {
            resp.getWriter().write(result.toString());
        }

    }

}
