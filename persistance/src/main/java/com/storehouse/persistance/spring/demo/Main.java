package com.storehouse.persistance.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext actx = new ClassPathXmlApplicationContext("bean.xml");
		Printer printer = (Printer) actx.getBean("proxy");
		printer.printNumbers();
		printer.printHelloWorld();
	}
}
