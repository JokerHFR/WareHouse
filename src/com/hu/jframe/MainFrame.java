package com.hu.jframe;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.hu.jpanel.JPanel_10;
import com.hu.jpanel.JPanel_9;

public class MainFrame extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar jMenuBar;
	private JMenu[] jMenu=new JMenu[5];
	private JMenuItem[] jMenuItem1=new JMenuItem[4];
	private JMenuItem[] jMenuItem2=new JMenuItem[2];
	private JMenuItem[] jMenuItem3=new JMenuItem[2];
	private JMenuItem[] jMenuItem4=new JMenuItem[1];
	private JMenuItem[] jMenuItem5=new JMenuItem[2];
	private JPanel  jp;
	private JPanel[] jp_=new JPanel[11];
	private CardLayout card;
	
	private String uname;
	private String uword;
	
	public MainFrame(){
		
	}
	
	public MainFrame(String uname,String uword){
		this.card=new CardLayout();
		this.jp=new JPanel();
		this.jp.setLayout(card);
		this.uname=uname;
		this.uword=uword;
		for(int i=0;i<jp_.length;i++){
			this.jp_[i]=new JPanel();
			jp_[i].add(new JLabel(" "+i));
			this.jp.add(jp_[i],""+i);
		}
		this.setTitle("�ֿ����ϵͳ"+"                                 ��¼�û���"+uname);
		this.setSize(800, 500);//���ô���Ĵ�С
		//this.setLocation(500, 500);//���ô����λ��
		this.setLocationRelativeTo(null);//���ô��������ʾ
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ô���Ĺرշ�ʽ��Ĭ��ֵΪ��������أ�
		this.setResizable(false);//���ò���ͨ���������ק���ı䴰��Ĵ�С
		
		this.setLayout(new FlowLayout());//���ô���Ĳ��ַ�ʽ������������в��֣�
		
		this.jMenuBar=new JMenuBar();
		
		
		this.add(jp,"Center");
		
		//jMenu��Ϣ����
		jMenu[0]=new JMenu("        ��������ά��        ");
		jMenu[1]=new JMenu("        �ɹ�����        ");
		jMenu[2]=new JMenu("        ���۹���        ");
	    jMenu[3]=new JMenu("        ������        ");
	    jMenu[4]=new JMenu("        ϵͳά��        ");
	   
	    //jMenuItem��Ϣ����
	    jMenuItem1[0]=new JMenuItem("        ����Ա����        ");
	    jMenuItem1[1]=new JMenuItem("        �ͻ�����        ");
	    jMenuItem1[2]=new JMenuItem("        ��Ӧ������        ");
	    jMenuItem1[3]=new JMenuItem("        ��Ʒ����        ");
	    for(int i=0;i<jMenuItem1.length;i++){
	    	this.jMenu[0].add(jMenuItem1[i]);
	    	this.jMenuItem1[i].addActionListener(this);
	    }
	    
	    jMenuItem2[0]=new JMenuItem("        �ɹ���¼��");
	    jMenuItem2[1]=new JMenuItem("        �˻���¼��");
	    for(int i=0;i<jMenuItem2.length;i++){
	    	this.jMenu[1].add(jMenuItem2[i]);
	    	this.jMenuItem2[i].addActionListener(this);
	    }
	    
	    jMenuItem3[0]=new JMenuItem("        ���۵�¼��");
	    jMenuItem3[1]=new JMenuItem("        �˻���¼��");
	    for(int i=0;i<jMenuItem3.length;i++){
	    	this.jMenu[2].add(jMenuItem3[i]);
	    	this.jMenuItem3[i].addActionListener(this);
	    }
	    
	    jMenuItem4[0]=new JMenuItem("       ����ѯ     ");
	    for(int i=0;i<jMenuItem4.length;i++){
	    	this.jMenu[3].add(jMenuItem4[i]);
	    	this.jMenuItem4[i].addActionListener(this);
	    }
	    
	    jMenuItem5[0]=new JMenuItem("    �û����Ϲ���");
	    jMenuItem5[1]=new JMenuItem("    �޸�����");
	    for(int i=0;i<jMenuItem5.length;i++){
	    	this.jMenu[4].add(jMenuItem5[i]);
	    	this.jMenuItem5[i].addActionListener(this);
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
			this.card.show(jp, "0");
		}
        if(e.getSource()==this.jMenuItem1[1]){
        	this.card.show(jp, "1");
		}
        if(e.getSource()==this.jMenuItem1[2]){
        	this.card.show(jp, "2");
		}
        if(e.getSource()==this.jMenuItem1[3]){
        	this.card.show(jp, "3");
		}
        if(e.getSource()==this.jMenuItem2[0]){
        	this.card.show(jp, "4");
		}
        if(e.getSource()==this.jMenuItem2[1]){
        	this.card.show(jp, "5");
		}
        if(e.getSource()==this.jMenuItem3[0]){
        	this.card.show(jp, "6");
		}
        if(e.getSource()==this.jMenuItem3[1]){
        	this.card.show(jp, "7");
		}
        if(e.getSource()==this.jMenuItem4[0]){
        	this.card.show(jp, "8");
		}
        if(e.getSource()==this.jMenuItem5[0]){
        	new JPanel_9().setVisible(true);
		}
        if(e.getSource()==this.jMenuItem5[1]){
        	this.card.show(jp, "10");
        	JPanel_10 jp10=new JPanel_10(this.uname,this.uword);
    		jp10.setVisible(true);
		}
 
        
	}
	
	

}
