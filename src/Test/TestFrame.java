package Test;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class TestFrame extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar jMenuBar;
	private JMenu[] jMenu=new JMenu[5];
	private JMenuItem[] jMenuItem1=new JMenuItem[4];
	private JMenuItem[] jMenuItem2=new JMenuItem[2];
	private JMenuItem[] jMenuItem3=new JMenuItem[2];
	private JMenuItem[] jMenuItem4=new JMenuItem[1];
	private JMenuItem[] jMenuItem5=new JMenuItem[2];
	private JPanel  jp;
	private JPanel[] jp_=new JPanel[11];
	private CardLayout card;
	
	private String user="king";
	public TestFrame(){
		this.card=new CardLayout();
		this.jp=new JPanel();
		this.jp.setLayout(card);
		for(int i=0;i<jp_.length;i++){
			this.jp_[i]=new JPanel();
			jp_[i].add(new JLabel(" "+i));
			this.jp.add(jp_[i],""+i);
		}
		this.setTitle("仓库管理系统"+"                                 登录用户："+user);
		this.setSize(800, 500);//设置窗体的大小
		//this.setLocation(500, 500);//设置窗体的位置
		this.setLocationRelativeTo(null);//设置窗体居中显示
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗体的关闭方式（默认值为窗体的隐藏）
		this.setResizable(false);//设置不能通过窗体的拖拽，改变窗体的大小
		
		this.setLayout(new FlowLayout());//设置窗体的布局方式（按照坐标进行布局）
		
		this.jMenuBar=new JMenuBar();
		
		
		this.add(jp,"Center");
		
		//jMenu信息设置
		jMenu[0]=new JMenu("        基本资料维护        ");
		jMenu[1]=new JMenu("        采购管理        ");
		jMenu[2]=new JMenu("        销售管理        ");
	    jMenu[3]=new JMenu("        库存管理        ");
	    jMenu[4]=new JMenu("        系统维护        ");
	   
	    //jMenuItem信息设置
	    jMenuItem1[0]=new JMenuItem("        销售员资料        ");
	    jMenuItem1[1]=new JMenuItem("        客户资料        ");
	    jMenuItem1[2]=new JMenuItem("        供应商资料        ");
	    jMenuItem1[3]=new JMenuItem("        商品资料        ");
	    for(int i=0;i<jMenuItem1.length;i++){
	    	this.jMenu[0].add(jMenuItem1[i]);
	    	this.jMenuItem1[i].addActionListener(this);
	    }
	    
	    jMenuItem2[0]=new JMenuItem("        采购单录入");
	    jMenuItem2[1]=new JMenuItem("        退货单录入");
	    for(int i=0;i<jMenuItem2.length;i++){
	    	this.jMenu[1].add(jMenuItem2[i]);
	    	this.jMenuItem2[i].addActionListener(this);
	    }
	    
	    jMenuItem3[0]=new JMenuItem("        销售单录入");
	    jMenuItem3[1]=new JMenuItem("        退货单录入");
	    for(int i=0;i<jMenuItem3.length;i++){
	    	this.jMenu[2].add(jMenuItem3[i]);
	    	this.jMenuItem3[i].addActionListener(this);
	    }
	    
	    jMenuItem4[0]=new JMenuItem("       库存查询     ");
	    for(int i=0;i<jMenuItem4.length;i++){
	    	this.jMenu[3].add(jMenuItem4[i]);
	    	this.jMenuItem4[i].addActionListener(this);
	    }
	    
	    jMenuItem5[0]=new JMenuItem("    用户资料管理");
	    jMenuItem5[1]=new JMenuItem("    修改密码");
	    for(int i=0;i<jMenuItem5.length;i++){
	    	this.jMenu[4].add(jMenuItem5[i]);
	    	this.jMenuItem5[i].addActionListener(this);
	    }
	    
	    for(int i=0;i<jMenu.length;i++){
	    	this.jMenuBar.add(jMenu[i]);
	    }
	    this.setJMenuBar(this.jMenuBar);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.jMenuItem1[0]){
			this.card.show(jp, "0");
		}
        if(e.getSource()==this.jMenuItem1[1]){
        	this.card.show(jp, "1");
		}
        if(e.getSource()==this.jMenuItem1[2]){
        	this.card.show(jp, "2");
		}
        if(e.getSource()==this.jMenuItem1[3]){
        	this.card.show(jp, "3");
		}
        if(e.getSource()==this.jMenuItem2[0]){
        	this.card.show(jp, "4");
		}
        if(e.getSource()==this.jMenuItem2[1]){
        	this.card.show(jp, "5");
		}
        if(e.getSource()==this.jMenuItem3[0]){
        	this.card.show(jp, "6");
		}
        if(e.getSource()==this.jMenuItem3[1]){
        	this.card.show(jp, "7");
		}
        if(e.getSource()==this.jMenuItem4[0]){
        	this.card.show(jp, "8");
		}
        if(e.getSource()==this.jMenuItem5[0]){
        	this.card.show(jp, "9");
		}
        if(e.getSource()==this.jMenuItem5[1]){
        	this.card.show(jp, "10");
		}
 
        
	}
	
	

}
