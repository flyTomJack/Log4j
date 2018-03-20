package com.atguigu.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class SafeCollection {

	public static void main(String[] args) {
		//方法一，用CopyOnWriteArrayList
		List<String> list = new CopyOnWriteArrayList<>();//new ArrayList<>();
		//方法二，用Collections工具类进行包装，返回的对象为安全的
		List<String> list2 = Collections.synchronizedList(list);
		for (int i = 0; i < 30; i++) {
			new Thread(() -> {
				list.add(UUID.randomUUID().toString().substring(0, 4));
				System.out.println(list);
			}, String.valueOf(i)).start();
		}
	}
}
