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
	private DefaultTableModel tableModel;		// Ĭ����ʾ�ı��
	private JButton add,del,edit,update;		// ������ť
	private JTable table;		// ���
	private JPanel panelUP;
	private List<Salesman> list=new ArrayList<Salesman>();
	private SalesmanBL salesmanBL=(SalesmanBL) SprMb.actx.getBean("salesmanBL");
    public JPanel_0(){
//    	this.setTitle("Ա������ά��");
 		this.setSize(800, 400);//���ô���Ĵ�С
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
 			columnNames.add("Ա�����");
 			columnNames.add("����");
 			columnNames.add("�ƶ��绰");
 			columnNames.add("�̶��绰");
 			columnNames.add("סַ");
 			columnNames.add("����");
 			
 			// ȡ��haha���ݿ��aa��ı�ͷ����
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
					String[] salesmanID=new String[rowcount.length];
					for(int i=rowcount.length-1;i>=0;i--){
						salesmanID[i]=table.getValueAt(rowcount[i], 0).toString();
						tableModel.removeRow(rowcount[i]);
					}
					this.salesmanBL.deletesalesman(salesmanID);
					JOptionPane.showMessageDialog(this, "ɾ���ɹ�","��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
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
                	JOptionPane.showMessageDialog(this, "��ӳɹ�","��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
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
