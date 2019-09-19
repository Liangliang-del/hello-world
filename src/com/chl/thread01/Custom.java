package com.chl.thread01;

import java.util.Random;

public class Custom implements Runnable {
	private AppleBox box;
	
	public Custom(AppleBox box) {
		this.box = box;
	}

	@Override
	public void run() {
		Random rd = new Random();
		for(int i=0;i<20;i++){
			Apple apple = box.eat();
			System.out.println("消费了:"+apple.id+"苹果");
			try {
				Thread.sleep(rd.nextInt(500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
