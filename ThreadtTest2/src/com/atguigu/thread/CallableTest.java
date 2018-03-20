package com.atguigu.thread;

import java.util.Hashtable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
/**
 * 获得线程第三种方式：新建futureTask对象（构造器中放入实现callable接口的类的对象）
 * 然后新建线程，构造器中传入新建的futureTask对象
 * 新建的线程为多用于耗时的计算，并且有返回值
 * 这种方法的特点： 1.有返回值 
 * 			   2.接口中的方法有异常抛出
 * 			   3.有泛型，而且泛型和返回值类型相同
 *    		   4.名称值不同
 * 			   5.返回的计算结果不会重复计算，只会计算一次
 * 			   6.得到结果的get()方法需放到最后，如果放到前面，会阻塞主线程
 */
public class CallableTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<Student> task = new FutureTask<>(new MyThread());
		//lambda表达式
		FutureTask<Student> task2 = new FutureTask<Student>(() -> {
			Thread.sleep(3000);
			return new Student(608, "康大宝子");
		});
		new Thread(task,"萧平章").start();
		new Thread(task2,"萧平旌").start();
		
		System.out.println(Thread.currentThread().getName()+"线程：正在运行");
		Student student = task.get();
		Student student2 = task2.get();
		System.out.println(student);
		System.out.println(student2);
	}
}
class MyThread implements Callable<Student>{
	@Override
	public Student call() throws Exception {
		return new Student(102684,"啊小凡达");
	}
}
class Student{
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
}
