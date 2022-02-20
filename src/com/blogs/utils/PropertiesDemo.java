package com.blogs.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public  class  PropertiesDemo {
    static  Properties properties = new Properties();
    // ʹ��ClassLoader����properties�����ļ����ɶ�Ӧ��������
    static  InputStream in = PropertiesDemo.class.getClassLoader().getResourceAsStream("jdbc.properties");
    // ʹ��properties�������������
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
