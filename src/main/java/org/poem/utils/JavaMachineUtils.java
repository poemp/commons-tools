package org.poem.utils;

import org.poem.lang.core.JavaClass;
import org.poem.lang.loader.JavaLoaderMachine;
import org.poem.lang.stream.AnnotationFunction;
import org.poem.utils.collection.Lists;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class JavaMachineUtils {

    /**
     * 根据class 创建JavaClass
     *
     * @param clazz
     * @return
     */
    public static JavaClass buildClass(Class clazz) {
        return new JavaLoaderMachine(clazz).build();
    }

    /**
     * 注释类型JavaClass
     *
     * @param clazz
     * @return
     */
    public static JavaClass annotationType(Class<? extends Annotation> clazz) {
        return new JavaLoaderMachine(clazz).build();
    }


    /**
     * 类型
     *
     * @param clazzs
     * @return
     */
    public static List<org.poem.lang.core.Annotation> annotationsType(Annotation[] clazzs) {
        if (null != clazzs && clazzs.length > 0) {
            return  Lists.asList(clazzs)
                    .stream()
                    .map(new AnnotationFunction())
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        }
        return null;
    }
}
