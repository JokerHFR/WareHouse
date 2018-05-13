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

import com.hu.blservice.DeliverymasterBL;
import com.hu.jframe.LookDelFrame;
import com.hu.model.Deliverymaster;
import com.hu.spring.SprMb;

public class JPanel_8 extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel tableModel;		// Ĭ����ʾ�ı��
	private JButton del,edit,look;		// ������ť
	private JTable table;		// ���
	private JPanel panelUP;
	private List<Deliverymaster> list=new ArrayList<Deliverymaster>();
	private DeliverymasterBL deliverymasterBL=(DeliverymasterBL) SprMb.actx.getBean("deliverymasterBL");
    public JPanel_8(){
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
 			columnNames.add("�ͻ���");
 			columnNames.add("��������");
 			columnNames.add("����Ա");
 			columnNames.add("�ͻ���ַ");
 			
 			// ȡ��haha���ݿ��aa��ı�ͷ����
 			this.list=this.deliverymasterBL.findAlldeliverymaster();
 			Vector<Vector<String>>  rowData=new Vector<Vector<String>>();
 			for(int i=0;i<list.size();i++){
 				Vector<String> vector =new Vector<String>();
 				vector.add(this.list.get(i).getDeliveryID()+"");
 				vector.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.list.get(i).getDeliveryDate()));
 				vector.add(this.list.get(i).getDelMoney()+"");
 				vector.add(this.list.get(i).getCustomer().getCustomerName());
 				if(this.list.get(i).getDeliveryPro()==1){
 				vector.add("���۵�");
 				vector.add(this.list.get(i).getSalesman().getSalesManName());
 				vector.add(this.list.get(i).getDeliveryAddress());
 				}else{
 				vector.add("�˻���");
 	 			vector.add("");
 	 			vector.add("");
 				}
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
					String[] DeliveryID=new String[rowcount.length];
					for(int i=rowcount.length-1;i>=0;i--){
						DeliveryID[i]=table.getValueAt(rowcount[i], 0).toString();
						tableModel.removeRow(rowcount[i]);
					}
					this.deliverymasterBL.deletedeliverymaster(DeliveryID);
					JOptionPane.showMessageDialog(this, "ɾ���ɹ�","��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
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
