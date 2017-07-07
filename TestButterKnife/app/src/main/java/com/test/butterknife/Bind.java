package com.test.butterknife;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.CLASS;

/**
 * Created by M4500 on 2017/7/7.
 */

@Retention(CLASS) @Target(FIELD)
public @interface Bind {
    int value() default 0;
}
