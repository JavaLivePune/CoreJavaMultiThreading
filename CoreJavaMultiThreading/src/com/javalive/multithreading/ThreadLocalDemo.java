package com.javalive.multithreading;

class MyRunnable implements Runnable {
	private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

	public void run() {
		threadLocal.set((int) (Math.random() * 50D));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		System.out.println(threadLocal.get());
	}
}

public class ThreadLocalDemo {
	public static void main(String[] args) {
		MyRunnable runnableInstance = new MyRunnable();
		Thread t1 = new Thread(runnableInstance);
		Thread t2 = new Thread(runnableInstance);
		Thread t3 = new Thread(runnableInstance);
		Thread t4 = new Thread(runnableInstance);
		Thread t5 = new Thread(runnableInstance);
		// this will call run() method
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}

}
