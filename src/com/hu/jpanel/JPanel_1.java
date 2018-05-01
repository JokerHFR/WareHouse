package com.hu.jpanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hu.blservice.CustomerBL;
import com.hu.model.Customer;
import com.hu.spring.SprMb;

public class JPanel_1 extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel tableModel;		// 默认显示的表格
	private JButton add,del,edit,update;		// 各处理按钮
	private JTable table;		// 表格
	private JPanel panelUP;
	private List<Customer> list=new ArrayList<Customer>();
	private CustomerBL customerBL=(CustomerBL) SprMb.actx.getBean("customerBL");
    public JPanel_1(){
    	this.setTitle("客户资料维护");
 		this.setSize(800, 470);//设置窗体的大小
 		//this.setLocation(500, 500);//设置窗体的位置
 		this.setLocationRelativeTo(null);//设置窗体居中显示
 		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置窗体的关闭方式（默认值为窗体的隐藏）
 		this.setResizable(false);//设置不能通过窗体的拖拽，改变窗体的大小
 		this.setLayout(new BorderLayout());//设置窗体的布局方式（按照坐标进行布局）
 		
 	// 新建各按钮组件
 			add = new JButton("增加");
 			this.add.addActionListener(this);
 			del = new JButton("删除");
 			this.del.addActionListener(this);
 			update = new JButton("修改");
 			this.update.addActionListener(this);
 			edit = new JButton("编辑");
 			this.edit.addActionListener(this);
 			
 			panelUP = new JPanel();		// 新建按钮组件面板
 			panelUP.setLayout(new FlowLayout(FlowLayout.CENTER,50,10));	// 设置面板的布局方式
 			
 			// 将各按钮组件依次添加到面板中
 			panelUP.add(add);
 			panelUP.add(del);
 			panelUP.add(update);
 			panelUP.add(edit);
 			
 			// 取得haha数据库的aa表的各行数据
 			Vector<String> columnNames =new Vector<String>();
 			columnNames.add("客户编号");
 			columnNames.add("公司简称");
 			columnNames.add("公司全称");
 			columnNames.add("负责人名字");
 			columnNames.add("移动电话");
 			columnNames.add("固定电话");
 			columnNames.add("传真");
 			columnNames.add("公司地址");
 			columnNames.add("送货地址");
 			columnNames.add("开票地址");
 			columnNames.add("最后送货日期");
 			
 			
 			// 取得haha数据库的aa表的表头数据
 			this.list=this.customerBL.findAllcustomer();
 			Vector<Vector<String>>  rowData=new Vector<Vector<String>>();
 			for(int i=0;i<list.size();i++){
 				Vector<String> vector =new Vector<String>();
 				vector.add(this.list.get(i).getCustomerID()+"");
 				vector.add(this.list.get(i).getCustomerSimpleName());
 				vector.add(this.list.get(i).getCustomerName());
 				vector.add(this.list.get(i).getCustomerOwner());
 				vector.add(this.list.get(i).getCustomerTele());
 				vector.add(this.list.get(i).getCustomerMob());
 				vector.add(this.list.get(i).getCustomerFax());
 				vector.add(this.list.get(i).getCustomerAddress());
 				vector.add(this.list.get(i).getDeliveryAddress());
 				vector.add(this.list.get(i).getInvoiceAddress());
 				vector.add( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.list.get(i).getLastDeliveryDate()));
 				rowData.add(vector);
 			}
 			
 			// 新建表格
 			tableModel = new DefaultTableModel(rowData,columnNames);	
 			table = new JTable(tableModel);
 			
 			
 			JScrollPane s = new JScrollPane(table);
 			
 			// 将面板和表格分别添加到窗体中
 			this.add(panelUP,BorderLayout.SOUTH);
 			this.add(s);
 			
 			this.table.setEnabled(false);
 			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		 // 设置窗体可关闭
 			
 			
 		}
 		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource()==this.del){
				int[]rowcount=table.getSelectedRows();
				if(rowcount.length==0){
				
				}else{
					String[] customerID=new String[rowcount.length];
					for(int i=rowcount.length-1;i>=0;i--){
						customerID[i]=table.getValueAt(rowcount[i], 0).toString();
						tableModel.removeRow(rowcount[i]);
					}
					this.customerBL.deletecustomer(customerID);
					JOptionPane.showMessageDialog(this, "删除成功","提示信息",JOptionPane.INFORMATION_MESSAGE);
				}
			}
            if(e.getSource()==this.add){
            	int[]rowcount=table.getSelectedRows();
            	if(rowcount.length==0){
            	this.tableModel.addRow(new Vector<String>());
            	}else{
            		List<Customer> customer=new ArrayList<Customer>();
                	for(int i=0;i<rowcount.length;i++){
                    	String CustomerID=table.getValueAt(rowcount[i], 0).toString();
                    	String CustomerSimpleName=table.getValueAt(rowcount[i], 1).toString();
                    	String CustomerName=table.getValueAt(rowcount[i], 2).toString();
                    	String CustomerOnwer=table.getValueAt(rowcount[i], 3).toString();
                    	String CustomerTele=table.getValueAt(rowcount[i], 4).toString();
                    	String CustomerMob=table.getValueAt(rowcount[i], 5).toString();
                    	String CustomerFax=table.getValueAt(rowcount[i], 6).toString();
                    	String CustomerAddress=table.getValueAt(rowcount[i], 7).toString();
                    	String DeliveryAddress=table.getValueAt(rowcount[i], 8).toString();
                    	String InvoiceAddress=table.getValueAt(rowcount[i], 9).toString();
                    	Date LastDeliveryDate = null;
    					try {
    						LastDeliveryDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(table.getValueAt(rowcount[i], 10).toString());
    					} catch (ParseException e1) {
    						// TODO Auto-generated catch block
    						e1.printStackTrace();
    					}
                    	
                    	customer.add(new Customer(Long.parseLong(CustomerID),CustomerSimpleName,CustomerName,CustomerOnwer,CustomerTele,CustomerMob,
                    			     CustomerFax,CustomerAddress,DeliveryAddress,InvoiceAddress,LastDeliveryDate ));
                    		}
                	this.customerBL.insertcustomer(customer);
                	this.table.clearSelection();
                	JOptionPane.showMessageDialog(this, "添加成功","提示信息",JOptionPane.INFORMATION_MESSAGE);
            	}
			}
            if(e.getSource()==this.update){
            	int[]rowcount=table.getSelectedRows();
            	if(rowcount.length<0){
            	}else{
            	List<Customer> customer=new ArrayList<Customer>();
            	for(int i=0;i<rowcount.length;i++){
                	String CustomerID=table.getValueAt(rowcount[i], 0).toString();
                	String CustomerSimpleName=table.getValueAt(rowcount[i], 1).toString();
                	String CustomerName=table.getValueAt(rowcount[i], 2).toString();
                	String CustomerOnwer=table.getValueAt(rowcount[i], 3).toString();
                	String CustomerTele=table.getValueAt(rowcount[i], 4).toString();
                	String CustomerMob=table.getValueAt(rowcount[i], 5).toString();
                	String CustomerFax=table.getValueAt(rowcount[i], 6).toString();
                	String CustomerAddress=table.getValueAt(rowcount[i], 7).toString();
                	String DeliveryAddress=table.getValueAt(rowcount[i], 8).toString();
                	String InvoiceAddress=table.getValueAt(rowcount[i], 9).toString();
                	Date LastDeliveryDate = null;
					try {
						LastDeliveryDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(table.getValueAt(rowcount[i], 10).toString());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                	
                	customer.add(new Customer(Long.parseLong(CustomerID),CustomerSimpleName,CustomerName,CustomerOnwer,CustomerTele,CustomerMob,
                			     CustomerFax,CustomerAddress,DeliveryAddress,InvoiceAddress,LastDeliveryDate ));
                		}
            	this.customerBL.updatecustomer(customer);
            	this.table.clearSelection();
            	JOptionPane.showMessageDialog(this, "修改成功","提示信息",JOptionPane.INFORMATION_MESSAGE);
            	}
            }
            if(e.getSource()==this.edit){
            	if(this.edit.getText().equals("编辑")){
            		this.table.setEnabled(true);
            		this.edit.setText("取消编辑");
            	}else{
            		this.table.setEnabled(false);
            		this.edit.setText("编辑");
            		this.table.clearSelection();
            	}
				
			}
		}
		}
