package com.ayt.example.server.thread;

/**
 * Description
 * Author ayt  on
 * 线程wait后，被中断会抛interruptExcetion异常
 */
public class WaitNotifyInterupt {
	private static Object obj = new Object();

	public static void main(String[] args) throws InterruptedException {
		Thread threadA = new Thread(() -> {
			try {
				synchronized (obj) {
					System.out.println("--begin");
					obj.wait();
				}
				System.out.println("----end");
			} catch (Exception e) {
				System.out.println("出错了");
			}
		});
		threadA.start();
		Thread.sleep(10000);
		System.out.println("begin interrupt threadA");
		threadA.interrupt();
		System.out.println("end interrupt threadA");

	}
}
