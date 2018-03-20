package com.atguigu.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

	public static final int number = 7;
	
	public static void main(String[] args) {
		CyclicBarrier cb = new CyclicBarrier(number, () -> {
			System.out.println(Thread.currentThread().getName()+"召唤神龙！");
		});
		
		for (int i = 1; i <= number; i++) {
			int temp = i;
			new Thread(() -> {
				System.out.println(Thread.currentThread().getName()+"第"+temp+"星龙珠被收集！");
				try {
					cb.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			}, String.valueOf(i)).start();
		}
	}
}
