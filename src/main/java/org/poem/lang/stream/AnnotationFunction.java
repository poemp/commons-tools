package org.poem.lang.stream;

import org.poem.lang.context.JavaContext;
import org.poem.utils.JavaMachineUtils;

import java.lang.annotation.Annotation;
import java.util.function.Function;

public class AnnotationFunction implements Function<Annotation, org.poem.lang.core.Annotation> {
    @Override
    public org.poem.lang.core.Annotation apply(Annotation annotation) {
        org.poem.lang.core.Annotation poemAnnotation = new org.poem.lang.core.Annotation();
        poemAnnotation.setName(annotation.annotationType().getName());
        poemAnnotation.setJavaClass(JavaMachineUtils.annotationType(annotation.annotationType()));
        return JavaContext.canPush(annotation.annotationType().getName(), poemAnnotation);
    }
}
