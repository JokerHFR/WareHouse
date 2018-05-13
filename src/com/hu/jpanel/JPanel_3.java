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

import com.hu.blservice.ProductBL;
import com.hu.model.Product;
import com.hu.model.Supplier;
import com.hu.spring.SprMb;

public class JPanel_3 extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel tableModel;		// Ĭ����ʾ�ı��
	private JButton add,del,edit,update;		// ������ť
	private JTable table;		// ���
	private JPanel panelUP;
	private List<Product> list=new ArrayList<Product>();
	private ProductBL productBL=(ProductBL) SprMb.actx.getBean("productBL");
    public JPanel_3(){
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
 			columnNames.add("��Ʒ���");
 			columnNames.add("��Ʒ����");
 			columnNames.add("��Ʒ����");
 			columnNames.add("��Ʒ��λ");
 			columnNames.add("��ȫ����");
 			columnNames.add("����������");
 			columnNames.add("����ۻ�����");
 			columnNames.add("���鹺��۸�");
 			columnNames.add("�������ۼ۸�");
 			columnNames.add("������");
 			
 			
 			// ȡ��haha���ݿ��aa��ı�ͷ����
 			this.list=this.productBL.findAllproduct();
 			Vector<Vector<String>>  rowData=new Vector<Vector<String>>();
 			for(int i=0;i<list.size();i++){
 				Vector<String> vector =new Vector<String>();
 				vector.add(this.list.get(i).getProductID()+"");
 				vector.add(this.list.get(i).getProductName());
 				vector.add(this.list.get(i).getQuantity()+"");
 				vector.add(this.list.get(i).getProductUnit());
 				vector.add(this.list.get(i).getSafeStock()+"");
 				vector.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.list.get(i).getLastPurDate()));
 				vector.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.list.get(i).getLastDelDate()));
 				vector.add(this.list.get(i).getSuggestBuyPrice()+"");
 				vector.add(this.list.get(i).getSuggestSalePrice()+"");
 				vector.add(this.list.get(i).getSupplier().getSupplierSimpleName());
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
					String[] productID=new String[rowcount.length];
					for(int i=rowcount.length-1;i>=0;i--){
						productID[i]=table.getValueAt(rowcount[i], 0).toString();
						tableModel.removeRow(rowcount[i]);
					}
					this.productBL.deleteproduct(productID);
					JOptionPane.showMessageDialog(this, "ɾ���ɹ�","��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
				}
			}
            if(e.getSource()==this.add){
            	int[]rowcount=table.getSelectedRows();
            	if(rowcount.length==0){
            	this.tableModel.addRow(new Vector<String>());
            	}else{
            		List<Product> product=new ArrayList<Product>();
                	for(int i=0;i<rowcount.length;i++){
                    	String ProductID=table.getValueAt(rowcount[i], 0).toString();
                    	String ProductName=table.getValueAt(rowcount[i], 1).toString();
                    	String Quantity=table.getValueAt(rowcount[i], 2).toString();
                    	String ProductUnit=table.getValueAt(rowcount[i], 3).toString();
                    	String SafeStock=table.getValueAt(rowcount[i], 4).toString();
                    	String SuggestBuyPrice=table.getValueAt(rowcount[i], 7).toString();
                    	String SuggestSalePrice=table.getValueAt(rowcount[i], 8).toString();
                    	Supplier s=null;
                    	for(int n=0;n<list.size();n++){
                    		if(table.getValueAt(rowcount[i], 9).toString().equals(list.get(n).getSupplier().getSupplierSimpleName())){
                    			s=list.get(n).getSupplier();
                    		}
                    	}
                    	Date LastPurDate = null;
                    	Date LastDelDate = null;
    					try {
    						LastPurDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(table.getValueAt(rowcount[i], 5).toString());
    						LastDelDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(table.getValueAt(rowcount[i], 6).toString());
    					} catch (ParseException e1) {
    						// TODO Auto-generated catch block
    						e1.printStackTrace();
    					}	
    					product.add(new Product(Long.parseLong(ProductID),ProductName,ProductUnit,Long.parseLong(SafeStock),LastPurDate,LastDelDate,
    							Long.parseLong(Quantity),Double.parseDouble(SuggestBuyPrice),Double.parseDouble(SuggestSalePrice),s ));
                    		}
                	int m=this.productBL.insertproduct(product);
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
            	this.tableModel.addRow(new Vector<String>());
            	}else{
            		List<Product> product=new ArrayList<Product>();
                	for(int i=0;i<rowcount.length;i++){
                    	String ProductID=table.getValueAt(rowcount[i], 0).toString();
                    	String ProductName=table.getValueAt(rowcount[i], 1).toString();
                    	String Quantity=table.getValueAt(rowcount[i], 2).toString();
                    	String ProductUnit=table.getValueAt(rowcount[i], 3).toString();
                    	String SafeStock=table.getValueAt(rowcount[i], 4).toString();
                    	String SuggestBuyPrice=table.getValueAt(rowcount[i], 7).toString();
                    	String SuggestSalePrice=table.getValueAt(rowcount[i], 8).toString();
                    	Supplier s=null;
                    	for(int n=0;n<list.size();n++){
                    		if(table.getValueAt(rowcount[i], 9).toString().equals(list.get(n).getSupplier().getSupplierSimpleName())){
                    			s=list.get(n).getSupplier();
                    		}
                    	}
                    	Date LastPurDate = null;
                    	Date LastDelDate = null;
    					try {
    						LastPurDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(table.getValueAt(rowcount[i], 5).toString());
    						LastDelDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(table.getValueAt(rowcount[i], 6).toString());
    					} catch (ParseException e1) {
    						// TODO Auto-generated catch block
    						e1.printStackTrace();
    					}	
    					product.add(new Product(Long.parseLong(ProductID),ProductName,ProductUnit,Long.parseLong(SafeStock),LastPurDate,LastDelDate,
    							Long.parseLong(Quantity),Double.parseDouble(SuggestBuyPrice),Double.parseDouble(SuggestSalePrice),s ));
                    		}
                	int m=this.productBL.updateproduct(product);
            	this.table.clearSelection();
            	if(m==1){
                	JOptionPane.showMessageDialog(this, "�޸ĳɹ�","��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
                	}else{
                	JOptionPane.showMessageDialog(this, "�޸�ʧ�ܣ����ܸ�����Ʒ���","��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
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

