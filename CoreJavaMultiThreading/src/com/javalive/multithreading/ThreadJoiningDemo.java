package com.javalive.multithreading;

/**
 * @author JavaLive.com
 * @description java.lang.Thread class provides the join() method which allows
 *              one thread to wait until another thread completes its execution.
 *              If t is a Thread object whose thread is currently executing,
 *              then t.join() will make sure that t is terminated before the
 *              next instruction is executed by the program. If there are
 *              multiple threads calling the join() methods that means
 *              overloading on join allows the programmer to specify a waiting
 *              period. However, as with sleep, join is dependent on the OS for
 *              timing, so you should not assume that join will wait exactly as
 *              long as you specify. There are three overloaded join functions.
 * 
 *              1. join(): It will put the current thread on wait until the
 *              thread on which it is called is dead. If thread is interrupted
 *              then it will throw InterruptedException. Syntax: public final
 *              void join()
 * 
 *              2. join(long millis) :It will put the current thread on wait
 *              until the thread on which it is called is dead or wait for
 *              specified time (milliseconds). Syntax: public final synchronized
 *              void join(long millis)
 * 
 *              3. join(long millis, int nanos): It will put the current thread
 *              on wait until the thread on which it is called is dead or wait
 *              for specified time (milliseconds + nanos). Syntax: public final
 *              synchronized void join(long millis, int nanos)
 * 
 */

// Java program to explain the
// concept of joining a thread.
// Creating thread by creating the
// objects of that class

class ThreadJoining extends Thread {
	public ThreadJoining(String threadName) {
		super.setName(threadName);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void run() {
		for (int i = 0; i < 2; i++) {
			try {
				Thread.sleep(500);
				System.out.println("Current Thread: " + Thread.currentThread().getName());
			}

			catch (Exception ex) {
				System.out.println("Exception has" + " been caught" + ex);
			}
			System.out.println(i);
		}
	}
}

public class ThreadJoiningDemo extends Thread {
	public static void main(String[] args) {

		// creating two threads
		ThreadJoining t1 = new ThreadJoining("Create Account");
		ThreadJoining t2 = new ThreadJoining("Add to cart");
		ThreadJoining t3 = new ThreadJoining("Make payment");

		// thread t1 starts
		t1.start();

		// starts second thread after when
		// first thread t1 has died.
		try {
			System.out.println("Current Thread: " + Thread.currentThread().getName());
			t1.join();
		}

		catch (Exception ex) {
			System.out.println("Exception has " + "been caught" + ex);
		}

		// t2 starts
		t2.start();

		// starts t3 after when thread t2 has died.
		try {
			System.out.println("Current Thread: " + Thread.currentThread().getName());
			t2.join();
		}

		catch (Exception ex) {
			System.out.println("Exception has been" + " caught" + ex);
		}

		t3.start();
	}
}
