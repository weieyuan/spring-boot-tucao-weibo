package com.wei.springboottucao.test.thread;

public class Test2 {

	public static void main(String[] arg) throws InterruptedException{
		String aStr = "A";
		String bStr = "A";
		String aStr1 = new String("A");
		String bStr1 = new String("A");
		System.out.println(aStr == bStr); 
		System.out.println(aStr1 == bStr1); 
		System.out.println(aStr == aStr1); 
		
		Service service = new Service();
		
		Runnable r1 = new Runnable(){

			@Override
			public void run() {
				service.runMethod();
			}
			
		};
		

		Runnable r2 = new Runnable(){

			@Override
			public void run() {
				service.stopMethod();
			}
			
		};
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		Thread.sleep(1000);
		t2.start();
		
		
	}
	
	public static class Service{
		private boolean b = true;
		
		public void runMethod(){
			String a = new String();
			while(b){
				synchronized(a){}
			}
			System.out.println("停止。。。。");
		}
		
		public void stopMethod(){
			this.b = false;
		}
	}

}
