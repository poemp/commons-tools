package org.poem.lang.annotation;

import org.poem.utils.collection.Sets;

import java.util.Set;

public class JavaAnnotationContext {

    private  static Set<String> MAP;

    static {
        MAP = Sets.empty();
    }

    public static void put(String name){
        MAP.add(name);
    }

    public static Boolean has(String name){
        return  MAP.contains(name);
    }
}
