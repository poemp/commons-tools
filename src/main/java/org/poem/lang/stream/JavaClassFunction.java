package org.poem.lang.stream;

import org.poem.lang.core.JavaClass;
import org.poem.lang.loader.JavaLoaderMachine;
import org.poem.utils.logger.LoggerUtils;

import java.util.function.Function;

/**
 *
 */
public class JavaClassFunction implements Function<String , JavaClass> {
    @Override
    public JavaClass apply(String s) {
        try {
            return new JavaLoaderMachine(Class.forName(s)).build();
        } catch (ClassNotFoundException e) {
            LoggerUtils.error(e);
            e.printStackTrace();
            return null;
        }
    }
}
