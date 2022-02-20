package com.blogs.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public  class  PropertiesDemo {
    static  Properties properties = new Properties();
    // 使用ClassLoader加载properties配置文件生成对应的输入流
    static  InputStream in = PropertiesDemo.class.getClassLoader().getResourceAsStream("jdbc.properties");
    // 使用properties对象加载输入流
    public PropertiesDemo(){
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String driver1(){
        return properties.getProperty("driver");
    }
    public static String url(){
        return properties.getProperty("url");
    }
    public static String username(){
        return properties.getProperty("username");
    }
    public static String password(){
        return properties.getProperty("password");
    }
}
