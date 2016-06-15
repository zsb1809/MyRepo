package com.blockqueue;

public class TakeThread implements Runnable{
	
	
	public MyBlockQueue mbq ;
	
	public TakeThread(MyBlockQueue mbq){
		
		this.mbq = mbq ;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Object o = mbq.take();
			System.out.println("take=="+o);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
