package com.ayt.example.server.thread;

/**
 * Description
 * Author ayt  on
 */
public class JoinInterrupt {
	public static void main(String[] args) {
		Thread threadOne = new Thread(() -> {
			System.out.println("threadOne begin run!");
		});
		final Thread thread = Thread.currentThread();

		Thread threadTwo = new Thread(() -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//中断主线程
			thread.interrupt();
		});
		threadOne.start();
		//延迟启动
		threadTwo.start();
		try {
			threadOne.join();
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
}
