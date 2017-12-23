package com.wei.springboottucao.test.thread;

public class Test1 {
	
	
	public static class MyThreadLocal extends InheritableThreadLocal<String>{
		
		protected String initialValue() {
	        return "ABC";
	    }
		
		 protected String childValue(String parentValue) {
		        return parentValue + "DEF";
		    }
		
	}

	public static MyThreadLocal LOCAL = new MyThreadLocal();
	
	public static class Thread1 extends Thread{
		
		public void run() {
			String str = LOCAL.get();
			System.out.println("Thread:" + Thread.currentThread().getName() + ":" + str); 
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LOCAL.set("child");
			str = LOCAL.get();
			System.out.println("Thread:" + Thread.currentThread().getName() + ":" + str); 
	    }
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread1 t1 = new Thread1();
		t1.start();
		Thread.sleep(2000);
		
		String str = LOCAL.get();
		System.out.println("Thread:" + Thread.currentThread().getName() + ":" + str);
//		Thread1 t1 = new Thread1();
//		t1.start();
		Thread.sleep(2000);
		LOCAL.set("Parent");
		str = LOCAL.get();
		System.out.println("Thread:" + Thread.currentThread().getName() + ":" + str);
		
		
	}

}
