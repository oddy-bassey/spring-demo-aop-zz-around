package com.java.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut; 

@Aspect 
public class revoltAopExpressions {
	@Pointcut("execution(* com.java.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	//create pointcut for getter methods
	@Pointcut("execution(* com.java.aopdemo.dao.*.get*(..))")
	public void getters() {}
	
	//create pointcut for setter methods
	@Pointcut("execution(* com.java.aopdemo.dao.*.set*(..))")
	public void setters() {}
	
	//create pointcut to include the package methods, excluding getters and setters
	@Pointcut("forDaoPackage() && !(getters() || setters())")
	public void forDaoPackageNoGetterSetter() {}
}
