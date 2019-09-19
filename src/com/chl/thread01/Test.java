package com.chl.thread01;

public class Test {
	public static void main(String[] args) {
		AppleBox box = new AppleBox();
		
		Producer producer = new Producer(box);
		
		Custom custom1 = new Custom(box);
		Custom custom2 = new Custom(box);
		
		new Thread(producer).start();
		new Thread(custom1).start();
		new Thread(custom2).start();
	}
}
