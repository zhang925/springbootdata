package com.zzy.util;

import com.zzy.domain.User;

import java.lang.reflect.*;

import java.util.*;
/**
 * 反射类 用
 */
public class Util_ReflexClass<T> {

    public static void main(String[] args) throws NoSuchMethodException, SecurityException {

//         * 实列化类 方法1
        //String classPath = "com.whbs.bean.UserBean";
        //Class cla = Test1.class.getClassLoader().loadClass(classPath);
        //Object ob = cla.newInstance();

        // * 实列化类 方法2

        User bean = new User();
        bean.setId(123);
        bean.setName("张无忌");
        bean.setAddress("光明顶");

        //得到类对象

        Class userCla = (Class) bean.getClass();


         //* 得到类中的所有属性集合
         //* 得到类中的方法

        Method[] methods = userCla.getMethods();
        for(int i = 0; i < methods.length; i++){
            Method method = methods[i];
            if(method.getName().startsWith("get")){
                System.out.print("methodName:"+method.getName()+"\t");
               // System.out.println("value:"+method.invoke(bean));//得到get 方法的值
            }
        }
    }



}
