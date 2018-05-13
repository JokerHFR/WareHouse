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
	private DefaultTableModel tableModel;		// Ĭ����ʾ�ı��
	private JButton add,del,edit,update;		// ������ť
	private JTable table;		// ���
	private JPanel panelUP;
	private List<Supplier> list=new ArrayList<Supplier>();
	private SupplierBL supplierBL=(SupplierBL) SprMb.actx.getBean("supplierBL");
    public JPanel_2(){
//    	this.setTitle("��Ӧ������ά��");
 		this.setSize(800, 470);//���ô���Ĵ�С
 		//this.setLocation(500, 500);//���ô����λ��
// 		this.setLocationRelativeTo(null);//���ô��������ʾ
// 		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//���ô���Ĺرշ�ʽ��Ĭ��ֵΪ��������أ�
// 		this.setResizable(false);//���ò���ͨ���������ק���ı䴰��Ĵ�С
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
 			columnNames.add("��Ӧ�̱��");
 			columnNames.add("��˾���");
 			columnNames.add("��˾ȫ��");
 			columnNames.add("����������");
 			columnNames.add("�ƶ��绰");
 			columnNames.add("�̶��绰");
 			columnNames.add("����");
 			columnNames.add("��˾��ַ");
 			columnNames.add("����������ַ");
 			columnNames.add("����������");
 			
 			
 			// ȡ��haha���ݿ��aa��ı�ͷ����
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
 			
 			// �½����
 			tableModel = new DefaultTableModel(rowData,columnNames);	
 			table = new JTable(tableModel);
 			
 			
 			JScrollPane s = new JScrollPane(table);
 			
 			// �����ͱ��ֱ���ӵ�������
 			this.add(panelUP,BorderLayout.SOUTH);
 			this.add(s);
 			
 			this.table.setEnabled(false);
// 			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		 // ���ô���ɹر�
 			
 			
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
					JOptionPane.showMessageDialog(this, "ɾ���ɹ�","��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
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
                    	JOptionPane.showMessageDialog(this, "��ӳɹ�","��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
                    	}else{
                    	JOptionPane.showMessageDialog(this, "���ʧ�ܣ���Щ��Ϣ����Ϊ�գ�","��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
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
                	JOptionPane.showMessageDialog(this, "�޸ĳɹ�","��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
                	}else{
                	JOptionPane.showMessageDialog(this, "�޸�ʧ�ܣ����ܸ��Ĺ�Ӧ�̱��","��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
                	}
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
