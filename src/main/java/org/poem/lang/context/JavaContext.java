package org.poem.lang.context;

import org.poem.utils.collection.CollectionUtils;
import org.poem.utils.collection.Maps;
import org.poem.utils.logger.LoggerUtils;

import java.util.Map;

public class JavaContext {

    /**
     * 加载类
     */
    private static Map<String, Object> LOADER_CLASS = Maps.emptys();

    /**
     * 是不是已经遍历
     *
     * @param classPackage
     * @return
     */
    public static <K extends String, V extends Object> V canPush(K classPackage, V value) {
        Boolean has = CollectionUtils.isNotEmpty(LOADER_CLASS) && LOADER_CLASS.get(classPackage) != null;
        if(!has){
            LoggerUtils.info("加载类：" + classPackage);
            LOADER_CLASS.put(classPackage,value);
        }
        return has ? (V) LOADER_CLASS.get(classPackage) : value;
    }

    /**
     * 是不是已经遍历
     *
     * @param classPackage
     * @return
     */
    public static <K extends Class, V extends Object> V canPush(K classPackage, V value) {
        return  JavaContext.canPush(classPackage.getName(),value);
    }
}
