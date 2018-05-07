package com.hu.jpanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.hu.blservice.SupplierBL;
import com.hu.jframe.PurFrame;
import com.hu.listener.PurJPanelListener;
import com.hu.model.Product;
import com.hu.model.Supplier;
import com.hu.spring.SprMb;

public class JPanel_6 extends JPanel implements ActionListener,PurJPanelListener,ItemListener{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 private JButton jb1,jb2;
	 private JPanel jp1,jp2,jp3;
	 private JLabel jl1,jl3;
	 private List<PurJPanel> jp=new ArrayList<PurJPanel>();
	 private JScrollPane s;
	 private int size=0;
	 private JComboBox<String> list1=new JComboBox<String>();
	 private List<Supplier> supplier=new ArrayList<Supplier>();
     private SupplierBL supplierBL=(SupplierBL) SprMb.actx.getBean("supplierBL");
	 public JPanel_6(){
	 		this.supplier=this.supplierBL.findAllsupplier();
//	    	this.setTitle("进货订单生成");
//	 		this.setSize(800, 470);//设置窗体的大小
//	 		//this.setLocation(500, 500);//设置窗体的位置
//	 		this.setLocationRelativeTo(null);//设置窗体居中显示
//	 		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置窗体的关闭方式（默认值为窗体的隐藏）
//	 		this.setResizable(false);//设置不能通过窗体的拖拽，改变窗体的大小
	 		this.setLayout(new BorderLayout());//设置窗体的布局方式（按照坐标进行布局）
	 		
	 		jb1=new JButton("添加商品");
	 		this.jb1.addActionListener(this);
	 		jb2=new JButton("生成订单");
	 		this.jb2.addActionListener(this);
	 		jp1 = new JPanel();		// 新建按钮组件面板
	 		jp1.setLayout(new FlowLayout(FlowLayout.CENTER,100,10));	// 设置面板的布局方式
	 		this.jp1.add(jb1);
	 		this.jp1.add(jb2);
	 		this.add(jp1,BorderLayout.SOUTH);
	 		
	 		this.jp2=new JPanel();
	 		this.jp2.setLayout(new FlowLayout(FlowLayout.CENTER,400,5));
	 		this.jp2.setPreferredSize(new Dimension(750,size*45));
	 		s=new JScrollPane(jp2);
	 		this.add(s,BorderLayout.CENTER);
	 		
	 		this.jp3 = new JPanel();		// 新建按钮组件面板
	 		jp3.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
	 		this.jl1=new JLabel("   请选择供货商：");
	 		this.jl3=new JLabel("   进货地址："+this.supplier.get(0).getSuppliercomAddress());

	 		for(int i=0;i<supplier.size();i++){
	 			this.list1.addItem(this.supplier.get(i).getSupplierSimpleName());
	 		}
	 		this.list1.addItemListener(this);
	 		
	 		this.jp3.add(jl1);
	 		this.jp3.add(list1);
	 		this.jp3.add(jl3);
	 		this.add(jp3,BorderLayout.NORTH);
	 }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.jb1){
			this.size+=1;
			PurJPanel purJPanel=new PurJPanel(this.supplier.get(this.list1.getSelectedIndex()));
			purJPanel.addPurJPanelListener(this);
			jp2.add(purJPanel);
			this.jp.add(purJPanel);
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
				p.setSuggestBuyPrice(Double.parseDouble(this.jp.get(i).getJf().getText().trim()));
				l.add(p);
			}
			Supplier supplier=this.supplier.get(this.list1.getSelectedIndex());
		 new PurFrame(supplier,l).setVisible(true);
		}
		
	}
	@Override
	public void RemovePanel(PurJPanel pj) {
		// TODO Auto-generated method stub
		this.jp2.remove(pj);
		this.jp.remove(pj);
		jp2.updateUI();
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		 if(e.getStateChange() == ItemEvent.SELECTED){
			 int i=list1.getSelectedIndex();
			 this.jl3.setText("   进货地址："+this.supplier.get(i).getSuppliercomAddress());
				this.jp2.removeAll();
				this.jp=new ArrayList<PurJPanel>();;
				jp2.updateUI();
		 }
	}
}
