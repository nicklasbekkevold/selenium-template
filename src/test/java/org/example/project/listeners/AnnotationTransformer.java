package org.example.project.listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformer implements IAnnotationTransformer {

    /**
     * Retry test on failure
     **/
    @Override
    public void transform(ITestAnnotation testAnnotation, Class testClass, Constructor testConstructor, Method testMethod) {
        testAnnotation.setRetryAnalyzer(RetryAnalyzer.class);
    }

}