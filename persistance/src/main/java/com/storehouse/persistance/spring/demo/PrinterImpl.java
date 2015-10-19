package com.storehouse.persistance.spring.demo;

public class PrinterImpl implements Printer {
	Ink ink;

	public PrinterImpl(Ink ink) {
		this.ink = ink;
	}

	public void printHelloWorld() {
		System.out.println("Hello World printed with "+ink.getColor());

	}

	public void printNumbers() {
		System.out.println("0 1 2 3 4 5 6 7 8 9");
		
	}

}
