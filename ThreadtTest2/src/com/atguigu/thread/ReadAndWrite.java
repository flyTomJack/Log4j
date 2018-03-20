package com.atguigu.thread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadAndWrite {
	public static void main(String[] args) {
		ReadWriteResource resource = new ReadWriteResource();
		new Thread(() -> {
			resource.write("java精通");
		}, "老师").start();
		for (int i = 1; i <= 100; i++) {
			new Thread(() -> {
				resource.read();
			}, String.valueOf(i)).start();
		}
	}
}
class ReadWriteResource{
	private Object object;
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	
	public void write(Object writeObject) {
		lock.writeLock().lock();
		try {
			object = writeObject;
			System.out.println(Thread.currentThread().getName()+"写入了"+writeObject);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.writeLock().unlock();
		}
	}
	public void read() {
		lock.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName()+"读取了"+object);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.readLock().unlock();
		}
	}
}
