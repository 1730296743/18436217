package com.qqchatserver.controller;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.HashMap;

//import com.ppchatcllient.view.ServerReceiverTh;
import com.yychat.model.Message;
import com.yychat.model.user;

public class StertServer {
	 public static HashMap hmSocket=new HashMap<String,Socket>();
	String userName;
	Socket s;
	String passWord;
	ServerSocket ss;
	public StertServer(){
	try {//捕获异常
		//double 
		ss= new ServerSocket(3456);
		System.out.println("服务器已经启动，监听3456端口");
		while(true){
	    s= ss.accept();//接受连接请求
		System.out .println("连接成功:"+s);
		
		//接受uear
		ObjectInputStream ois=new ObjectInputStream (s.getInputStream());
		 user user=(user)ois.readObject();
		 userName=user.getUserName();
		 passWord=user.getPassName();
		 System.out.println(userName);
		 System.out.println(passWord);
		//密码验证
		 Message mess=new Message();
		 mess.setSender("Senver");
		 mess.setReceiver(passWord);
		
		 if(passWord.equals("123456")){//对象比较
			 mess.setMessageType(Message.message_LoginSuccess);//1为验证通过
		 }else{
			 mess.setMessageType(Message.message_LoginFailure);//0为验证 不通过
		 }
		 ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
		 oos.writeObject(mess);
			//接受聊天
		 if(passWord.equals("123456")){
			 hmSocket.put(userName, s);
			 new ServerReceiverThread(s).start();//jiuxu 
		 }
			
			
		}
		
	} catch (IOException e) {
		
		e.printStackTrace();//处理异常
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	}
		
	}
}
