package org.poem.lang.stream;


import org.poem.lang.machine.ForAnnotations;
import org.poem.utils.JavaMachineUtils;

import java.lang.reflect.Field;
import java.util.function.Function;

/**
 *
 */
public class FieldFunction implements Function<Field, org.poem.lang.core.field.Field> {

    /**
     * @param field
     * @return
     */
    @Override
    public org.poem.lang.core.field.Field apply(Field field) {
        org.poem.lang.core.field.Field poemField = new org.poem.lang.core.field.Field();
        poemField.setName(field.getName());
        poemField.setJavaClass(JavaMachineUtils.buildClass(field.getClass()));
        poemField.setAnnotations(new ForAnnotations(field.getDeclaredAnnotations()).build());
        return poemField;

    }
}