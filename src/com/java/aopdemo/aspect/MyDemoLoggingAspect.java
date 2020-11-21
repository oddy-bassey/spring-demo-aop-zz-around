package com.java.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before; 
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.java.aopdemo.dao.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	@Before("com.java.aopdemo.aspect.revoltAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("==>> Executing @Before advice on method");
		
		//display the method signature
		MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
		System.out.println("Signature - "+methodSignature.toString());
		
		//display the method arguments
		Object[] args = joinPoint.getArgs();
		
		for(Object argument : args) {
			System.out.println(argument);
			
			if(argument instanceof Account) {
				Account account = (Account) argument;
				
				System.out.println("Name: "+account.getName());
				System.out.println("Level: "+account.getLevel());
			}
		}
		
	}
	
	//Add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(pointcut = "execution(* com.java.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		
		//print out method we're advising on
		String method = joinPoint.getSignature().toLongString();
		System.out.println("\n===> Executing @AfterReturning on method: "+method);
		
		//print out the results of the method
		System.out.println("\n===> Result is: "+result);
		
		//Lets first post process the data, then modify it before it makes it to the calling program :-)
		
		//convert the account names to uppercase
		convertToUpperCase(result);
		
		//Reprint the results of the method
		System.out.println("\n===> Result is: "+result);
	}

	private void convertToUpperCase(List<Account> result) {
		
		// loop through acounts
		for(Account account : result) {
		
			//get uppercase version of name
			String uppercaseName = account.getName().toUpperCase();
		
			//update the name of the account
			account.setName(uppercaseName);
		}
	}
	
	//Add a new advice for @AfterThrowing on the findAccounts method
	@AfterThrowing(pointcut = "execution(* com.java.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "exception")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception) {
		
		//print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n===> Executing @AfterThrowing on method: "+method);
		
		//log the exception
		System.out.println("\n===> The exception is: "+exception);
		
	}
	
	//Add a new advice for @After on the findAccounts method
	@After("execution(* com.java.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		
		//print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n===> Executing @After on method: "+method);
	}
	
	//Add a new advice for @Around on FortuneService
	@Around("execution(* com.java.aopdemo.service.*.getFortune(..))")
	public Object aroundgetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		
		//print out method we are advising on
		String method = proceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n===> Executing @After on method: "+method);
		
		//get beginning timeStamp
		long begin = System.currentTimeMillis();
		
		//execute the method
		Object result = proceedingJoinPoint.proceed();
		
		//get end timeStamp
		long end = System.currentTimeMillis();
		
		//compute duration and display it
		long duration = end-begin;
		System.out.println("\n==>> Duration: "+ duration/1000.0 +"seconds");
		
		return result;
	}
}























