package com.chl.thread01;

import java.util.Random;

public class Producer implements Runnable {
	private AppleBox box;
	
	public Producer(AppleBox box) {
		this.box = box;
	}
	
	
	@Override
	public void run() {
		Random rd = new Random();
		for(int i=0;i<20;i++){
			Apple apple = new Apple(i+1);
			box.produceApple(apple);
			System.out.println("生产了:"+apple.id+"苹果");
			try {
				Thread.sleep(rd.nextInt(500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
