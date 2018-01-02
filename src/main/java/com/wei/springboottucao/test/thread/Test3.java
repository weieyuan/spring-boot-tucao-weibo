package com.wei.springboottucao.test.thread;

public class Test3 {
	
	private static class InnerClass{
		
		private static Test3 test = new Test3();
	}
	
	public static Test3 getInstance(){
		
		return InnerClass.test;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
