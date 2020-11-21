package com.java.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyCloudLogAsyncAspect {

	@Before("com.java.aopdemo.aspect.revoltAopExpressions.forDaoPackageNoGetterSetter()")
	public void logToCLoudAsync() {
		System.out.println("==>> Logging to cloud");
	}
}
