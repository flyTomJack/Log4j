package com.atguigu.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
	public static void main(String[] args) throws Exception {
		Thread.currentThread().setName("秦");
		CountDownLatch cdl = new CountDownLatch(6);
		for (int i = 1; i < 7; i++) {
			new Thread(() -> {
				System.out.println(Thread.currentThread().getName()+"国被灭！！");
				cdl.countDown();
			}, SevenCountry.foreachCountryName(i).getCountryName()).start();
		}
		cdl.await();
		System.out.println(Thread.currentThread().getName()+"国统一七国！");
	}
}
