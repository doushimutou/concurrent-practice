package com.ayt.example.server.thread;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Description
 * Author ayt  on
 * AtomicLong 与 long   atomicLong 底层是unsafe 机制，使用cas原理
 * 非阻塞性的原子操作类
 */
public class AtomicLongTest {
	private static AtomicLong atomicLong = new AtomicLong();
	private static Long num = 0L;
	private static Integer[] arrayOne = new Integer[]{0, 1, 5, 0, 0,0, 1, 5, 0, 0};
	private static Integer[] arrayTwo = new Integer[]{1, 5, 40, 0, 0,1, 5, 40, 0, 0};

	public static void main(String[] args) throws InterruptedException {
		Thread threadOne = new Thread(() -> {
			int size = arrayOne.length;
			for (int i = 0; i < size; i++) {
				if (arrayOne[i].intValue() == 0) {
					atomicLong.incrementAndGet();
					num++;
				}
			}
		});

		Thread threadTwo = new Thread(() -> {
			int size = arrayTwo.length;
			for (int i = 0; i < size; i++) {
				if (arrayTwo[i].intValue() == 0) {
					atomicLong.incrementAndGet();
					num++;
				}
			}
		});
		threadOne.start();
		threadTwo.start();

		threadOne.join();
		threadTwo.join();
		System.out.println("count 0 :" + atomicLong.get());
		System.out.println("count 0 :" + num);
	}
}
