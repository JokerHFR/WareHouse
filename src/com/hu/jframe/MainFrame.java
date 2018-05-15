package com.hu.jframe;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.hu.jpanel.*;

public class MainFrame extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar jMenuBar;
	private JMenu[] jMenu=new JMenu[4];
	private JMenuItem[] jMenuItem1=new JMenuItem[4];
	private JMenuItem[] jMenuItem2=new JMenuItem[3];
	private JMenuItem[] jMenuItem3=new JMenuItem[3];
	private JMenuItem[] jMenuItem4=new JMenuItem[2];
	private JPanel  jp;
	private CardLayout card;
	
	private String uname;
	private String uword;
	private int issuper;
	public MainFrame(){
		
	}
	
	public MainFrame(String uname,String uword,int issuper){
		this.card=new CardLayout();
		this.jp=new JPanel();
		this.jp.setLayout(card);
		this.uname=uname;
		this.uword=uword;
        this.issuper=issuper;
		
		this.jp.add(new JPanel_0(),"0");
		this.jp.add(new JPanel_1(),"1");
		this.jp.add(new JPanel_2(),"2");
		this.jp.add(new JPanel_3(),"3");
		this.jp.add(new JPanel_4(),"4");
		this.jp.add(new JPanel_5(),"5");
		this.jp.add(new JPanel_6(),"6");
		this.jp.add(new JPanel_7(),"7");
		this.jp.add(new JPanel_8(),"8");
		this.jp.add(new JPanel_9(),"9");

		this.setTitle("仓库管理系统"+"                                 登录用户："+uname);
		this.setSize(800, 500);//设置窗体的大小
		//this.setLocation(500, 500);//设置窗体的位置
		this.setLocationRelativeTo(null);//设置窗体居中显示
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗体的关闭方式（默认值为窗体的隐藏）
		this.setResizable(false);//设置不能通过窗体的拖拽，改变窗体的大小
		
		this.setLayout(null);//设置窗体的布局方式（按照坐标进行布局）
		
		this.jMenuBar=new JMenuBar();
		
		this.jp.setBounds(0,0, 795, 450);
		this.add(jp);
		
		//jMenu信息设置
		jMenu[0]=new JMenu("        基本资料维护        ");
		jMenu[1]=new JMenu("        销售管理        ");
		jMenu[2]=new JMenu("        采购管理        ");
	    jMenu[3]=new JMenu("        系统维护        ");
	   
	    //jMenuItem信息设置
	    jMenuItem1[0]=new JMenuItem("        销售员资料        ");
	    jMenuItem1[1]=new JMenuItem("        客户资料        ");
	    jMenuItem1[2]=new JMenuItem("        供应商资料        ");
	    jMenuItem1[3]=new JMenuItem("        商品资料        ");
	    for(int i=0;i<jMenuItem1.length;i++){
	    	this.jMenu[0].add(jMenuItem1[i]);
	    	this.jMenuItem1[i].addActionListener(this);
	    }
	    
	    jMenuItem2[0]=new JMenuItem("        销售单录入");
	    jMenuItem2[1]=new JMenuItem("        退货单录入");
	    jMenuItem2[2]=new JMenuItem("        销售单管理");
	    for(int i=0;i<jMenuItem2.length;i++){
	    	this.jMenu[1].add(jMenuItem2[i]);
	    	this.jMenuItem2[i].addActionListener(this);
	    }
	    
	    jMenuItem3[0]=new JMenuItem("        采购单录入");
	    jMenuItem3[1]=new JMenuItem("        退货单录入");
	    jMenuItem3[2]=new JMenuItem("        采购单管理");
	    for(int i=0;i<jMenuItem3.length;i++){
	    	this.jMenu[2].add(jMenuItem3[i]);
	    	this.jMenuItem3[i].addActionListener(this);
	    }
	    
	    
	    jMenuItem4[0]=new JMenuItem("    用户资料管理");
	    jMenuItem4[1]=new JMenuItem("    修改密码");
	    for(int i=0;i<jMenuItem4.length;i++){
	    	this.jMenu[3].add(jMenuItem4[i]);
	    	this.jMenuItem4[i].addActionListener(this);
	    }
	    
	    for(int i=0;i<jMenu.length;i++){
	    	this.jMenuBar.add(jMenu[i]);
	    }
	    this.setJMenuBar(this.jMenuBar);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.jMenuItem1[0]){
			this.jp.add(new JPanel_0(),"0");
			this.card.show(jp, "0");
			this.setTitle("销售员资料");
		}
        if(e.getSource()==this.jMenuItem1[1]){
        	this.jp.add(new JPanel_1(),"1");
        	this.card.show(jp, "1");
        	this.setTitle("客户资料");
		}
        if(e.getSource()==this.jMenuItem1[2]){
        	this.jp.add(new JPanel_2(),"2");
        	this.card.show(jp, "2");
        	this.setTitle("供应商资料");
		}
        if(e.getSource()==this.jMenuItem1[3]){
        	this.jp.add(new JPanel_3(),"3");
        	this.card.show(jp, "3");
        	this.setTitle("商品资料");
		}
        if(e.getSource()==this.jMenuItem2[0]){
        	this.jp.add(new JPanel_4(),"4");
        	this.card.show(jp, "4");
        	this.setTitle("销售单录入");
		}
        if(e.getSource()==this.jMenuItem2[1]){
        	this.jp.add(new JPanel_5(),"5");
        	this.card.show(jp, "5");
        	this.setTitle("销售退货单录入");
		}
        if(e.getSource()==this.jMenuItem2[2]){
        	this.jp.add(new JPanel_8(),"8");
        	this.card.show(jp, "8");
        	this.setTitle("销售单管理");
		}
        if(e.getSource()==this.jMenuItem3[0]){
        	this.jp.add(new JPanel_6(),"6");
        	this.card.show(jp, "6");
        	this.setTitle("进货单录入");
		}
        if(e.getSource()==this.jMenuItem3[1]){
        	this.jp.add(new JPanel_7(),"7");
        	this.card.show(jp, "7");
        	this.setTitle("进货退货单录入");
		}
        if(e.getSource()==this.jMenuItem3[2]){
        	this.jp.add(new JPanel_9(),"9");
        	this.card.show(jp, "9");
        	this.setTitle("进货单管理");
		}
        if(e.getSource()==this.jMenuItem4[0]){
        	if(this.issuper==1){
        	new JFrame_0().setVisible(true);
        	}else{
        		JOptionPane.showMessageDialog(this, "你不是超管理员，无权限！", "提示信息", JOptionPane.WARNING_MESSAGE);
        	}
		}
        if(e.getSource()==this.jMenuItem4[1]){
        	JFrame_1 jp10=new JFrame_1(this.uname,this.uword);
    		jp10.setVisible(true);
		}
 
        
	}
}
