package com.javalive.multithreading;

public class ThreadSynchronizationDemo {
	public static void main(String args[])
	 {
		 Second d=new Second();
		 Third ob1=new Third (d,5);
		 Third ob3=new Third (d,20);
		 Fourth ob2=new  Fourth(d);
	     ob1.start();
	     ob2.start();
	     ob3.start();
	 }
}
class Second
{
  public synchronized void print(int n)
  {
	  for(int i=1;i<=10;i++)
	  {
		  System.out.println(n*i);
	  try { Thread.sleep(500);
	  
	  }catch(Exception e){System.out.println(e);}
	    
	  }
	  System.out.println("=============================================");
  }
}
 class Third extends Thread
 {
	 Second d;
	 int i;
	 Third(Second d, int i)
	 {
		this.d=d;
		this.i=i;
	 }
   public void run()
   {
	   d.print(i);
   }
 
 }
  
 class Fourth extends Thread
 {
	 Second d;
	 Fourth(Second d)
	 {
		this.d=d;
	 }
	 public void run()
	   {
		   d.print(10);
	   }
	 }
  