package com.xbc.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtils {

        private static SqlSessionFactory sqlSessionFactory;
private static SqlSession SqlSession;
        static {
            try {
                //创建sqlSessionFactoryBuilder对象
                SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
                //创建核心配置文件输入流
                InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
                //通过输入流创建SqlSessionFactory对象
                sqlSessionFactory = ssfb.build(inputStream);
                SqlSession= sqlSessionFactory.openSession();
            }catch(Exception  e) {
                e.printStackTrace();
            }
        }
        // 提供get方法，SqlSession
        public static SqlSession getSqlSession() {
            return SqlSession;
        }
    }

