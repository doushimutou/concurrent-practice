package com.ayt.example.server.thread;

/**
 * Description
 * Author ayt  on
 * 此demo是为了证明wait()阻塞挂起，只释放当前变量的锁，该线程持有的其他变量的锁不收到影响
 *
 */
public class WaitTest {
	private static volatile Object resourceA = new Object();
	private static volatile Object resourceB = new Object();

	public static void main(String[] args) throws InterruptedException {
		Thread threadA = new Thread(() -> {
			synchronized (resourceA) {
				System.out.println("线程A获取了A锁");
				synchronized (resourceB) {
					System.out.println("线程A获取了B锁");
					try {
						resourceA.wait();
						System.out.println("线程A阻塞挂起，并且释放了resourceA锁");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		});

		Thread threadB = new Thread(() -> {
			try {
				Thread.sleep(1000);
				synchronized (resourceA){
					System.out.println("线程B获取resourceA 锁");
					System.out.println("线程B尝试获取resourceB锁");
					synchronized (resourceB){
						System.out.println("线程B获取了resourceB锁");
						resourceA.wait();
						System.out.println("线程B释放了A的锁");
					}
				}



			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		threadA.start();
		threadB.start();

		threadA.join();
		threadB.join();


	}
}
