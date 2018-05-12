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
		this.setTitle("送货订单");
 		this.setSize(500, 600);//设置窗体的大小
 		//this.setLocation(500, 500);//设置窗体的位置
 		this.setLocationRelativeTo(null);//设置窗体居中显示
 		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置窗体的关闭方式（默认值为窗体的隐藏）
 		this.setResizable(false);//设置不能通过窗体的拖拽，改变窗体的大小
 		this.setLayout(new BorderLayout());//设置窗体的布局方式（按照坐标进行布局）
 		
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
 		
 		this.jl1=new JLabel("     客户名:"+this.customer.getCustomerName());
 		this.jl2=new JLabel("收货地址："+this.address);
 		this.jl3=new JLabel("     销售员："+this.salesman.getSalesManName());
 		this.jl4=new JLabel("下单时间："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
 		this.jl5=new JLabel("     订单号："+this.DelmasterID);
 		this.jl6=new JLabel("联系号码："+this.customer.getCustomerTele());
 		this.jp1.add(jl5);
 		this.jp1.add(jl4);
 		this.jp1.add(jl1);
 		this.jp1.add(jl2);
 		this.jp1.add(jl3);
 		this.jp1.add(jl6);
 		
 		this.jb1=new JButton("确认订单");
 		this.jb1.addActionListener(this);
 		this.jb2=new JButton("返回");
 		this.jb2.addActionListener(this);
 		this.jp3.add(jb1);
 		this.jp3.add(jb2);
 		
 		for(int i=0;i<this.product.size();i++){
 			JLabel jl1=new JLabel("     商品名:"+this.product.get(i).getProductName());
 			JLabel jl2=new JLabel("总件数:"+this.product.get(i).getQuantity());
 			JLabel jl3=new JLabel("总价:"+this.product.get(i).getQuantity()*this.product.get(i).getSuggestSalePrice());
 			this.money+=this.product.get(i).getQuantity()*this.product.get(i).getSuggestSalePrice();
 			this.jp2.add(jl1);
 			this.jp2.add(jl2);
 			this.jp2.add(jl3);
 		}
 		this.jp2.add(new JLabel());
 		this.jp2.add(new JLabel());
 		this.jp2.add(new JLabel("总金额(RMB)："+this.money));
 	    

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
			JOptionPane.showMessageDialog(this, "销售订单生成成功","提示消息",JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		}
        if(e.getSource()==this.jb2){
			this.dispose();
		}
	}
}
