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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hu.blservice.SupplierBL;
import com.hu.model.Supplier;
import com.hu.spring.SprMb;

public class JPanel_2 extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel tableModel;		// 默认显示的表格
	private JButton add,del,edit,update;		// 各处理按钮
	private JTable table;		// 表格
	private JPanel panelUP;
	private List<Supplier> list=new ArrayList<Supplier>();
	private SupplierBL supplierBL=(SupplierBL) SprMb.actx.getBean("supplierBL");
    public JPanel_2(){
//    	this.setTitle("供应商资料维护");
 		this.setSize(800, 470);//设置窗体的大小
 		//this.setLocation(500, 500);//设置窗体的位置
// 		this.setLocationRelativeTo(null);//设置窗体居中显示
// 		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置窗体的关闭方式（默认值为窗体的隐藏）
// 		this.setResizable(false);//设置不能通过窗体的拖拽，改变窗体的大小
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
 			columnNames.add("供应商编号");
 			columnNames.add("公司简称");
 			columnNames.add("公司全称");
 			columnNames.add("负责人名字");
 			columnNames.add("移动电话");
 			columnNames.add("固定电话");
 			columnNames.add("传真");
 			columnNames.add("公司地址");
 			columnNames.add("生产工厂地址");
 			columnNames.add("最后进货日期");
 			
 			
 			// 取得haha数据库的aa表的表头数据
 			this.list=this.supplierBL.findAllsupplier();
 			Vector<Vector<String>>  rowData=new Vector<Vector<String>>();
 			for(int i=0;i<list.size();i++){
 				Vector<String> vector =new Vector<String>();
 				vector.add(this.list.get(i).getSupplierID()+"");
 				vector.add(this.list.get(i).getSupplierSimpleName());
 				vector.add(this.list.get(i).getSupplierName());
 				vector.add(this.list.get(i).getSupplierOwner());
 				vector.add(this.list.get(i).getSupplierTele());
 				vector.add(this.list.get(i).getSupplierMob());
 				vector.add(this.list.get(i).getSupplierFax());
 				vector.add(this.list.get(i).getSuppliercomAddress());
 				vector.add(this.list.get(i).getSupplierFacAddress());
 				vector.add( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.list.get(i).getSupplierLastPurDate()));
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
// 			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		 // 设置窗体可关闭
 			
 			
 		}
 		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource()==this.del){
				int[]rowcount=table.getSelectedRows();
				if(rowcount.length==0){
				
				}else{
					String[] supplierID=new String[rowcount.length];
					for(int i=rowcount.length-1;i>=0;i--){
						supplierID[i]=table.getValueAt(rowcount[i], 0).toString();
						tableModel.removeRow(rowcount[i]);
					}
					this.supplierBL.deletesupplier(supplierID);
					JOptionPane.showMessageDialog(this, "删除成功","提示信息",JOptionPane.INFORMATION_MESSAGE);
				}
			}
            if(e.getSource()==this.add){
            	int[]rowcount=table.getSelectedRows();
            	if(rowcount.length==0){
            	this.tableModel.addRow(new Vector<String>());
            	}else{
            		List<Supplier> supplier=new ArrayList<Supplier>();
                	for(int i=0;i<rowcount.length;i++){
                    	String SupplierID=table.getValueAt(rowcount[i], 0).toString();
                    	String SupplierSimpleName=table.getValueAt(rowcount[i], 1).toString();
                    	String SupplierName=table.getValueAt(rowcount[i], 2).toString();
                    	String SupplierOnwer=table.getValueAt(rowcount[i], 3).toString();
                    	String SupplierTele=table.getValueAt(rowcount[i], 4).toString();
                    	String SupplierMob=table.getValueAt(rowcount[i], 5).toString();
                    	String SupplierFax=table.getValueAt(rowcount[i], 6).toString();
                    	String SuppliercomAddress=table.getValueAt(rowcount[i], 7).toString();
                    	String SupplierFacAddress=table.getValueAt(rowcount[i], 8).toString();
                    	Date SupplierLastPurDate = null;
    					try {
    						SupplierLastPurDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(table.getValueAt(rowcount[i], 9).toString());
    					} catch (ParseException e1) {
    						// TODO Auto-generated catch block
    						e1.printStackTrace();
    					}	
    					supplier.add(new Supplier(Long.parseLong(SupplierID),SupplierSimpleName,SupplierName,SupplierOnwer,SupplierTele,SupplierMob,
    							SupplierFax,SuppliercomAddress,SupplierFacAddress,SupplierLastPurDate ));
                    		}
                	int m=this.supplierBL.insertsupplier(supplier);
                	this.table.clearSelection();
                	if(m==1){
                    	JOptionPane.showMessageDialog(this, "添加成功","提示信息",JOptionPane.INFORMATION_MESSAGE);
                    	}else{
                    	JOptionPane.showMessageDialog(this, "添加失败，有些信息不能为空！","提示信息",JOptionPane.INFORMATION_MESSAGE);
                    	}
            	}
			}
            if(e.getSource()==this.update){
            	int[]rowcount=table.getSelectedRows();
            	if(rowcount.length==0){
            	}else{
            		List<Supplier> supplier=new ArrayList<Supplier>();
                	for(int i=0;i<rowcount.length;i++){
                    	String SupplierID=table.getValueAt(rowcount[i], 0).toString();
                    	String SupplierSimpleName=table.getValueAt(rowcount[i], 1).toString();
                    	String SupplierName=table.getValueAt(rowcount[i], 2).toString();
                    	String SupplierOnwer=table.getValueAt(rowcount[i], 3).toString();
                    	String SupplierTele=table.getValueAt(rowcount[i], 4).toString();
                    	String SupplierMob=table.getValueAt(rowcount[i], 5).toString();
                    	String SupplierFax=table.getValueAt(rowcount[i], 6).toString();
                    	String SuppliercomAddress=table.getValueAt(rowcount[i], 7).toString();
                    	String SupplierFacAddress=table.getValueAt(rowcount[i], 8).toString();
                    	Date SupplierLastPurDate = null;
    					try {
    						SupplierLastPurDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(table.getValueAt(rowcount[i], 9).toString());
    					} catch (ParseException e1) {
    						// TODO Auto-generated catch block
    						e1.printStackTrace();
    					}
                    	
    					supplier.add(new Supplier(Long.parseLong(SupplierID),SupplierSimpleName,SupplierName,SupplierOnwer,SupplierTele,SupplierMob,
    							SupplierFax,SuppliercomAddress,SupplierFacAddress,SupplierLastPurDate ));
                    		}
                	int m=this.supplierBL.updatesupplier(supplier);
            	this.table.clearSelection();
            	if(m==1){
                	JOptionPane.showMessageDialog(this, "修改成功","提示信息",JOptionPane.INFORMATION_MESSAGE);
                	}else{
                	JOptionPane.showMessageDialog(this, "修改失败，不能更改供应商编号","提示信息",JOptionPane.INFORMATION_MESSAGE);
                	}
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
