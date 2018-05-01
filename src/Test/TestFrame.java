package Test;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class TestFrame extends JFrame{
	
	DefaultTableModel tableModel;		// 默认显示的表格
	JButton add,del,exit,save;		// 各处理按钮
	JTable table;		// 表格
	
	JPanel panelUP;	//增加信息的面板
	
	// 构造函数
	public TestFrame(){
		this.setBounds(300, 200, 600, 450);		// 设置窗体大小
		this.setTitle("测试");		// 设置窗体名称
		this.setLayout(new BorderLayout());	// 设置窗体的布局方式
				
		// 新建各按钮组件
		add = new JButton("增加");
		del = new JButton("删除");
		save = new JButton("修改");
		exit = new JButton("退出");
		
		panelUP = new JPanel();		// 新建按钮组件面板
		panelUP.setLayout(new FlowLayout(FlowLayout.CENTER,50,10));	// 设置面板的布局方式
		
		// 将各按钮组件依次添加到面板中
		panelUP.add(add);
		panelUP.add(del);
		panelUP.add(save);
		panelUP.add(exit);
		
		// 取得haha数据库的aa表的各行数据
		Vector<String> columnNames =new Vector<String>();
		columnNames.add("姓名");
		columnNames.add("年龄");
		columnNames.add("性别");
		
		// 取得haha数据库的aa表的表头数据
		Vector<Vector<String>>  rowData=new Vector<Vector<String>>();
		for(int i=0;i<30;i++){
			Vector<String> vector =new Vector<String>();
			vector.add("张三"+i);
			vector.add("10"+i);
			vector.add("男"+i);
			rowData.add(vector);
		}
		
		// 新建表格
		tableModel = new DefaultTableModel(rowData,columnNames);	
		table = new JTable(tableModel);
		
		
		JScrollPane s = new JScrollPane(table);
		
		// 将面板和表格分别添加到窗体中
		this.add(panelUP,BorderLayout.SOUTH);
		this.add(s);
		
		// 事件处理
		MyEvent();
		
		this.setVisible(true);		// 显示窗体
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		 // 设置窗体可关闭
	}
	
	// 事件处理
	public void MyEvent(){
		
		// 增加
		add.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// 增加一行空白区域
				tableModel.addRow(new Vector<String>());
			}
			
		});
		
		// 删除
		del.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// 删除指定行
				int[]rowcount=table.getSelectedRows();
				for(int i=rowcount.length-1;i>=0;i--){
					tableModel.removeRow(rowcount[i]);
					System.out.println(rowcount[i]);
				}
			}
			
		});
		
		/**
		 * 保存
		 * 我的解决办法是直接将aa表中的全部数据删除，
		 * 将表格中的所有内容获取到,
		 * 然后将表格数据重新写入aa表
		 */
		save.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {	
				int column = table.getColumnCount();		// 表格列数
				int row = table.getRowCount();		// 表格行数
				
				// value数组存放表格中的所有数据
				String[][] value = new String[row][column];
				
				for(int i = 0; i < row; i++){
					for(int j = 0; j < column; j++){
						value[i][j] = table.getValueAt(i, j).toString();
					}
				}
				
				
			}
		});
		
		// 退出
		exit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				System.exit(0);
			}
				
		});
	}
	
	// 主函数
	public static void main(String[] args){
		new TestFrame();
	}
}