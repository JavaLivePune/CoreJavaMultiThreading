package com.javalive.multithreading;

class MultithreadingDemo1 extends Thread {
	public void run() {
		try {
			// Displaying the thread that is running
			System.out.println("Thread " + Thread.currentThread().getId() + " is running");

		} catch (Exception e) {
			// Throwing an exception
			System.out.println("Exception is caught");
		}
	}
}

public class ThreadCreationUsingThreadClass {
	public static void main(String[] args) {
		int n = 8; // Number of threads
		for (int i = 0; i < 8; i++) {
			MultithreadingDemo1 object = new MultithreadingDemo1();
			object.start();
		}
	}
}
