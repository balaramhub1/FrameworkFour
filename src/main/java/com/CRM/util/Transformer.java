package com.CRM.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class Transformer implements IAnnotationTransformer{

	public void transform(ITestAnnotation annot, Class testClass, Constructor constr, Method testMethod) {
		annot.setRetryAnalyzer(RetryAnalyzer.class);
		
	}

}
