package com.ayt.example.server.thread;

/**
 * Description
 * Author ayt  on
 */
public class JoinTest {
	public static void main(String[] args) throws InterruptedException {
		Thread threadOne = new Thread(() -> {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("child threadOne over");

		});

		Thread threadTwo = new Thread(() -> {

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("child threadTwo over");
		});
		threadOne.start();
		threadTwo.start();
		System.out.println("wait all child thread over");
		threadOne.join();
		threadTwo.join();
	}
}
