package com.atguigu.thread;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * 多线程
 *
 */
public class ExecutorTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
		for (int i = 0; i < 15; i++) {
			Future<Integer> submit = service.schedule(() -> {
				System.out.print(Thread.currentThread().getName());
				return new Random().nextInt(5);
			},2,TimeUnit.SECONDS);
			System.out.println(" result："+submit.get());
		}
	}

	private static void threadpool() throws InterruptedException, ExecutionException {
		//五线程池
		//ExecutorService service = Executors.newFixedThreadPool(5);
		//单线程池
		//ExecutorService service = Executors.newSingleThreadExecutor();
		//可变线程池
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 15; i++) {
			Future<Integer> submit = service.submit(() -> {
				TimeUnit.SECONDS.sleep(1);
				System.out.print(Thread.currentThread().getName());
				return new Random().nextInt(5);
			});
			System.out.println(" result："+submit.get());
		}
	}
}
