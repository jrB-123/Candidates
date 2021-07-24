package com.proj.controller;

public class Controller {
	// - - > DECLARATIONS
	
	public Controller() {} // empty constructor
	
	public boolean passwordCheck(String xusername, String xpassword) {
		boolean flag = false;
		System.out.println(xusername + " " + xpassword);
		
		if(xusername.contentEquals("mapua123") && xpassword.contentEquals("2019102829")) {
			flag = true;
			System.out.println("correct");
			return flag;
		}else {
			System.out.println("incorrect");
			return flag;
		}
	}
}
