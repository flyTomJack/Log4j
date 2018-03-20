package com.atguigu.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**~~~呼啦圈，三个线程循环调用~~~~
 * 多线程之间按顺序调用，实现A->B->C
 * 三个线程启动，要求如下：
 * AA打印5次，BB打印10次，CC打印15次
 * 接着
 * AA打印5次，BB打印10次，CC打印15次
 * ......来10轮  
 */
public class OrderThread {
	public static void main(String[] args) {
		Resource resource = new Resource();
		new Thread(() -> { 
			for (int i = 1; i <= 10; i++) {
				resource.print5(i);
			}
		}, "AA").start();
		new Thread(() -> { 
			for (int i = 1; i <= 10; i++) {
				resource.print10(i);
			}
		}, "BB").start();
		new Thread(() -> { 
			for (int i = 1; i <= 10; i++) {
				resource.print15(i);
			}
		}, "CC").start();
	}
}
//资源类
class Resource{
	private char flag = 'A';//分别代表三个线程
	private Lock lock = new ReentrantLock();
	private Condition c1 = lock.newCondition();
	private Condition c2 = lock.newCondition();
	private Condition c3 = lock.newCondition();
	
	public void print5(int loop) {
		try {
			lock.lock();
			//1.判断
			while (flag != 'A') {
				c1.await();
			}
			//2.干活
			for (int i = 1; i <= 5; i++) {
				System.out.println(Thread.currentThread().getName()+"线程：第"+loop+"轮，打印第"+i+"次");
			}
			//3.通知
			//将代表线程的flag修改
			flag = 'B';
			c2.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	public void print10(int loop) {
		try {
			lock.lock();
			//1.判断
			while (flag != 'B') {
				c2.await();
			}
			//2.干活
			for (int i = 1; i <= 10; i++) {
				System.out.println(Thread.currentThread().getName()+"线程：第"+loop+"轮，打印第"+i+"次");
			}
			//3.通知
			//将代表线程的flag修改
			flag = 'C';
			c3.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	public void print15(int loop) {
		try {
			lock.lock();
			//1.判断
			while (flag != 'C') {
				c3.await();
			}
			//2.干活
			for (int i = 1; i <= 15; i++) {
				System.out.println(Thread.currentThread().getName()+"线程：第"+loop+"轮，打印第"+i+"次");
			}
			//3.通知
			//将代表线程的flag修改
			flag = 'A';
			c1.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
