package org.poem.lang.machine;

import org.poem.lang.annotation.JavaAnnotationContext;

import java.util.function.Predicate;

public class ForAnnotationFilter<Annotation> implements Predicate<java.lang.annotation.Annotation> {

    @Override
    public boolean test(java.lang.annotation.Annotation annotation) {
        return !JavaAnnotationContext.has(annotation.annotationType().getName());
    }
}
