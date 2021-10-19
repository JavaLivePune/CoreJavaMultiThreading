package com.javalive.multithreading;

class TableDemo {

	synchronized static void printTable(int n) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(n * i);
			try {
				Thread.sleep(400);
			} catch (Exception e) {
			}
		}
	}
}

class MyThread3 extends Thread {
	public void run() {
		TableDemo.printTable(1);
	}
}
/*
class MyThread4 extends Thread {
	public void run() {
		TableDemo.printTable(10);
	}
}

class MyThread5 extends Thread {
	public void run() {
		TableDemo.printTable(100);
	}
}

class MyThread6 extends Thread {
	public void run() {
		TableDemo.printTable(1000);
	}
}
*/
public class StaticSynchronizationDemo {
	public static void main(String t[]) {
		MyThread3 t1 = new MyThread3();
		MyThread3 t5 = new MyThread3();
		/*MyThread4 t2 = new MyThread4();
		MyThread5 t3 = new MyThread5();
		MyThread6 t4 = new MyThread6();*/
		t1.start();t5.start();
		/*t2.start();
		t3.start();
		t4.start();*/
	}

}
