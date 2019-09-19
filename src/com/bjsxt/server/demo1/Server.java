package com.bjsxt.server.demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器并启动
 * @author u
 *
 */
public class Server {
	private ServerSocket server;
	
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}
	
	
	/**
	 * 启动方法
	 */
	
	public void start(){
		try {
			server = new ServerSocket(8888);
			this.receive();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 接收客户端
	 */
	private void receive(){
		try {
			Socket client = server.accept();
			StringBuffer sb = new StringBuffer();
			String msg = null;
			BufferedReader bf = new BufferedReader(new InputStreamReader(client.getInputStream()));
			while((msg=bf.readLine())!=null){
				sb.append(msg);
				sb.append("\r\n");
			}
			//接收客户端的请求信息
			String requsetInfo = sb.toString().trim();
			System.out.println(requsetInfo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 停止服务器
	 */
	public void stop(){
		
	}

	
}
