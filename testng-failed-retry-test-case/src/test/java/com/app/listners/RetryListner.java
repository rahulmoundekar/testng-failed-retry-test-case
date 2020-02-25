package com.app.listners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class RetryListner implements IAnnotationTransformer {

	public void transform(ITestAnnotation testAnnotation, Class arg1, Constructor arg2, Method arg3) {
		IRetryAnalyzer analyzer = testAnnotation.getRetryAnalyzer();
		if (analyzer == null) {
			testAnnotation.setRetryAnalyzer(Retry.class);
		}

	}

}
