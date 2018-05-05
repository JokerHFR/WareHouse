package com.hu.jpanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.hu.blservice.SalesmanBL;
import com.hu.model.Salesman;
import com.hu.spring.SprMb;

public class JPanel_0 extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel tableModel;		// 默认显示的表格
	private JButton add,del,edit,update;		// 各处理按钮
	private JTable table;		// 表格
	private JPanel panelUP;
	private List<Salesman> list=new ArrayList<Salesman>();
	private SalesmanBL salesmanBL=(SalesmanBL) SprMb.actx.getBean("salesmanBL");
    public JPanel_0(){
//    	this.setTitle("员工资料维护");
 		this.setSize(800, 400);//设置窗体的大小
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
 			columnNames.add("员工编号");
 			columnNames.add("姓名");
 			columnNames.add("移动电话");
 			columnNames.add("固定电话");
 			columnNames.add("住址");
 			columnNames.add("邮箱");
 			
 			// 取得haha数据库的aa表的表头数据
 			this.list=this.salesmanBL.findAllsalesman();
 			Vector<Vector<String>>  rowData=new Vector<Vector<String>>();
 			for(int i=0;i<list.size();i++){
 				Vector<String> vector =new Vector<String>();
 				vector.add(this.list.get(i).getSalesManID()+"");
 				vector.add(this.list.get(i).getSalesManName());
 				vector.add(this.list.get(i).getSalesManTele());
 				vector.add(this.list.get(i).getSalesManMob());
 				vector.add(this.list.get(i).getSalesManAdd());
 				vector.add(this.list.get(i).getSalesManEmail());
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
					String[] salesmanID=new String[rowcount.length];
					for(int i=rowcount.length-1;i>=0;i--){
						salesmanID[i]=table.getValueAt(rowcount[i], 0).toString();
						tableModel.removeRow(rowcount[i]);
					}
					this.salesmanBL.deletesalesman(salesmanID);
					JOptionPane.showMessageDialog(this, "删除成功","提示信息",JOptionPane.INFORMATION_MESSAGE);
				}
			}
            if(e.getSource()==this.add){
            	int[]rowcount=table.getSelectedRows();
            	if(rowcount.length==0){
            	this.tableModel.addRow(new Vector<String>());
            	}else{
            		List<Salesman> salseman=new ArrayList<Salesman>();
                	for(int i=0;i<rowcount.length;i++){
                	String salesmanid=table.getValueAt(rowcount[i], 0).toString();
                	String salesmanname=table.getValueAt(rowcount[i], 1).toString();
                	String salesmantele=table.getValueAt(rowcount[i], 2).toString();
                	String salesmanmob=table.getValueAt(rowcount[i], 3).toString();
                	String salesmanadd=table.getValueAt(rowcount[i], 4).toString();
                	String salesmanemail=table.getValueAt(rowcount[i], 5).toString();
                	salseman.add(new Salesman(Long.parseLong(salesmanid),salesmanname,salesmantele,salesmanmob,salesmanadd,salesmanemail));
                		}
                	this.salesmanBL.insertsalesman(salseman);
                	this.table.clearSelection();
                	JOptionPane.showMessageDialog(this, "添加成功","提示信息",JOptionPane.INFORMATION_MESSAGE);
            	}
			}
            if(e.getSource()==this.update){
            	int[]rowcount=table.getSelectedRows();
            	if(rowcount.length<0){
            	}else{
            	List<Salesman> salseman=new ArrayList<Salesman>();
            	for(int i=0;i<rowcount.length;i++){
            	String salesmanid=table.getValueAt(rowcount[i], 0).toString();
            	String salesmanname=table.getValueAt(rowcount[i], 1).toString();
            	String salesmantele=table.getValueAt(rowcount[i], 2).toString();
            	String salesmanmob=table.getValueAt(rowcount[i], 3).toString();
            	String salesmanadd=table.getValueAt(rowcount[i], 4).toString();
            	String salesmanemail=table.getValueAt(rowcount[i], 5).toString();
            	salseman.add(new Salesman(Long.parseLong(salesmanid),salesmanname,salesmantele,salesmanmob,salesmanadd,salesmanemail));
            		}
            	this.salesmanBL.updatesalesman(salseman);
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
