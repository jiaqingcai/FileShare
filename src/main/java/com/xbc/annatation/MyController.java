package com.xbc.annatation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyController {
    /**
     * 表示给controller注册别名
     * @return
     */
    String value() default "";
}
