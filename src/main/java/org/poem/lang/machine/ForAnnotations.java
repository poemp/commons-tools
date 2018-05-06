package org.poem.lang.machine;

import org.poem.lang.core.Annotation;
import org.poem.utils.JavaMachineUtils;
import org.poem.utils.collection.Lists;

import java.util.List;

public class ForAnnotations {

    private java.lang.annotation.Annotation[] annotations;

    public ForAnnotations(java.lang.annotation.Annotation[] annotations) {
        this.annotations = annotations;
    }

    public java.lang.annotation.Annotation[] getAnnotations() {
        return annotations;
    }

    public void setAnnotations(java.lang.annotation.Annotation[] annotations) {
        this.annotations = annotations;
    }

    /**
     * build
     * @return
     */
    public List<Annotation> build(){
        List<Annotation> methodExceptions = Lists.empty();
        Annotation annotation;
        if(this.annotations != null && this.annotations.length > 0 ){
            for (java.lang.annotation.Annotation aClass : this.annotations) {
                annotation = new Annotation();
                annotation.setName(aClass.annotationType().getName());
                annotation.setJavaClass(JavaMachineUtils.annotationType(aClass.annotationType()));
                methodExceptions.add(annotation);
            }
            return methodExceptions;
        }
        return null;
    }
}
