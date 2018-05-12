package com.hu.jframe;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import com.hu.Fuction.Fuction;
import com.hu.blservice.UserBL;
import com.hu.model.User;
import com.hu.spring.SprMb;

public class JFrame_0 extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserBL userBL=(UserBL) SprMb.actx.getBean("userBL");
	private JScrollPane jsp=new JScrollPane();
	private JPanel ja=new JPanel();
	private JCheckBox[] jcb;
	private List<String> name=new ArrayList<String>();
	private JLabel jl;
	private List<User> list=new ArrayList<User>();
	private JButton jb1,jb2,jb3;
     public JFrame_0() {
		// TODO Auto-generated constructor stub
    	this.setTitle("用户管理");
 		this.setSize(800, 470);//设置窗体的大小
 		//this.setLocation(500, 500);//设置窗体的位置
 		this.setLocationRelativeTo(null);//设置窗体居中显示
 		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置窗体的关闭方式（默认值为窗体的隐藏）
 		this.setResizable(false);//设置不能通过窗体的拖拽，改变窗体的大小
 		this.setLayout(null);//设置窗体的布局方式（按照坐标进行布局）
 		
 		this.jsp.setBounds(0, 35, 795, 350);
 		this.jsp.getViewport().add(this.ja);
		this.add(jsp);
//		this.ja.setOpaque(false);
        this.ja.setLayout(new FlowLayout(FlowLayout.LEFT, 100, 10)); 
        
		this.jl=new JLabel("                 勾选                                               用户名                                                                         状态");
		this.jl.setBounds(50,5,800,30);
		this.add(jl);	 
        this.append();
        
        this.jb1=new JButton("解禁");
        this.jb2=new JButton("删除");
        this.jb3=new JButton("禁止");
        this.jb1.setBounds(100, 395, 150, 30);
        this.jb2.setBounds(500, 395, 150, 30);
        this.jb3.setBounds(300, 395, 150, 30);
        this.jb1.addActionListener(this);
        this.jb2.addActionListener(this);
        this.jb3.addActionListener(this);
        this.add(jb1);
        this.add(jb2);
        this.add(jb3);
		
	}
     
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1){
			for(int i=0;i<this.jcb.length;i++){
				if(jcb[i].isSelected()){
					this.name.add(this.list.get(i).getUsername());
					
				}
			}
			this.userBL.updateisUse(this.name);
			JOptionPane.showMessageDialog(this, "解禁成功","提示信息",JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
			new JFrame_0().setVisible(true);
		}else if(e.getSource()==jb2){
			for(int i=0;i<this.jcb.length;i++){
				if(jcb[i].isSelected()){
					this.name.add(this.list.get(i).getUsername());
				}
			}
			this.userBL.deleteUser(this.name);
			JOptionPane.showMessageDialog(this, "删除成功","提示信息",JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
			new JFrame_0().setVisible(true);
		}
		else if(e.getSource()==jb3){
			for(int i=0;i<this.jcb.length;i++){
				if(jcb[i].isSelected()){
					this.name.add(this.list.get(i).getUsername());
				}
			}
			this.userBL.updatenoUse(this.name);
			JOptionPane.showMessageDialog(this, "禁止成功","提示信息",JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
			new JFrame_0().setVisible(true);
		}
	}
	
	public void append(){
	    try {
			this.list=this.userBL.findUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.jcb=new JCheckBox[this.list.size()];
		String[]s={"禁止","开放"};
		for(int i=0;i<this.jcb.length;i++){
			jcb[i]=new JCheckBox(Fuction.Str(50, this.list.get(i).getUsername())+Fuction.Str(30,s[this.list.get(i).getIsuse()]));
			this.ja.add(jcb[i]);
			this.ja.setPreferredSize(new Dimension(500,i * 40));
			
		}
	}

}
