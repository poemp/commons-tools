package org.poem.utils.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @author poem
 */
public class Maps {

    public static <K, V> Map<K,V> empty(){
        return new HashMap<>();
    }

    /**
     *
     * @param loaderClass
     * @return
     */
    public static Boolean isNotEmpty(Map<String, Object> loaderClass) {
        return loaderClass != null && !loaderClass.isEmpty();
    }
}
