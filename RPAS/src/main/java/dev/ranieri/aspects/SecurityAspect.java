package dev.ranieri.aspects;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
public class SecurityAspect {
	
	// I want a method that will read incoming http requests
	// check their headers and make sure that the request contains an api key with 
	// an appropiate password
	
	// advice method
	@Around("securityJP()")// @Around is the most powerful type of advice one can give
	// it allows you to intercept the execution of a method and alter both the input parameters
	// and the output if you so choose
	
	//pjp is the method call. Object representing a method about to be executed
	public Object authenticate(ProceedingJoinPoint pjp) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
	    HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
		
	    String auth = request.getHeader("Authorization");
	    
	    if(auth != null && auth.equals("pa$$word")) { // if the header is correct
	    	Object obj = pjp.proceed();// please continue the method's executinion
	    	return obj;// the returned object is the return of the advised method //
	    }else {
	    	response.sendError(401);
	    	return null;
	    }
	    
	}

	// applies to every method that has @Authorized above it
	@Pointcut("@annotation(dev.ranieri.aspects.Authorized)")
	private void securityJP() {};// hook method
}
