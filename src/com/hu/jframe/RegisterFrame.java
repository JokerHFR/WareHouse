package com.hu.jframe;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.hu.blservice.UserBL;
import com.hu.spring.SprMb;

public class RegisterFrame extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField jp1;
	private JPasswordField jp2,jp3;
	private JLabel jl1,jl2,jl3;
	private JButton jb1;
	
	private UserBL userBL=(UserBL) SprMb.actx.getBean("userBL");

    public RegisterFrame(){

    	this.setTitle("用户注册");
    	this.setSize(400, 300);//设置窗体的大小
		this.setLocationRelativeTo(null);//设置窗体居中显示
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗体的关闭方式（默认值为窗体的隐藏）
		this.setResizable(false);//设置不能通过窗体的拖拽，改变窗体的大小
		
		this.setLayout(null);//设置窗体的布局方式（按照坐标进行布局）
 		
 	this.jl1=new JLabel("输入用户名 :");
 	this.jl1.setFont(new Font("宋体",Font.BOLD, 14));
 	this.jl1.setBounds(50,50,110,40);
 	this.add(jl1);
 	this.jl2=new JLabel("输入密码 :");
 	this.jl2.setFont(new Font("宋体",Font.BOLD, 14));
 	this.jl2.setBounds(50,100,110,40);
 	this.add(jl2);
 	this.jl3=new JLabel("再输入密码 :");
 	this.jl3.setFont(new Font("宋体",Font.BOLD, 14));
 	this.jl3.setBounds(50,150,110,40);
 	this.add(jl3);
 	
 	this.jp1=new JTextField();
 	this.jp1.setBounds(150, 55, 200, 30);
 	this.add(jp1);
 	this.jp2=new JPasswordField();
 	this.jp2.setBounds(150, 105, 200, 30);
 	this.add(jp2);
 	this.jp3=new JPasswordField();
 	this.jp3.setBounds(150, 155, 200, 30);
 	this.add(jp3);
 	
 	this.jb1=new JButton("确认注册");
 	this.jb1.setBounds(150, 205, 120, 30);
 	this.jb1.addActionListener(this);
 	this.add(jb1);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1){
			if(new String(jp2.getPassword()).equals("")&&new String(jp3.getPassword()).equals("")&&jp1.getText().equals("")){
				JOptionPane.showMessageDialog(this, "信息不能为空，请重新输入","警告",JOptionPane.WARNING_MESSAGE);
			}
			else if(!new String(jp2.getPassword()).equals(new String(jp3.getPassword()))){
				JOptionPane.showMessageDialog(this, "新密码输入不一致，请重新输入","提示消息",JOptionPane.INFORMATION_MESSAGE);
			}else{
				try {
					int i=this.userBL.registerUser(jp1.getText(), new String(jp2.getPassword()) );
					System.out.println(i);
					if(i==1){
						JOptionPane.showMessageDialog(this, "注册成功，请去解禁","提示消息",JOptionPane.INFORMATION_MESSAGE);
						this.dispose();
						new LoginFrame().setVisible(true);
					}else if(i==2){
						JOptionPane.showMessageDialog(this, "该用户名已经存在，请重新输入","提示消息",JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			}
	}	
	}

