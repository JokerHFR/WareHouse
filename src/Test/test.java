package Test;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class test extends JFrame implements ActionListener{
 
 private static final long serialVersionUID = 1L;
 private Panel panel_1,panel_2,panel_3,panel_4,panel_5;
 private Button btn_r,btn_g,btn_b;
 private CardLayout c =new CardLayout();
 public test()
 {
  super("CardLayout");
  this.setBounds(150,150,300,300);
  this.setLayout(new BorderLayout());
  this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  
  panel_1 =new Panel();
  panel_1.setLayout(c);
        this.add(panel_1,"Center");  //panel_1在主框架中
       
  panel_2 =new Panel();
  panel_2.setLayout(new FlowLayout());
  btn_r = new Button("red");
  btn_r.addActionListener(this);
  
  btn_g = new Button("green");
  btn_g.addActionListener(this);
  
  btn_b = new Button("blue");
  btn_b.addActionListener(this);
  panel_2.add(btn_r);
  panel_2.add(btn_g);
  panel_2.add(btn_b);
  this.add(panel_2,"North");  //panel_2在主框架中
  
  panel_3 = new Panel();
  panel_3.setBackground(new Color(255,0,0));
  panel_1.add("red",panel_3);
  
  panel_4 =new Panel();
  panel_4.setBackground(new Color(0,255,0));
  panel_1.add("green",panel_4);
  
  panel_5 = new Panel();
  panel_5.setBackground(new Color(0,0,255));
  panel_1.add("blue",panel_5);
  
  this.setVisible(true);
  
 }
 public void actionPerformed(ActionEvent e)
 {
  if(e.getSource()==btn_r)
  {
   c.show(panel_1, "red");
  }
  if(e.getSource()==btn_g){
   c.show(panel_1,"green");
  }
  if(e.getSource()==btn_b){
	   c.show(panel_1,"blue");
	  }
 }
 
 public static void main(String[] args)
 {
  new test();
 }
}