package com.ayt.example.server.thread;

/**
 * Description
 * Author ayt  on
 * threadLocal 操作的值是操作线程本地的值
 */
public class ThreadLocalTest {
	static ThreadLocal<String> localVariable = new ThreadLocal<>();

	public static void main(String[] args) {
		Thread threadOne = new Thread(() -> {
			localVariable.set("threadOne local variable");
			print("threadOne");
			System.out.println("threadOne remove after: " + localVariable.get());
		});

		Thread threadTwo = new Thread(() -> {
			localVariable.set("threadTwo local variable");
			print("threadTwo");
			System.out.println("threadTwo remove after: " + localVariable.get());
		});
		threadOne.start();
		threadTwo.start();
	}

	public static void print(String string) {
		System.out.println(string + ":" + localVariable.get());
		//localVariable.remove();
	}
}

