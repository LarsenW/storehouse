package com.storehouse.persistance.spring.demo;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class Recomend implements MethodBeforeAdvice {

	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("Before");

	}

}
