package com.hu.jpanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import com.hu.blservice.*;
import com.hu.jframe.DelFrame;
import com.hu.listener.SupJPanelListener;
import com.hu.model.*;
import com.hu.spring.SprMb;

public class JPanel_4 extends JFrame implements ActionListener,SupJPanelListener{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 private JButton jb1,jb2;
	 private JPanel jp1,jp2,jp3;
	 private JLabel jl1,jl2,jl3;
	 private JTextField jf;
	 private List<SupJPanel> jp=new ArrayList<SupJPanel>();
	 private JScrollPane s;
	 private int size=0;
	 private JComboBox<String> list1=new JComboBox<String>();
	 private JComboBox<String> list2=new JComboBox<String>();
	 private List<Customer> customer=new ArrayList<Customer>();
	 private List<Salesman> salesman=new ArrayList<Salesman>();
     private ProductBL productBL=(ProductBL) SprMb.actx.getBean("productBL");
     private CustomerBL customerBL=(CustomerBL) SprMb.actx.getBean("customerBL");
     private SalesmanBL salesmanBL=(SalesmanBL) SprMb.actx.getBean("salesmanBL");
	 public JPanel_4(){
	    	this.setTitle("��Ӧ������ά��");
	 		this.setSize(800, 470);//���ô���Ĵ�С
	 		//this.setLocation(500, 500);//���ô����λ��
	 		this.setLocationRelativeTo(null);//���ô��������ʾ
	 		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//���ô���Ĺرշ�ʽ��Ĭ��ֵΪ��������أ�
	 		this.setResizable(false);//���ò���ͨ���������ק���ı䴰��Ĵ�С
	 		this.setLayout(new BorderLayout());//���ô���Ĳ��ַ�ʽ������������в��֣�
	 		
	 		jb1=new JButton("�����Ʒ");
	 		this.jb1.addActionListener(this);
	 		jb2=new JButton("���ɶ���");
	 		this.jb2.addActionListener(this);
	 		jp1 = new JPanel();		// �½���ť������
	 		jp1.setLayout(new FlowLayout(FlowLayout.CENTER,100,10));	// �������Ĳ��ַ�ʽ
	 		this.jp1.add(jb1);
	 		this.jp1.add(jb2);
	 		this.add(jp1,BorderLayout.SOUTH);
	 		
	 		this.jp2=new JPanel();
	 		this.jp2.setLayout(new FlowLayout(FlowLayout.CENTER,400,5));
	 		this.jp2.setPreferredSize(new Dimension(750,size*45));
	 		s=new JScrollPane(jp2);
	 		this.add(s,BorderLayout.CENTER);
	 		
	 		this.jp3 = new JPanel();		// �½���ť������
	 		jp3.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
	 		this.jl1=new JLabel("   ��ѡ���ͻ��ͻ���");
	 		this.jl2=new JLabel("   ��ѡ���ۻ�Ա����");
	 		this.jl3=new JLabel("   �������ͻ���ַ��");
	 		this.customer=this.customerBL.findAllcustomer();
	 		this.salesman=this.salesmanBL.findAllsalesman();
	 		for(int i=0;i<customer.size();i++){
	 			this.list1.addItem(this.customer.get(i).getCustomerName());
	 		}
	 		for(int i=0;i<salesman.size();i++){
	 			this.list2.addItem(this.salesman.get(i).getSalesManName());
	 		}
	 		this.jf=new JTextField("                                                                 ");
	 		this.jf.setSize(100,30);
	 		
	 		this.jp3.add(jl1);
	 		this.jp3.add(list1);
	 		this.jp3.add(jl2);
	 		this.jp3.add(list2);
	 		this.jp3.add(jl3);
	 		this.jp3.add(jf);
	 		this.add(jp3,BorderLayout.NORTH);
	 }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.jb1){
			this.size+=1;
			SupJPanel supJPanel=new SupJPanel(this.productBL);
			supJPanel.addSupJPanelListener(this);
 			jp2.add(supJPanel);
 			this.jp.add(supJPanel);
 			this.jp2.setPreferredSize(new Dimension(750,size*45));
 			jp2.updateUI();
 			
		}
		if(e.getSource()==this.jb2){
			 List<Product> l=new ArrayList<Product>();
			for(int i=0;i<jp.size();i++){
				Product p=new Product();
				p.setProductID(this.jp.get(i).getProduct().get(this.jp.get(i).getList().getSelectedIndex()).getProductID());
				p.setProductName(this.jp.get(i).getProduct().get(this.jp.get(i).getList().getSelectedIndex()).getProductName());
				p.setQuantity(Long.parseLong(this.jp.get(i).getJt().getText().trim()));
				p.setSuggestSalePrice(Double.parseDouble(this.jp.get(i).getJf().getText().trim()));
				l.add(p);
			}
		 Customer customer=this.customer.get(this.list1.getSelectedIndex());
		 String address=this.jf.getText().trim();
		 Salesman salesman=this.salesman.get(this.list2.getSelectedIndex());
		 new DelFrame(customer,address,salesman,l).setVisible(true);
		}
		
	}
	@Override
	public void RemovePanel(SupJPanel sj) {
		// TODO Auto-generated method stub
		this.jp2.remove(sj);
		this.jp.remove(sj);
		jp2.updateUI();
	}
}
