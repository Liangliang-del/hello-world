package com.chl.thread01;

public class AppleBox {
	int index = 0;
	Apple[] apples = new Apple[5];
	
	//生产苹果
	public synchronized void produceApple(Apple apple){
		while(index>=apples.length){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notifyAll();
		apples[index] = apple;
		index++;
		System.out.println(Thread.currentThread().getName()+"生产了编号为:"+apple.id+"的苹果");
		
	}
	
	//消费苹果
	public synchronized Apple eat(){
		while(index<=0){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notifyAll();
		index--;
		System.out.println(Thread.currentThread().getName()+"消费了编号为:"+apples[index].id+"的苹果");
		return apples[index];
	}
}
