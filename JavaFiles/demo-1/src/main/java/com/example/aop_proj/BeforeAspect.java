package com.example.aop_proj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//AOP CONFIGURATION
@Aspect
@Configuration
public class BeforeAspect {
	private Logger logger=LoggerFactory.getLogger(this.getClass())	;
	
	//what kind of method calls do i intercept
	//Pointcut: Defines the "where" of AOP, specifying the join points (method executions, field accesses, etc.) where the advice should be applied. It uses expressions to match methods or classes.
	//Aspect: The combination of pointcuts and advice. 
	//Join Point: A specific point in the execution of the application, such as a method call or exception handling, where advice can be applied.
	//Pointcut-->execution(* PACKAGE*.*(..))
	
	@Before("execution(* com.example.aop_proj*.*(..))")
	public void before(JoinPoint jp) {
		//advice--do this when u encounter pointcut
		//Joinpoint-->instance of execution ,contains info of class/method being intercepted
		logger.info("Intercepted calls {}- ",jp);
	}
}
