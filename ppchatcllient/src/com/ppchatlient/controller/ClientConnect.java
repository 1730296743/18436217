package com.ppchatlient.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.yychat.model.Message;
import com.yychat.model.user;

public class ClientConnect {
	
	public static Socket s;

	public ClientConnect() {
		try {
			s = new Socket("127.0.0.1", 3456);// ������ַ���ز��ַ
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Message loginValidate(user user){
		ObjectOutputStream oos;
		ObjectInputStream ois;
		Message mess=null;
	try {
		oos=new ObjectOutputStream (s.getOutputStream());
		oos.writeObject(user);
		
		ois=new ObjectInputStream(s.getInputStream());
		 mess=(Message)ois.readObject();
		
	} catch (IOException | ClassNotFoundException e) {
		
		e.printStackTrace();
	}
	return mess;
	}
}