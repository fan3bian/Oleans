package com.b5;

public class HelloWorld {
	private String message;

	public HelloWorld() {
		// System.out.println("no param constructor");
	}

	public HelloWorld(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void init2() {
		System.out.println("Bean is going through init.");
	}

	public void destroy2() {
		System.out.println("Bean will destroy now.");
	}

}
