package Test;
import java.awt.Container;  
import java.awt.Font;  
import java.awt.GridLayout;  
import java.awt.event.WindowAdapter;  
import java.awt.event.WindowEvent;  
import java.awt.event.ItemListener;  
import java.awt.event.ItemEvent;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import javax.swing.BorderFactory;  
import javax.swing.JComboBox;  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
class MyComboBox implements ActionListener, ItemListener{  
    private JFrame jframe = new JFrame("Welcome to my blog");  
    private Container container = jframe.getContentPane();  
    private JComboBox jcb1 = null;  
    private JLabel label = new JLabel("www.csnd.net");  
    private String fontSize[] = {"10", "12", "14", "16", "18", "20", "22", "24", "26", "48", "72"};  
    public MyComboBox(){  
        this.jframe.setLayout(new GridLayout(2, 1));  
        this.jcb1 = new JComboBox(this.fontSize);  
        jcb1.setBorder(BorderFactory.createTitledBorder("请选择显示文字大小"));  
        jcb1.addItemListener(this);  
        jcb1.addActionListener(this);  
        jcb1.setMaximumRowCount(3);;  
        jcb1.setEditable(true);  
        jcb1.configureEditor(jcb1.getEditor(), "12");  
        this.changeFontSize(12);  
          
        container.add(this.jcb1);  
        container.add(label);  
        this.jframe.setSize(300, 150);  
        this.jframe.setVisible(true);  
        this.jframe.addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e){  
                System.exit(1);  
            }  
        });  
    }  
      
    public void itemStateChanged(ItemEvent e){  
        if(e.getStateChange() == ItemEvent.SELECTED){  
            String itemSize = (String) e.getItem();  
            try{  
                System.out.println("---ItemEvent performed:" + e.paramString() + "---");  
                this.changeFontSize(Integer.parseInt(itemSize));  //改变字体  
            }catch(Exception ex){  
                  
            }  
        }  
    }  
      
    public void actionPerformed(ActionEvent e){  
        String itemSize = (String) this.jcb1.getSelectedItem();  
        int size = 12;  
        try{  
            size = Integer.parseInt(itemSize);  
        }catch(Exception ex){  
            this.jcb1.getEditor().setItem("输入的不是数字。");  
        }  
        System.out.println("---action performed " +e.getActionCommand() + "---");  
        this.changeFontSize(size);  
        if(!this.isExists(itemSize)){  
            this.jcb1.addItem(jcb1.getSelectedItem());  
        }  
    }  
    public boolean isExists(String item){  
        boolean flag = false;  
          
        for(int i = 0; i < this.jcb1.getItemCount(); i++){  
            if(item.equals(this.jcb1.getItemAt(i))){  
                flag = true;  
            }  
        }  
        return flag;  
    }  
      
    public void changeFontSize(int size){  
        Font fnt = new Font("Serief", Font.BOLD, size);  
        this.label.setFont(fnt);  
    }  
} 