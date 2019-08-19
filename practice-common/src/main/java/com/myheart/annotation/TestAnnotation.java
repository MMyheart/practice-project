package com.myheart.annotation;

import java.lang.annotation.*;

/**
 * @author yangxin
 * @date 2019/8/9
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {

    int tst() default 1;

    int value() default 222;

    String tttt()  default "tttt";
}
