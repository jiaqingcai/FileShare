package com.xbc.annatation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyRequestMapping {
    /**
     * 表示访问改方法的url
     * @return
     */
    String value() default "";
}
