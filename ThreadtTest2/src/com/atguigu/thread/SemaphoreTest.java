package com.atguigu.thread;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {

	//车位数
	public static final int count = 3;
	
	public static void main(String[] args) {
		
		Semaphore semaphore = new Semaphore(count);
		for (int i = 1; i <= 6; i++) {
			new Thread(() -> {
				try {
					semaphore.acquire();
					System.out.println(Thread.currentThread().getName()+"车抢到车位！");
					TimeUnit.SECONDS.sleep(new Random().nextInt(5));
					System.out.println(Thread.currentThread().getName()+"车离开！");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					semaphore.release();
				}
			}, String.valueOf(i)).start();
		}
	}
}
