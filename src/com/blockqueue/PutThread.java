package com.blockqueue;

public class PutThread implements Runnable{

	public MyBlockQueue mbq ;
	
	public PutThread(MyBlockQueue mbq ){
		this.mbq = mbq;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			mbq.put(Thread.currentThread().getName()+"--");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
