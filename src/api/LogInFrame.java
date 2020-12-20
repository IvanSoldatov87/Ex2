package api;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInFrame extends JFrame implements ActionListener {
        JPanel jp=new JPanel();
        JTextField ID = new JTextField(20);
        JTextField Level = new JTextField(2);
        JButton enter=new JButton("Enter");
        int id=-1;
        int lvl=-1;
    JFrame lf;
    public LogInFrame() {
            //super(a);
            jp.add(ID);
            jp.add(Level);
            jp.add(enter);
            jp.setSize(20,50);
            ID.setToolTipText("ID");
            Level.setToolTipText("Level");
            ID.setVisible(true);
            Level.setVisible(true);
            Level.show();
            enter.setVisible(true);
            enter.show();
            jp.setVisible(true);
            add(jp);
            enter.addActionListener(this);
        }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==enter){
            lf=this;
            id= Integer.parseInt(ID.getText());
            lvl=Integer.parseInt(Level.getText());
            lf.dispose();

        }
    }
    public int getLvl(){
        return lvl;
    }
    public int getId(){
        return id;
    }
}
