package com.hu.jframe;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import com.hu.model.Deliverydetail;
import com.hu.model.Deliverymaster;
public class LookDelFrame extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jp1,jp2,jp3;
	private JLabel jl1,jl2,jl3,jl4,jl5,jl6;
	private JButton jb2;
	private List<Deliverydetail> deliverydetail;
	private Deliverymaster deliverymaster;
	public LookDelFrame(Deliverymaster deliverymaster){
		this.deliverymaster=deliverymaster;
		this.deliverydetail=deliverymaster.getDeliverydetail();
		int a=deliverymaster.getDeliveryPro();
		this.setTitle((a==1)?"�ͻ�����":"�˻�����");
 		this.setSize(500, 600);//���ô���Ĵ�С
 		//this.setLocation(500, 500);//���ô����λ��
 		this.setLocationRelativeTo(null);//���ô��������ʾ
 		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//���ô���Ĺرշ�ʽ��Ĭ��ֵΪ��������أ�
 		this.setResizable(false);//���ò���ͨ���������ק���ı䴰��Ĵ�С
 		this.setLayout(new BorderLayout());//���ô���Ĳ��ַ�ʽ������������в��֣�
 		
 		this.jp1=new JPanel();
 		this.jp1.setSize(500, 120);
 		this.jp1.setLayout(new GridLayout(3,2,0,10));
 		this.add(jp1,BorderLayout.NORTH);
 		this.jp2=new JPanel();
 		this.jp2.setSize(500, 380);
 		this.jp2.setLayout(new GridLayout(this.deliverydetail.size()+1,3,0,0));
 		this.add(jp2,BorderLayout.CENTER);
 		this.jp3=new JPanel();
 		this.jp3.setSize(500, 100);
 		this.jp3.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));
 		this.add(jp3,BorderLayout.SOUTH);
 		
 		this.jl1=new JLabel("     �ͻ���:"+this.deliverymaster.getCustomer().getCustomerName());
 		this.jl2=new JLabel((a==1)?"�ջ���ַ��"+this.deliverymaster.getDeliveryAddress():"");
 		this.jl3=new JLabel((a==1)?"     ����Ա��"+this.deliverymaster.getSalesman().getSalesManName():"");
 		this.jl4=new JLabel("�µ�ʱ�䣺"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.deliverymaster.getDeliveryDate()));
 		this.jl5=new JLabel("     �����ţ�"+this.deliverymaster.getDeliveryID());
 		this.jl6=new JLabel("��ϵ���룺"+this.deliverymaster.getCustomer().getCustomerTele());
 		this.jp1.add(jl5);
 		this.jp1.add(jl4);
 		this.jp1.add(jl1);
 		this.jp1.add(jl2);
 		this.jp1.add(jl3);
 		this.jp1.add(jl6);
 		
 		this.jb2=new JButton("�˳�");
 		this.jb2.addActionListener(this);
 		this.jp3.add(jb2);
 		
 		for(int i=0;i<this.deliverydetail.size();i++){
 			JLabel jl1=new JLabel("     ��Ʒ��:"+this.deliverydetail.get(i).getProduct().getProductName());
 			JLabel jl2=new JLabel("�ܼ���:"+this.deliverydetail.get(i).getSalesQua());
 			JLabel jl3=new JLabel("�ܼ�:"+this.deliverydetail.get(i).getSalesQua()*this.deliverydetail.get(i).getSalesPrice());
 			this.jp2.add(jl1);
 			this.jp2.add(jl2);
 			this.jp2.add(jl3);
 		}
 		this.jp2.add(new JLabel());
 		this.jp2.add(new JLabel());
 		this.jp2.add(new JLabel("�ܽ��(RMB)��"+this.deliverymaster.getDelMoney()));
 	    
 		}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
        if(e.getSource()==this.jb2){
			this.dispose();
		}
	}
}
