package com.jack.aop;

import javassist.bytecode.stackmap.TypeData.ClassName;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SysLogAspectJ {
	private static Logger log = Logger.getLogger(ClassName.class);
	@Before(value = "execution(* com.jack.service.impl.*.*(..))")
	public void beforeDao(JoinPoint point) {
		log.info( point.getTarget().toString() + " before........");
	}

	@After(value = "execution(* com.jack.service.impl.*.*(..))")
	public void afterDao(JoinPoint point) {
		log.info(point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName() + "  after........");
	}
}
