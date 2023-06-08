package com.farben.utils.aop;

import java.lang.annotation.*;

@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebLog {

    /**
     * 渠道
     * @return 渠道标识
     */
    String channel() default "web";

    /**
     * 功能名称
     * @return 功能名称
     */
    String name() default "";

    /**
     * 方法名称
     * @return 方法名称
     */
    String action() default "";

    /**
     * 是否保存（默认不保存）
     * @return 是否保存
     */
    boolean saveFlag() default false;
}
