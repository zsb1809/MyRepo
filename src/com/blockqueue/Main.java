package com.blockqueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	
	public static void main(String[] args) {
		
		MyBlockQueue myb = new MyBlockQueue(12);
		ExecutorService es1 = Executors.newFixedThreadPool(5);
		ExecutorService es2 = Executors.newFixedThreadPool(10);
		
		/*es1.submit(new TakeThread(myb));
		es1.submit(new TakeThread(myb));
		es1.submit(new TakeThread(myb));
		es1.submit(new TakeThread(myb));
		es1.submit(new TakeThread(myb));*/
		
		while(true){
			es1.submit(new TakeThread(myb));
			es2.submit(new PutThread(myb));
		}
		/*
		es2.submit(new PutThread(myb));
		es2.submit(new PutThread(myb));
		es2.submit(new PutThread(myb));
		*/
	}
}
