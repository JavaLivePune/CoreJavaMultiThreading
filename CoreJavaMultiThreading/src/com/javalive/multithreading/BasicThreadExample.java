package com.javalive.multithreading;

/**
 * Hello world!
 *
 */

class RunnableThread implements Runnable{

	public void run() {
		
		System.out.println("This is run method of RunnableThread class......");
		new BasicThreadExample().displayNumbers(2);
	}
	
}
public class BasicThreadExample extends Thread
{
	public void run() {
		System.out.println("In thread "+ Thread.currentThread().getName());
		displayNumbers(11);
	}
	public void displayNumbers(int num){
		System.out.println("In the method displayNumbers()");
		for(int i=1;i<=10;i++)
		  {
			  System.out.println(num*i);
		  try { Thread.sleep(500);
		  
		  }catch(Exception e){System.out.println(e);}
		    
		  }
		  System.out.println("=============================================");
	}
    public static void main( String[] args )
    {
    	/*BasicThreadExample obj1=new BasicThreadExample();
    	BasicThreadExample obj2=new BasicThreadExample();
    	obj1.setName("MyThread1");
    	System.out.println("First thread calling start() method");
    	obj1.start();
    	obj2.setName("MyThread2");
    	System.out.println("Second thread calling start() method");
    	obj2.start();
    	System.out.println("=====================++++++++++++++++++++++++++++===============================================");
    	System.out.println("First thread calling display() method");
    	obj1.displayNumbers(11);
    	System.out.println("\nSecond thread calling display() method");
    	obj2.displayNumbers(5);*/
    	
    	Thread t1= new Thread(new RunnableThread());
    	t1.start();
    	
    }
    
}
