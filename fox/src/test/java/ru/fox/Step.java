package ru.fox;

import java.lang.annotation.*;

//package ru.yandex.qatools.allure.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by fomina.zhanna on 25.07.2017.
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Step {
    String value() default "";
}