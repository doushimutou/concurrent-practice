package com.ayt.example.server.thread.instructiontest;

/**
 * Description
 * Author ayt  on
 */
public class InstructionTest {
	private static  int num = 0;
	private static   boolean ready = false;

	public static class ReadThreadTest extends Thread {

		@Override
		public void run() {
			while (!Thread.currentThread().isInterrupted()) {
				if (ready) {
					System.out.println(num + num);
				}
				System.out.println("ready thread ....");
			}
		}
	}

	public static class WriteThreadTest extends Thread {

		@Override
		public void run() {
			num = 2;
			ready = true;
			System.out.println("writeThread set over...");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ReadThreadTest readThreadTest = new ReadThreadTest();
		readThreadTest.start();

		WriteThreadTest writeThreadTest = new WriteThreadTest();
		writeThreadTest.start();

		Thread.sleep(1000);
		readThreadTest.interrupt();
		System.out.println("main exit ");
	}

}
