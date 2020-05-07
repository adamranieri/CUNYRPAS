package dev.ranieri.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
// Imagine your manager says we need to log how many times people make an http request to this application
	// logging, security, formatting
	
	private int counter = 0;
		

	// This an advice method
	@Before("logJP()")     // this advice method will be called before the joinpoints specified are executed
	public void logInfo() {
		System.out.println("This many calls have been made to the application : " + ++counter);
	}
	
	// this pointcut expression will apply to every method in the associate controller
	// your methods are you joinpoints
	@Pointcut("execution(* dev.ranieri.controllers.AssociateController.*(..))")
	private void logJP() {};
	
	// @After -- advice run after any method call
	// @AfterReturning -- advice run after a method returns succses
	// @AfterThrowing -- advice run after a method throws an error/exception
	// @Before
	// @Around

	// returns from an advised method must be an Object. no primitives
}
