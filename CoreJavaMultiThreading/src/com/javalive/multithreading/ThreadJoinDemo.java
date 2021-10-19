package com.javalive.multithreading;

class DataEntry {
	public void enterData() {
		System.out.println("Entering data to the system.......");
	}
}

class DataValidation {
	public void validateData() {
		System.out.println("Validating data.......");
	}
}

class DataSaving {
	public void saveData() {
		System.out.println("Saving data to the system.......");
	}
}

class DataArchive {
	public void archivData() {
		System.out.println("Archiveing data.......");
	}
}

class DataEntryThread implements Runnable {
	private DataEntry dataEntryObject;

	public DataEntryThread(DataEntry dataEntryObject) {
		this.dataEntryObject = dataEntryObject;
	}

	public void run() {
		dataEntryObject.enterData();
	}
}

class DataValidationThread implements Runnable {
	private DataValidation dataValidationObject;

	public DataValidationThread(DataValidation dataValidationObject) {
		this.dataValidationObject = dataValidationObject;
	}

	public void run() {
		dataValidationObject.validateData();
	}
}

class DataSavingThread implements Runnable {
	private DataSaving dataSavingObject;

	public DataSavingThread(DataSaving dataSavingObject) {
		this.dataSavingObject = dataSavingObject;
	}

	public void run() {
		dataSavingObject.saveData();
	}
}

class DataArchiveThread implements Runnable {
	private DataArchive dataArchiveObject;

	public DataArchiveThread(DataArchive dataArchiveObject) {
		this.dataArchiveObject = dataArchiveObject;
	}

	public void run() {
		dataArchiveObject.archivData();
	}
}

public class ThreadJoinDemo {
	public static void main(String[] args) {
	DataEntry dataEntryObj = new DataEntry();
	DataValidation dataValidationObj = new DataValidation();
	DataSaving dataSavingObj = new DataSaving();
	DataArchive dataArchivingObj=new DataArchive();
	
	DataEntryThread dataEntryThread=new DataEntryThread(dataEntryObj);
	DataValidationThread dataValidationThread=new DataValidationThread(dataValidationObj);
	DataSavingThread dataSavingThread=new DataSavingThread(dataSavingObj);
	DataArchiveThread dataarchiveThread=new DataArchiveThread(dataArchivingObj);
	
	Thread thread1=new Thread(dataEntryThread);
	thread1.start();
	try {
		thread1.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Thread thread2=new Thread(dataValidationThread);
	thread2.start();
	try {
		thread2.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Thread thread3=new Thread(dataSavingThread);
	thread3.start();
	try {
		thread3.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Thread thread4=new Thread(dataarchiveThread);
	thread4.start();
	}
}
