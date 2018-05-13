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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hu.blservice.PurchasemasterBL;
import com.hu.jframe.LookPurFrame;
import com.hu.model.Purchasemaster;
import com.hu.spring.SprMb;

public class JPanel_9 extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel tableModel;		// Ĭ����ʾ�ı��
	private JButton del,edit,look;		// ������ť
	private JTable table;		// ���
	private JPanel panelUP;
	private List<Purchasemaster> list=new ArrayList<Purchasemaster>();
	private PurchasemasterBL purchasemasterBL=(PurchasemasterBL) SprMb.actx.getBean("purchasemasterBL");
    public JPanel_9(){
//    	this.setTitle("���۵�����");
 		this.setSize(800, 400);//���ô���Ĵ�С
 		//this.setLocation(500, 500);//���ô����λ��
// 		this.setLocationRelativeTo(null);//���ô��������ʾ
// 		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//���ô���Ĺرշ�ʽ��Ĭ��ֵΪ��������أ�
// 		this.setResizable(false);//���ò���ͨ���������ק���ı䴰��Ĵ�С
 		this.setLayout(new BorderLayout());//���ô���Ĳ��ַ�ʽ������������в��֣�
 		
 	// �½�����ť���
 			del = new JButton("ɾ��");
 			this.del.addActionListener(this);
 			edit = new JButton("�༭");
 			this.edit.addActionListener(this);
 			look = new JButton("�鿴����");
 			this.look.addActionListener(this);
 			
 			panelUP = new JPanel();		// �½���ť������
 			panelUP.setLayout(new FlowLayout(FlowLayout.CENTER,50,10));	// �������Ĳ��ַ�ʽ
 			
 			// ������ť���������ӵ������
 			panelUP.add(del);
 			panelUP.add(look);
 			panelUP.add(edit);
 			
 			// ȡ��haha���ݿ��aa��ĸ�������
 			Vector<String> columnNames =new Vector<String>();
 			columnNames.add("���۵���");
 			columnNames.add("����ʱ��");
 			columnNames.add("�����ܽ��");
 			columnNames.add("������");
 			columnNames.add("��������");
 			columnNames.add("������ַ");
 			
 			// ȡ��haha���ݿ��aa��ı�ͷ����
 			this.list=this.purchasemasterBL.findAllpurchasemaster();
 			Vector<Vector<String>>  rowData=new Vector<Vector<String>>();
 			for(int i=0;i<list.size();i++){
 				Vector<String> vector =new Vector<String>();
 				vector.add(this.list.get(i).getPurchaseID()+"");
 				vector.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.list.get(i).getPurchaseDate()));
 				vector.add(this.list.get(i).getPurMoney()+"");
 				vector.add(this.list.get(i).getPurchasedetail().get(0).getProduct().getSupplier().getSupplierName());
 				vector.add((this.list.get(i).getPurchasePro()==1)?"������":"�˻���");
 				vector.add(this.list.get(i).getPurchasedetail().get(0).getProduct().getSupplier().getSuppliercomAddress());
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
					String[] PurchaseID=new String[rowcount.length];
					for(int i=rowcount.length-1;i>=0;i--){
						PurchaseID[i]=table.getValueAt(rowcount[i], 0).toString();
						tableModel.removeRow(rowcount[i]);
					}
					this.purchasemasterBL.deletepurchasemaster(PurchaseID);
					JOptionPane.showMessageDialog(this, "ɾ���ɹ�","��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
				}
			}
            if(e.getSource()==this.look){
            	int[]rowcount=table.getSelectedRows();
				if(rowcount.length==0){
				
				}else{
					for(int i=0;i<rowcount.length;i++){
						new LookPurFrame(this.list.get(rowcount[i])).setVisible(true);
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
