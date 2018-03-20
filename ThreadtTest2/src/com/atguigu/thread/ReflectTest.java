package com.atguigu.thread;

public class ReflectTest {

	public static void main(String[] args) {
		Customer c1 = new Customer(1, "仇");
		System.out.println(c1.getClass().getClassLoader().getParent().getParent());
		System.out.println(c1.getClass().getClassLoader().getParent());
		System.out.println(c1.getClass().getClassLoader());
		System.out.println(c1.getClass());
	}
	
}
class Customer{
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
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	public Customer(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
