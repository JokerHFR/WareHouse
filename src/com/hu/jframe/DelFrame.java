package com.hu.jframe;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.*;

import com.hu.blservice.CustomerBL;
import com.hu.blservice.DeliverydetailBL;
import com.hu.blservice.DeliverymasterBL;
import com.hu.blservice.ProductBL;
import com.hu.model.*;
import com.hu.spring.SprMb;

public class DelFrame extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jp1,jp2,jp3;
	private JLabel jl1,jl2,jl3,jl4,jl5,jl6;
	private JButton jb1,jb2;
	private Customer customer;
	private  String address;
	private  Salesman salesman;
	private List<Product> product;
	private double money=0;
	private String DelmasterID;
	private List<Deliverydetail> deliverydetail=new ArrayList<Deliverydetail>();
	private Deliverymaster deliverymaster;
    private DeliverymasterBL deliverymasterBL=(DeliverymasterBL) SprMb.actx.getBean("deliverymasterBL");
    private DeliverydetailBL deliverydetailBL=(DeliverydetailBL) SprMb.actx.getBean("deliverydetailBL");
    private ProductBL productBL=(ProductBL) SprMb.actx.getBean("productBL");
    private CustomerBL customerBL=(CustomerBL) SprMb.actx.getBean("customerBL");
    private Date date;
	public DelFrame(Customer customer,String address,Salesman salesman, List<Product> product){
		this.customer=customer;
		this.address=address;
		this.salesman=salesman;
		this.product=product;
		this.date=new Date();
		this.DelmasterID=this.customer.getCustomerID()+new SimpleDateFormat("yyyyMMddHHmmss").format(date);
		this.setTitle("�ͻ�����");
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
 		this.jp2.setLayout(new GridLayout(this.product.size()+1,3,0,0));
 		this.add(jp2,BorderLayout.CENTER);
 		this.jp3=new JPanel();
 		this.jp3.setSize(500, 100);
 		this.jp3.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));
 		this.add(jp3,BorderLayout.SOUTH);
 		
 		this.jl1=new JLabel("     �ͻ���:"+this.customer.getCustomerName());
 		this.jl2=new JLabel("�ջ���ַ��"+this.address);
 		this.jl3=new JLabel("     ����Ա��"+this.salesman.getSalesManName());
 		this.jl4=new JLabel("�µ�ʱ�䣺"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
 		this.jl5=new JLabel("     �����ţ�"+this.DelmasterID);
 		this.jl6=new JLabel("��ϵ���룺"+this.customer.getCustomerTele());
 		this.jp1.add(jl5);
 		this.jp1.add(jl4);
 		this.jp1.add(jl1);
 		this.jp1.add(jl2);
 		this.jp1.add(jl3);
 		this.jp1.add(jl6);
 		
 		this.jb1=new JButton("ȷ�϶���");
 		this.jb1.addActionListener(this);
 		this.jb2=new JButton("����");
 		this.jb2.addActionListener(this);
 		this.jp3.add(jb1);
 		this.jp3.add(jb2);
 		
 		for(int i=0;i<this.product.size();i++){
 			JLabel jl1=new JLabel("     ��Ʒ��:"+this.product.get(i).getProductName());
 			JLabel jl2=new JLabel("�ܼ���:"+this.product.get(i).getQuantity());
 			JLabel jl3=new JLabel("�ܼ�:"+this.product.get(i).getQuantity()*this.product.get(i).getSuggestSalePrice());
 			this.money+=this.product.get(i).getQuantity()*this.product.get(i).getSuggestSalePrice();
 			this.jp2.add(jl1);
 			this.jp2.add(jl2);
 			this.jp2.add(jl3);
 		}
 		this.jp2.add(new JLabel());
 		this.jp2.add(new JLabel());
 		this.jp2.add(new JLabel("�ܽ��(RMB)��"+this.money));
 	    

 		this.deliverymaster=new Deliverymaster(Long.parseLong(this.DelmasterID),1,date,this.customer,this.salesman,this.address,this.money);
 		for(int i=0;i<this.product.size();i++){
 			Deliverydetail deliverydetail=new Deliverydetail(this.deliverymaster,this.product.get(i),this.product.get(i).getQuantity(),this.product.get(i).getSuggestSalePrice());
 		    this.deliverydetail.add(deliverydetail);
 		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.jb1){
			this.deliverymasterBL.insertdeliverymaster(this.deliverymaster);
			this.deliverydetailBL.insertdeliverydetail(this.deliverydetail);
			this.productBL.productupdatequa(product, date);
			this.customerBL.updatecustomerdate(customer, date);
			JOptionPane.showMessageDialog(this, "���۶������ɳɹ�","��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		}
        if(e.getSource()==this.jb2){
			this.dispose();
		}
	}
}
