package com.ppchatcllient.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class FriendList extends JFrame implements ActionListener,MouseListener{
	CardLayout cardLayout;//
	
	//bei
	JPanel myhaoyou;
	JButton haoyou;
	//中
	JScrollPane myfriendJScrollPane;
	JPanel myfriendlist;
	static final int FRIEND=51;
	JLabel[] myfriendJLanel=new JLabel[FRIEND];
	
	
	
	//nan
	JPanel moshangrenmianban;
	JButton moshangren;
	JButton heimingdan;
	//新整的
	
	//bei
	JPanel mymoshangren;
	JButton moshangren1;
	JButton haoyou1;
	//nan
	JPanel moshangrenmianban1;
	JButton heimingdan1;
	String userName;
	public FriendList(String userName){
		this.userName=userName;
		
		myhaoyou=new JPanel(new BorderLayout());
		haoyou=new JButton("我的好友");
		myhaoyou.add(haoyou,"North");
		//zhong
	
		 myfriendlist=new JPanel(new GridLayout(FRIEND-1,1));
		 for(int i=1;i<FRIEND;i++){
			 myfriendJLanel[i]=new JLabel(i+"",new ImageIcon("images/mm.jpg"),JLabel.LEFT);
			 myfriendJLanel[i].addMouseListener(this);//鼠标监听器
			 myfriendlist.add(myfriendJLanel[i]);
		 }
		 myfriendJScrollPane=new JScrollPane(myfriendlist);
		 myhaoyou.add(myfriendJScrollPane);
		 
		 
		moshangrenmianban=new JPanel(new GridLayout(2,1));
		moshangren=new JButton("我的陌生人");
		moshangren.addActionListener(this);//事件监听器
		heimingdan=new JButton("黑名单");
		moshangrenmianban.add(moshangren);
		moshangrenmianban.add(heimingdan);
		myhaoyou.add(moshangrenmianban,"South");
		
		mymoshangren=new JPanel(new BorderLayout());
	
		//bei
		moshangrenmianban1=new JPanel(new GridLayout(2,1));
		haoyou1=new JButton("我的好友");
		haoyou1.addActionListener(this);//事件监听器
		moshangren1=new JButton("我的陌生人");

		moshangrenmianban1.add(haoyou1);
		moshangrenmianban1.add(moshangren1);
		mymoshangren.add(moshangrenmianban1,"North");
		//nan
		heimingdan1=new JButton("黑名单");
		mymoshangren.add(heimingdan1,"South");
		
		
		cardLayout=new CardLayout();
		this.setLayout(cardLayout);
		this.add(myhaoyou,"1");
		this.add(mymoshangren,"2");
		this.setSize(240,500);
		this.setTitle(userName+" dz");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}

	public static void main(String[] args) {
		//FriendList friendList=new FriendList();
		

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==moshangren){
			cardLayout.show(this.getContentPane(),"2");
		}
		if(arg0.getSource()==haoyou1){
			cardLayout.show(this.getContentPane(),"1");
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(arg0.getClickCount()==2){
			JLabel jlb1=(JLabel)arg0.getSource();
			String receiver=jlb1.getText();
			//new friendChat(this.userName,receiver);
			new Thread(new friendChat(this.userName,receiver)).start();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	     JLabel jlabel=(JLabel)e.getSource();
	     jlabel.setForeground(Color.blue);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		JLabel jlabel=(JLabel)e.getSource();
	     jlabel.setForeground(Color.black);
		
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}