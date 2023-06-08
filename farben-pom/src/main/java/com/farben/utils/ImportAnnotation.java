package com.farben.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ImportAnnotation {

    int sheetIndex() default 0;

    int rowIndex() default 1;

    int cellIndex() default 100;

    String method() default "";

    int length() default 0;

    Class type() default String.class;
}