package org.poem.lang.context;

import org.poem.lang.core.JavaClass;
import org.poem.utils.collection.Maps;
import org.poem.utils.logger.LoggerUtils;

import java.util.Map;

public class JavaContext {

    /**
     * 所有的加载类的集合
     */
    private static Map<String, JavaClass> MAP;


    static {
        JavaContext.MAP = Maps.emptys();
    }

    /**
     * 是否存在
     *
     * @param className
     * @return
     */
    public static JavaClass get(String className) {
        return MAP.get(className);
    }

    /**
     * 保存数据
     *
     * @param name
     * @param javaClass
     */
    public static void set(String name, JavaClass javaClass) {
        LoggerUtils.info(name);
        MAP.put(name, javaClass);
    }
}
