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

    	this.setTitle("�û�ע��");
    	this.setSize(400, 300);//���ô���Ĵ�С
		this.setLocationRelativeTo(null);//���ô��������ʾ
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ô���Ĺرշ�ʽ��Ĭ��ֵΪ��������أ�
		this.setResizable(false);//���ò���ͨ���������ק���ı䴰��Ĵ�С
		
		this.setLayout(null);//���ô���Ĳ��ַ�ʽ������������в��֣�
 		
 	this.jl1=new JLabel("�����û��� :");
 	this.jl1.setFont(new Font("����",Font.BOLD, 14));
 	this.jl1.setBounds(50,50,110,40);
 	this.add(jl1);
 	this.jl2=new JLabel("�������� :");
 	this.jl2.setFont(new Font("����",Font.BOLD, 14));
 	this.jl2.setBounds(50,100,110,40);
 	this.add(jl2);
 	this.jl3=new JLabel("���������� :");
 	this.jl3.setFont(new Font("����",Font.BOLD, 14));
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
 	
 	this.jb1=new JButton("ȷ��ע��");
 	this.jb1.setBounds(150, 205, 120, 30);
 	this.jb1.addActionListener(this);
 	this.add(jb1);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1){
			if(new String(jp2.getPassword()).equals("")&&new String(jp3.getPassword()).equals("")&&jp1.getText().equals("")){
				JOptionPane.showMessageDialog(this, "��Ϣ����Ϊ�գ�����������","����",JOptionPane.WARNING_MESSAGE);
			}
			else if(!new String(jp2.getPassword()).equals(new String(jp3.getPassword()))){
				JOptionPane.showMessageDialog(this, "���������벻һ�£�����������","��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
			}else{
				try {
					int i=this.userBL.registerUser(jp1.getText(), new String(jp2.getPassword()) );
					System.out.println(i);
					if(i==1){
						JOptionPane.showMessageDialog(this, "ע��ɹ�����ȥ���","��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
						this.dispose();
						new LoginFrame().setVisible(true);
					}else if(i==2){
						JOptionPane.showMessageDialog(this, "���û����Ѿ����ڣ�����������","��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			}
	}	
	}

