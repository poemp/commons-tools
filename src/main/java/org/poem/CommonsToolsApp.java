package org.poem;


import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Field;

@SpringBootApplication
public class CommonsToolsApp {

    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Class.forName("org.poem.utils.collection.Lists");
        Field[] fields  =  clazz.getFields();
    }
}
