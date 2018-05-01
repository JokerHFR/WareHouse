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
	private DefaultTableModel tableModel;		// Ĭ����ʾ�ı��
	private JButton add,del,edit,update;		// ������ť
	private JTable table;		// ���
	private JPanel panelUP;
	private List<Customer> list=new ArrayList<Customer>();
	private CustomerBL customerBL=(CustomerBL) SprMb.actx.getBean("customerBL");
    public JPanel_1(){
    	this.setTitle("�ͻ�����ά��");
 		this.setSize(800, 470);//���ô���Ĵ�С
 		//this.setLocation(500, 500);//���ô����λ��
 		this.setLocationRelativeTo(null);//���ô��������ʾ
 		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//���ô���Ĺرշ�ʽ��Ĭ��ֵΪ��������أ�
 		this.setResizable(false);//���ò���ͨ���������ק���ı䴰��Ĵ�С
 		this.setLayout(new BorderLayout());//���ô���Ĳ��ַ�ʽ������������в��֣�
 		
 	// �½�����ť���
 			add = new JButton("����");
 			this.add.addActionListener(this);
 			del = new JButton("ɾ��");
 			this.del.addActionListener(this);
 			update = new JButton("�޸�");
 			this.update.addActionListener(this);
 			edit = new JButton("�༭");
 			this.edit.addActionListener(this);
 			
 			panelUP = new JPanel();		// �½���ť������
 			panelUP.setLayout(new FlowLayout(FlowLayout.CENTER,50,10));	// �������Ĳ��ַ�ʽ
 			
 			// ������ť���������ӵ������
 			panelUP.add(add);
 			panelUP.add(del);
 			panelUP.add(update);
 			panelUP.add(edit);
 			
 			// ȡ��haha���ݿ��aa��ĸ�������
 			Vector<String> columnNames =new Vector<String>();
 			columnNames.add("�ͻ����");
 			columnNames.add("��˾���");
 			columnNames.add("��˾ȫ��");
 			columnNames.add("����������");
 			columnNames.add("�ƶ��绰");
 			columnNames.add("�̶��绰");
 			columnNames.add("����");
 			columnNames.add("��˾��ַ");
 			columnNames.add("�ͻ���ַ");
 			columnNames.add("��Ʊ��ַ");
 			columnNames.add("����ͻ�����");
 			
 			
 			// ȡ��haha���ݿ��aa��ı�ͷ����
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
 			
 			// �½����
 			tableModel = new DefaultTableModel(rowData,columnNames);	
 			table = new JTable(tableModel);
 			
 			
 			JScrollPane s = new JScrollPane(table);
 			
 			// �����ͱ��ֱ���ӵ�������
 			this.add(panelUP,BorderLayout.SOUTH);
 			this.add(s);
 			
 			this.table.setEnabled(false);
 			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		 // ���ô���ɹر�
 			
 			
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
					JOptionPane.showMessageDialog(this, "ɾ���ɹ�","��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
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
                	JOptionPane.showMessageDialog(this, "��ӳɹ�","��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
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
            	JOptionPane.showMessageDialog(this, "�޸ĳɹ�","��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
            	}
            }
            if(e.getSource()==this.edit){
            	if(this.edit.getText().equals("�༭")){
            		this.table.setEnabled(true);
            		this.edit.setText("ȡ���༭");
            	}else{
            		this.table.setEnabled(false);
            		this.edit.setText("�༭");
            		this.table.clearSelection();
            	}
				
			}
		}
		}
