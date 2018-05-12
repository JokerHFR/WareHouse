package com.hu.jpanel;

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
import javax.swing.JTextField;

import com.hu.listener.TuiPurJPanelListener;
import com.hu.model.Product;
import com.hu.model.Supplier;

public class TuiPurJPanel extends JPanel implements ActionListener,ItemListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jl1,jl2,jl3;
	private JTextField jt,jf;
	private JButton jb;
	private JComboBox<String> list=new JComboBox<String>();
	private List<Product> product=new ArrayList<Product>();
	public JTextField getJt() {
		return jt;
	}
	public void setJt(JTextField jt) {
		this.jt = jt;
	}
	public JComboBox<String> getList() {
		return list;
	}
	public void setList(JComboBox<String> list) {
		this.list = list;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}

	private TuiPurJPanelListener jp=null; 
	public TuiPurJPanel(Supplier supplier){
		product=supplier.getProduct();
		this.setLayout(new FlowLayout(FlowLayout.CENTER,10,5));
		this.jl1=new JLabel("商品名称：");
		this.jl2=new JLabel();
		this.jl3=new JLabel();
		this.jt=new JTextField("0000");
		this.jf=new JTextField("0000");
		this.jb=new JButton("删除");
		this.jb.addActionListener(this);
		this.list.addItemListener(this);
		for(int i=0;i<product.size();i++){
			list.addItem(product.get(i).getProductName());
		}
		this.add(jl1);
		this.add(list);
		this.add(jl2);
		this.add(jt);
		this.add(jl3);
		this.add(jf);
		this.add(jb);
	}
	public JTextField getJf() {
		return jf;
	}
	public void setJf(JTextField jf) {
		this.jf = jf;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.jb){
			this.jp.RemovePanel(this);
		}
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		 if(e.getStateChange() == ItemEvent.SELECTED){
			 int i=list.getSelectedIndex();
			 this.jl2.setText("当前库存："+product.get(i).getQuantity()+"             退货数量：");
			 this.jl3.setText(product.get(i).getProductUnit()+"         退货价格(RMB)：");
		 }
	}
	
	public void addTuiPurJPanelListener(TuiPurJPanelListener jp){
		this.jp=jp;
	}
}
