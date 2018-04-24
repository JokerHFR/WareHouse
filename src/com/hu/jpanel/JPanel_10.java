package com.hu.jpanel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.hu.blservice.UserBL;
import com.hu.spring.SprMb;


public class JPanel_10 extends JFrame implements ActionListener{

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
	
    public JPanel_10(){
//    	this.setSize(800, 400);
//    	this.setOpaque(false);
// 		this.setLayout(null);//���ô���Ĳ��ַ�ʽ�����񲼾֣�
    	
    	this.setSize(800, 400);//���ô���Ĵ�С
		//this.setLocation(500, 500);//���ô����λ��
		this.setLocationRelativeTo(null);//���ô��������ʾ
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ô���Ĺرշ�ʽ��Ĭ��ֵΪ��������أ�
		this.setResizable(false);//���ò���ͨ���������ק���ı䴰��Ĵ�С
		
		this.setLayout(null);//���ô���Ĳ��ַ�ʽ������������в��֣�
		
	this.username="king";
	this.userword="123";
 		
 	this.jl1=new JLabel("���������� :");
 	this.jl1.setFont(new Font("����",Font.BOLD, 14));
 	this.jl1.setBounds(230,100,110,40);
 	this.add(jl1);
 	this.jl2=new JLabel("���������� :");
 	this.jl2.setFont(new Font("����",Font.BOLD, 14));
 	this.jl2.setBounds(230,150,110,40);
 	this.add(jl2);
 	this.jl3=new JLabel("���������� :");
 	this.jl3.setFont(new Font("����",Font.BOLD, 14));
 	this.jl3.setBounds(230,200,110,40);
 	this.add(jl3);
 	
 	this.jp1=new JPasswordField();
 	this.jp1.setBounds(330, 105, 200, 30);
 	this.add(jp1);
 	this.jp2=new JPasswordField();
 	this.jp2.setBounds(330, 155, 200, 30);
 	this.add(jp2);
 	this.jp3=new JPasswordField();
 	this.jp3.setBounds(330, 205, 200, 30);
 	this.add(jp3);
 	
 	this.jb1=new JButton("ȷ���޸�");
 	this.jb1.setBounds(330, 255, 120, 30);
 	this.jb1.addActionListener(this);
 	this.add(jb1);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1){
			if(!new String(jp1.getPassword()).equals(userword)){
				JOptionPane.showMessageDialog(this, "�޸�ʧ�ܣ���������ȷ������","��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
			}else if(!new String(jp2.getPassword()).equals(new String(jp3.getPassword()))){
				JOptionPane.showMessageDialog(this, "���������벻һ��","��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
			}else{
				try {
					if(userBL.changePassword(username, new String(jp2.getPassword()))==1){
					JOptionPane.showMessageDialog(this, "�����޸ĳɹ�","��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
					this.userword=new String(jp2.getPassword());
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(this, "������������޸�ʧ��","��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
}
