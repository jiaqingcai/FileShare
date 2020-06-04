package com.xbc.annatation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyRequestParam {
    /**
     * 表示参数的别名，必填
     * @return
     */
    String value() default "";
}
