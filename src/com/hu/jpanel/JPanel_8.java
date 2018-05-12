package com.hu.jpanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hu.blservice.DeliverymasterBL;
import com.hu.jframe.LookDelFrame;
import com.hu.model.Deliverymaster;
import com.hu.spring.SprMb;

public class JPanel_8 extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel tableModel;		// 默认显示的表格
	private JButton del,edit,look;		// 各处理按钮
	private JTable table;		// 表格
	private JPanel panelUP;
	private List<Deliverymaster> list=new ArrayList<Deliverymaster>();
	private DeliverymasterBL deliverymasterBL=(DeliverymasterBL) SprMb.actx.getBean("deliverymasterBL");
    public JPanel_8(){
//    	this.setTitle("销售单管理");
 		this.setSize(800, 400);//设置窗体的大小
 		//this.setLocation(500, 500);//设置窗体的位置
// 		this.setLocationRelativeTo(null);//设置窗体居中显示
// 		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置窗体的关闭方式（默认值为窗体的隐藏）
// 		this.setResizable(false);//设置不能通过窗体的拖拽，改变窗体的大小
 		this.setLayout(new BorderLayout());//设置窗体的布局方式（按照坐标进行布局）
 		
 	// 新建各按钮组件
 			del = new JButton("删除");
 			this.del.addActionListener(this);
 			edit = new JButton("编辑");
 			this.edit.addActionListener(this);
 			look = new JButton("查看订单");
 			this.look.addActionListener(this);
 			
 			panelUP = new JPanel();		// 新建按钮组件面板
 			panelUP.setLayout(new FlowLayout(FlowLayout.CENTER,50,10));	// 设置面板的布局方式
 			
 			// 将各按钮组件依次添加到面板中
 			panelUP.add(del);
 			panelUP.add(look);
 			panelUP.add(edit);
 			
 			// 取得haha数据库的aa表的各行数据
 			Vector<String> columnNames =new Vector<String>();
 			columnNames.add("销售单号");
 			columnNames.add("订单时间");
 			columnNames.add("订单总金额");
 			columnNames.add("客户名");
 			columnNames.add("订单类型");
 			columnNames.add("销售员");
 			columnNames.add("送货地址");
 			
 			// 取得haha数据库的aa表的表头数据
 			this.list=this.deliverymasterBL.findAlldeliverymaster();
 			Vector<Vector<String>>  rowData=new Vector<Vector<String>>();
 			for(int i=0;i<list.size();i++){
 				Vector<String> vector =new Vector<String>();
 				vector.add(this.list.get(i).getDeliveryID()+"");
 				vector.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.list.get(i).getDeliveryDate()));
 				vector.add(this.list.get(i).getDelMoney()+"");
 				vector.add(this.list.get(i).getCustomer().getCustomerName());
 				if(this.list.get(i).getDeliveryPro()==1){
 				vector.add("销售单");
 				vector.add(this.list.get(i).getSalesman().getSalesManName());
 				vector.add(this.list.get(i).getDeliveryAddress());
 				}else{
 				vector.add("退货单");
 	 			vector.add("");
 	 			vector.add("");
 				}
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
					String[] DeliveryID=new String[rowcount.length];
					for(int i=rowcount.length-1;i>=0;i--){
						DeliveryID[i]=table.getValueAt(rowcount[i], 0).toString();
						tableModel.removeRow(rowcount[i]);
					}
					this.deliverymasterBL.deletedeliverymaster(DeliveryID);
					JOptionPane.showMessageDialog(this, "删除成功","提示信息",JOptionPane.INFORMATION_MESSAGE);
				}
			}
            if(e.getSource()==this.look){
            	int[]rowcount=table.getSelectedRows();
				if(rowcount.length==0){
				
				}else{
					for(int i=0;i<rowcount.length;i++){
						new LookDelFrame(this.list.get(rowcount[i])).setVisible(true);
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
