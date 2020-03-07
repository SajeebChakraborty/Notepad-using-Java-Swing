import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;


class SajeebNotepad extends JFrame implements ActionListener{
    private JFileChooser fcs;
    private JTextArea tarea;
    private JButton b1,b2,b3;
    private Container ct;
   
    
    SajeebNotepad(){
        ct= this.getContentPane();
        ct.setLayout(null);
        ct.setBackground(Color.YELLOW);
        
        
        tarea = new JTextArea();
        tarea.setBounds(0,20,550,500);
        ct.add(tarea);
        b3 = new JButton("view");
		b3.setBounds(560,120,90,40);
		ct.add(b3);
        b1 = new JButton("Open");
        b1.setBounds(560,20,90,40);
        ct.add(b1);
        
        b2 = new JButton("Exit");
        b2.setBounds(560,70,90,40);
        ct.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
		b3.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            try {
                fcs = new JFileChooser();
                fcs.showOpenDialog(null);
                File f1 = fcs.getSelectedFile();
                Scanner input = new Scanner(f1);
                while (input.hasNext()) {
					
					
					
                    String str = input.nextLine();
                    tarea.append("    "+str +"\r\n");

                }
                input.close();
            } 
            catch (FileNotFoundException ex) {

            }
        }
        else if(e.getSource() == b2){
            System.exit(0);
        }
		else if(e.getSource() == b3){
			System.exit(0);
		}
    }
    
    public static void main(String[] args) {
        
        SajeebNotepad frm = new SajeebNotepad();
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setBounds(300,100,680,560);
        frm.setTitle("SajeebNotepad");
    }
}