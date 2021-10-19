package com.javalive.multithreading;

/**
 * @author JavaLive.com
 * @description Daemon thread in Java Daemon thread is a low priority thread
 *              that runs in background to perform tasks such as garbage
 *              collection.
 * 
 *              Properties:
 * 
 *              They can not prevent the JVM from exiting when all the user
 *              threads finish their execution. JVM terminates itself when all
 *              user threads finish their execution If JVM finds running daemon
 *              thread, it terminates the thread and after that shutdown itself.
 *              JVM does not care whether Daemon thread is running or not. It is
 *              an utmost low priority thread. Methods:
 * 
 *              1.void setDaemon(boolean status): This method is used to mark
 *              the current thread as daemon thread or user thread. For example
 *              if I have a user thread tU then tU.setDaemon(true) would make it
 *              Daemon thread. On the other hand if I have a Daemon thread tD
 *              then by calling tD.setDaemon(false) would make it user thread.
 *              Syntax: public final void setDaemon(boolean on) parameters: on :
 *              if true, marks this thread as a daemon thread. exceptions:
 *              IllegalThreadStateException: if only this thread is active.
 *              SecurityException: if the current thread cannot modify this
 *              thread. 2. boolean isDaemon(): This method is used to check that
 *              current is daemon. It returns true if the thread is Daemon else
 *              it returns false. Syntax: public final boolean isDaemon()
 *              returns: This method returns true if this thread is a daemon
 *              thread; false otherwise
 * 
 *              Daemon vs User Threads
 * 
 *              1. Priority: When the only remaining threads in a process are
 *              daemon threads, the interpreter exits. This makes sense because
 *              when only daemon threads remain, there is no other thread for
 *              which a daemon thread can provide a service. 2. Usage: Daemon
 *              thread is to provide services to user thread for background
 *              supporting task.
 */
public class DaemonThreadDemo extends Thread{
	public DaemonThreadDemo(String name){ 
        super(name); 
    }

	public void run() {
		// Checking whether the thread is Daemon or not
		if (Thread.currentThread().isDaemon()) {
			System.out.println(getName() + " is Daemon thread");
		}

		else {
			System.out.println(getName() + " is User thread");
		}
	}

	public static void main(String[] args) {

		DaemonThreadDemo t1 = new DaemonThreadDemo("t1");
		DaemonThreadDemo t2 = new DaemonThreadDemo("t2");
		DaemonThreadDemo t3 = new DaemonThreadDemo("t3");

		// Setting user thread t1 to Daemon
		t1.setDaemon(true);

		// starting first 2 threads
		t1.start();
		t2.start();

		// Setting user thread t3 to Daemon
		t3.setDaemon(true);
		t3.start();
	}
}
