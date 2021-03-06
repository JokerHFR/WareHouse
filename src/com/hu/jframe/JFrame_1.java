package com.hu.jframe;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.hu.blservice.UserBL;
import com.hu.spring.SprMb;


public class JFrame_1 extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField jp1,jp2,jp3;
	private JLabel jl1,jl2,jl3;
	private JButton jb1;
	private String username;
	private String userword;
	
	private UserBL userBL=(UserBL) SprMb.actx.getBean("userBL");
	
	public JFrame_1(){
		
	}
	
	
    public JFrame_1(String uname,String uword){
    	this.username=uname;
    	this.userword=uword;
   
    	this.setTitle("用户密码修改");
    	this.setSize(400, 300);//设置窗体的大小
		this.setLocationRelativeTo(null);//设置窗体居中显示
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置窗体的关闭方式（默认值为窗体的隐藏）
		this.setResizable(false);//设置不能通过窗体的拖拽，改变窗体的大小
		
		this.setLayout(null);//设置窗体的布局方式（按照坐标进行布局）
		
 	this.jl1=new JLabel("输入老密码 :");
 	this.jl1.setFont(new Font("宋体",Font.BOLD, 14));
 	this.jl1.setBounds(50,50,110,40);
 	this.add(jl1);
 	this.jl2=new JLabel("输入新密码 :");
 	this.jl2.setFont(new Font("宋体",Font.BOLD, 14));
 	this.jl2.setBounds(50,100,110,40);
 	this.add(jl2);
 	this.jl3=new JLabel("再输入密码 :");
 	this.jl3.setFont(new Font("宋体",Font.BOLD, 14));
 	this.jl3.setBounds(50,150,110,40);
 	this.add(jl3);
 	
 	this.jp1=new JPasswordField();
 	this.jp1.setBounds(150, 55, 200, 30);
 	this.add(jp1);
 	this.jp2=new JPasswordField();
 	this.jp2.setBounds(150, 105, 200, 30);
 	this.add(jp2);
 	this.jp3=new JPasswordField();
 	this.jp3.setBounds(150, 155, 200, 30);
 	this.add(jp3);
 	
 	this.jb1=new JButton("确认修改");
 	this.jb1.setBounds(150, 205, 120, 30);
 	this.jb1.addActionListener(this);
 	this.add(jb1);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1){
			if(!new String(jp1.getPassword()).equals(userword)){
				JOptionPane.showMessageDialog(this, "修改失败，请输入正确旧密码","提示消息",JOptionPane.INFORMATION_MESSAGE);
			}else if(!new String(jp2.getPassword()).equals(new String(jp3.getPassword()))){
				JOptionPane.showMessageDialog(this, "新密码输入不一致","提示消息",JOptionPane.INFORMATION_MESSAGE);
			}else{
				try {
					if(userBL.changePassword(username, new String(jp2.getPassword()))==1){
					JOptionPane.showMessageDialog(this, "密码修改成功","提示消息",JOptionPane.INFORMATION_MESSAGE);
					this.userword=new String(jp2.getPassword());
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(this, "程序出错，密码修改失败","提示消息",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
}
