package com.zzy.util;

import com.zzy.domain.User;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


/**
 * spring boot webservice 参数 反射 用
 */
public class Util_ParamReflex<T> {

    private Class<T> clazz;

    public Util_ParamReflex(Class<T> clazz) {
        this.clazz = clazz;
    }

    /**
     * 输出 一个实体的 属性 和 值
     *
     * @param entity
     */
    public void getNameAndValue(T entity) {
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            try {
                Field field = fields[i];
                field.setAccessible(true); //设置些属性是可以访问的
                String name = field.getName();//属性名字
                Object val = field.get(entity);
                System.out.println("name:" + name + "   val:" + val);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 从request 获取信息
     * 返回 带数据的 实体
     *
     * @param request
     * @return
     */
    public T setAjaxParam(HttpServletRequest request) {
        T entity = null;
        Enumeration pNames = request.getParameterNames();
        while (pNames.hasMoreElements()) {
            String name = (String) pNames.nextElement();
            String c = request.getParameter(name);

            Field[] fields = clazz.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                try {
                    // 如果不存在实例则新建
                    entity = (entity == null ? clazz.newInstance() : entity);
                    Field field = fields[i];
                    field.setAccessible(true); //设置些属性是可以访问的
                    String name2 = field.getName();//属性名字
                    //Object val2 = field.get(entity);
                    if (name2.equals(name)) {//属性 名字 和 request 的 参数名字相同
                        //把 request 的 值付给实体

                        Class<?> fieldType = field.getType();
                        if (fieldType == null) {
                            continue;
                        }
                        if (String.class == fieldType) {
                            field.set(entity, String.valueOf(c));
                        } else if (Date.class == fieldType) {
                            field.set(entity, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(c)));
                        } else if ((Integer.TYPE == fieldType) || (Integer.class == fieldType)) {
                            field.set(entity, Integer.parseInt(c));
                        } else if ((Long.TYPE == fieldType) || (Long.class == fieldType)) {
                            field.set(entity, Long.valueOf(c));
                        } else if ((Float.TYPE == fieldType) || (Float.class == fieldType)) {
                            field.set(entity, Float.valueOf(c));
                        } else if ((Short.TYPE == fieldType) || (Short.class == fieldType)) {
                            field.set(entity, Short.valueOf(c));
                        } else if ((Double.TYPE == fieldType) || (Double.class == fieldType)) {
                            field.set(entity, Double.valueOf(c));
                        } else if (Character.TYPE == fieldType) {
                            if ((c != null) && (c.length() > 0)) {
                                field.set(entity, Character.valueOf(c.charAt(0)));
                            }
                        }
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        return entity;
    }


    /**
     * map 转换成 实体
     *
     * @param map
     * @return
     */
    public T mapToBean(Map map) {
        T entity = null;
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            try {
                entity = (entity == null ? clazz.newInstance() : entity);
                Field field = fields[i];
                field.setAccessible(true); //设置些属性是可以访问的
                String name = field.getName();//属性名字
                if (map.containsKey(name)) {
                    Object value = map.get(name);
                    String c = value.toString();
                    Class<?> fieldType = field.getType();
                    if (fieldType == null) {
                        continue;
                    }
                    if (String.class == fieldType) {
                        field.set(entity, String.valueOf(c));
                    } else if (Date.class == fieldType) {
                        field.set(entity, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(c)));
                    } else if ((Integer.TYPE == fieldType) || (Integer.class == fieldType)) {
                        field.set(entity, Integer.parseInt(c));
                    } else if ((Long.TYPE == fieldType) || (Long.class == fieldType)) {
                        field.set(entity, Long.valueOf(c));
                    } else if ((Float.TYPE == fieldType) || (Float.class == fieldType)) {
                        field.set(entity, Float.valueOf(c));
                    } else if ((Short.TYPE == fieldType) || (Short.class == fieldType)) {
                        field.set(entity, Short.valueOf(c));
                    } else if ((Double.TYPE == fieldType) || (Double.class == fieldType)) {
                        field.set(entity, Double.valueOf(c));
                    } else if (Character.TYPE == fieldType) {
                        if ((c != null) && (c.length() > 0)) {
                            field.set(entity, Character.valueOf(c.charAt(0)));
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return entity;
    }

    /**
     * 把 赋值过来的 实体 给 map ket->属性 val->值
     *
     * @return
     */
    public Map beanToMap(T entity) {
        Map map = new HashMap();
        try {
            Field[] fields = clazz.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                field.setAccessible(true); //设置些属性是可以访问的
                String name = field.getName();
                Object val = field.get(entity);
                map.put(name, val);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }





    public static void main(String[] args) throws Exception {


        Util_ParamReflex u = new Util_ParamReflex(User.class);
        User bean = new User();
        bean.setId(123);
        bean.setName("张无忌");
        bean.setAddress("光明顶");
        u.beanToMap(bean);


        /*
         * 实列化类 方法1
         */
        //String classPath = "com.whbs.bean.UserBean";
        //Class cla = Test1.class.getClassLoader().loadClass(classPath);
        //Object ob = cla.newInstance();

        /*
         * 实列化类 方法2
         */

       /* User bean = new User();
        bean.setId(123);
        bean.setName("张无忌");
        bean.setAddress("光明顶");

        //得到类对象

        Class userCla = (Class) bean.getClass();

        *//*
         * 得到类中的所有属性集合
         *//*



         *//*
         * 得到类中的方法
         *//*
        Method[] methods = userCla.getMethods();
        for(int i = 0; i < methods.length; i++){
            Method method = methods[i];
            if(method.getName().startsWith("get")){
                System.out.print("methodName:"+method.getName()+"\t");
                System.out.println("value:"+method.invoke(bean));//得到get 方法的值
            }
        }*/
    }


}
