package com.test.annotation;

import android.util.Log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/**
 * Created by M4500 on 2017/7/6.
 */

public class MyTest1 {
    @UserAnnotation(age = 20, gender = "F", id = 2014, name = "zhangsan")//注解的使用
    public Object obj;

    @Target(value = {ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface UserAnnotation {//这是一个自定义注解
        /*首先,方法必须是public的，去掉public，默认也是public,接口interface不也是这样么
         *其次，default默认值不是必须的，方法必须有返回值，返回值可以是java中复杂对象，也可以是基本类型，枚举都行
         *如 ElementType[] value();
         */
        int id() default 0;

        String name() default "";

        int age() default 0;

        String gender() default "";
    }

    public static void main() throws Exception {
        Field ojbField = MyTest1.class.getField("obj");
        UserAnnotation ua = ojbField.getAnnotation(UserAnnotation.class);
        Log.e("kunge.hu", ua.age() + "," + ua.gender() + "," + ua.id() + "," + ua.name());

        MyTest1 mt = new MyTest1();
        ojbField.set(mt, new User(ua.id(), ua.age(), ua.name(), ua.gender()));//将自己的信息送给obj，起到了附加信息的作用

        Target t = ua.annotationType().getAnnotation(Target.class);//获得注解自己的注解
        ElementType[] values = t.value();
        Log.e("kunge.hu", values.toString());
    }
}
