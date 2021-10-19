package com.javalive.multithreading;

class Share {
	synchronized void purchaseShare(String sector, int limit) {
		System.out.println("Request made for purchasing " + sector + " shares.");
		try {
			if (limit < 800) {
				System.out.println("Waiting......");
				wait();
			}
			System.out.println("Purchase process initiated as limit reaches for mentiond sector.");
		} catch (Exception e) {// Here much more specific Exception should mentioned as per business.
			// Logic to handle the exception.
		}
		System.out.println("Purchasing complated successfully.");
	}

	synchronized void chceckLimit(String sector, int limit) {
		int sharePrice = 800;
		System.out.println("In check limit");
		while (sharePrice > limit) {
			sharePrice = sharePrice - 100;
			System.out.println("In while loop");
			/*
			 * try { Thread.sleep(5); } catch (InterruptedException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */
		}
		System.out.println("After while loop.");
		notifyAll();
	}
}

class SharePurchasing implements Runnable {
	private Share shareObj;

	public SharePurchasing(Share shareObj) {
		super();
		this.shareObj = shareObj;
	}

	public void run() {
		shareObj.purchaseShare("Banking", 500);
	}

}

class ShareMonitoring implements Runnable {
	private Share shareObj;

	public ShareMonitoring(Share shareObj) {
		super();
		this.shareObj = shareObj;
	}

	public void run() {
		// shareObj.purchaseShare("Banking", 500);
		shareObj.chceckLimit("Banking", 500);
	}

}

public class InterThreadCommunicationDemo {
	public static void main(String[] args) {
		Share share = new Share();
		SharePurchasing purchase = new SharePurchasing(share);
		ShareMonitoring monitor = new ShareMonitoring(share);
		Thread t1 = new Thread(purchase);
		t1.start();
		Thread t2 = new Thread(monitor);
		t2.start();
		Thread t3 = new Thread(purchase);
		t3.start();
	}

}
