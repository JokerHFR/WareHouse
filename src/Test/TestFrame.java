package Test;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class TestFrame extends JFrame{
	
	DefaultTableModel tableModel;		// Ĭ����ʾ�ı��
	JButton add,del,exit,save;		// ������ť
	JTable table;		// ���
	
	JPanel panelUP;	//������Ϣ�����
	
	// ���캯��
	public TestFrame(){
		this.setBounds(300, 200, 600, 450);		// ���ô����С
		this.setTitle("����");		// ���ô�������
		this.setLayout(new BorderLayout());	// ���ô���Ĳ��ַ�ʽ
				
		// �½�����ť���
		add = new JButton("����");
		del = new JButton("ɾ��");
		save = new JButton("�޸�");
		exit = new JButton("�˳�");
		
		panelUP = new JPanel();		// �½���ť������
		panelUP.setLayout(new FlowLayout(FlowLayout.CENTER,50,10));	// �������Ĳ��ַ�ʽ
		
		// ������ť���������ӵ������
		panelUP.add(add);
		panelUP.add(del);
		panelUP.add(save);
		panelUP.add(exit);
		
		// ȡ��haha���ݿ��aa��ĸ�������
		Vector<String> columnNames =new Vector<String>();
		columnNames.add("����");
		columnNames.add("����");
		columnNames.add("�Ա�");
		
		// ȡ��haha���ݿ��aa��ı�ͷ����
		Vector<Vector<String>>  rowData=new Vector<Vector<String>>();
		for(int i=0;i<30;i++){
			Vector<String> vector =new Vector<String>();
			vector.add("����"+i);
			vector.add("10"+i);
			vector.add("��"+i);
			rowData.add(vector);
		}
		
		// �½����
		tableModel = new DefaultTableModel(rowData,columnNames);	
		table = new JTable(tableModel);
		
		
		JScrollPane s = new JScrollPane(table);
		
		// �����ͱ��ֱ���ӵ�������
		this.add(panelUP,BorderLayout.SOUTH);
		this.add(s);
		
		// �¼�����
		MyEvent();
		
		this.setVisible(true);		// ��ʾ����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		 // ���ô���ɹر�
	}
	
	// �¼�����
	public void MyEvent(){
		
		// ����
		add.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// ����һ�пհ�����
				tableModel.addRow(new Vector<String>());
			}
			
		});
		
		// ɾ��
		del.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// ɾ��ָ����
				int[]rowcount=table.getSelectedRows();
				for(int i=rowcount.length-1;i>=0;i--){
					tableModel.removeRow(rowcount[i]);
					System.out.println(rowcount[i]);
				}
			}
			
		});
		
		/**
		 * ����
		 * �ҵĽ���취��ֱ�ӽ�aa���е�ȫ������ɾ����
		 * ������е��������ݻ�ȡ��,
		 * Ȼ�󽫱����������д��aa��
		 */
		save.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {	
				int column = table.getColumnCount();		// �������
				int row = table.getRowCount();		// �������
				
				// value�����ű���е���������
				String[][] value = new String[row][column];
				
				for(int i = 0; i < row; i++){
					for(int j = 0; j < column; j++){
						value[i][j] = table.getValueAt(i, j).toString();
					}
				}
				
				
			}
		});
		
		// �˳�
		exit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				System.exit(0);
			}
				
		});
	}
	
	// ������
	public static void main(String[] args){
		new TestFrame();
	}
}