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

import com.hu.model.Purchasedetail;
import com.hu.model.Purchasemaster;

public class LookPurFrame extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jp1,jp2,jp3;
	private JLabel jl1,jl2,jl3,jl4,jl5;
	private JButton jb2;
	private List<Purchasedetail> purchasedetail;
	private Purchasemaster purchasemaster;
	public LookPurFrame(Purchasemaster purchasemaster){
		this.purchasemaster=purchasemaster;
		this.purchasedetail=purchasemaster.getPurchasedetail();
		int a=purchasemaster.getPurchasePro();
		this.setTitle((a==1)?"进货订单":"退货订单");
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
 		this.jp2.setLayout(new GridLayout(this.purchasedetail.size()+1,3,0,0));
 		this.add(jp2,BorderLayout.CENTER);
 		this.jp3=new JPanel();
 		this.jp3.setSize(500, 100);
 		this.jp3.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));
 		this.add(jp3,BorderLayout.SOUTH);
 		
 		this.jl1=new JLabel("     供货商:"+this.purchasedetail.get(0).getProduct().getSupplier().getSupplierSimpleName());
 		this.jl2=new JLabel("     进货地址："+this.purchasedetail.get(0).getProduct().getSupplier().getSuppliercomAddress());
 		this.jl3=new JLabel("联系号码："+this.purchasedetail.get(0).getProduct().getSupplier().getSupplierTele());
 		this.jl4=new JLabel("下单时间："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.purchasemaster.getPurchaseDate()));
 		this.jl5=new JLabel("     订单号："+this.purchasemaster.getPurchaseID());
 		this.jp1.add(jl5);
 		this.jp1.add(jl4);
 		this.jp1.add(jl1);
 		this.jp1.add(jl2);
 		this.jp1.add(jl3);

 		
 		this.jb2=new JButton("退出");
 		this.jb2.addActionListener(this);
 		this.jp3.add(jb2);
 		
 		for(int i=0;i<this.purchasedetail.size();i++){
 			JLabel jl1=new JLabel("     商品名:"+this.purchasedetail.get(i).getProduct().getProductName());
 			JLabel jl2=new JLabel("总件数:"+this.purchasedetail.get(i).getPurchaseQua());
 			JLabel jl3=new JLabel("总价:"+this.purchasedetail.get(i).getPurchaseQua()*this.purchasedetail.get(i).getPurchasePrice());
 			this.jp2.add(jl1);
 			this.jp2.add(jl2);
 			this.jp2.add(jl3);
 		}
 		this.jp2.add(new JLabel());
 		this.jp2.add(new JLabel());
 		this.jp2.add(new JLabel("总金额(RMB)："+this.purchasemaster.getPurMoney()));
 	    
 		}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
        if(e.getSource()==this.jb2){
			this.dispose();
		}
	}
}

