package com.blockqueue;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockQueue {
	
	private ReentrantLock lock = new ReentrantLock() ;
	
	Condition write = lock.newCondition() ;
	Condition read = lock.newCondition() ;
	
	private Object[] item ;
	
	private int count ,takeIndex,putIndex;

	public MyBlockQueue(int length) {
		item = new Object[length];
		count = 0;
	}
	
	
	public Object take() throws InterruptedException {
		
		lock.lockInterruptibly(); 
		try {
			while(count==0){
				System.out.println("take等待中");
				read.await();
			}
			Object o = item[takeIndex];
			item[takeIndex] = null ;
			if(takeIndex++==item.length){
				takeIndex=0;
			}
			count-- ;
			write.signal();
			return o ;
			
		} finally{
			lock.unlock();
		}
		
	}
	
	public void put(Object o) throws InterruptedException{
		
		lock.lockInterruptibly();
		try{
			while(count==item.length){
				System.out.println("put等待中");
				write.await();
			}
			item[putIndex] = o ;
			if(putIndex++==item.length){
				putIndex = 0 ;
			}
			count ++ ;
			System.out.println(o);
			read.signal();
			
		}finally{
			lock.unlock();
		}
		
		
	}
	
}
