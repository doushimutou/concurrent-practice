package com.ayt.example.server.thread;

/**
 * Description
 * Author ayt  on
 * 死锁：资源互斥性、请求并持有、不可剥夺、环路等待
 * 避免死锁方法：破坏其一即可；请求持有和环路等待可以破坏；保持请求资源有序性可以避免死锁
 */
public class DeadLockTest {
	private static Object resourceA = new Object();
	private static Object resourceB = new Object();

	public static void main(String[] args) {
		Thread threadA = new Thread(() -> {
			synchronized (resourceA) {

				System.out.println("线程A获取资源A");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("线程A等待获取资源B");
				synchronized (resourceB) {
					System.out.println("线程A获取资源B");
				}
			}
		});
		Thread threadB = new Thread(() -> {
			synchronized (resourceB) {

				System.out.println("线程B获取资源B");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("线程B等待获取资源a");
				synchronized (resourceA) {
					System.out.println("线程b获取资源a");
				}
			}
		});
		threadA.start();
		threadB.start();
	}
}
