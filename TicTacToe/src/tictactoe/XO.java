package tictactoe;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XO implements ActionListener{
    Random rand = new Random();
    JFrame frame = new JFrame("Tic-Tac-Toc");
    JPanel buttons = new JPanel();
    JPanel title = new JPanel();
    JLabel text = new JLabel();
    JButton [] btns = new JButton[9];
    boolean p1_turn;
    
    
     public void firstTurn(){
        try {
            Thread.sleep(6000);
        } catch (InterruptedException ex) {
            Logger.getLogger(XO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(rand.nextInt(2)==0){
            p1_turn=true;
            text.setText("X turn");
        }
        else{
            p1_turn=false;
            text.setText("O turn");
        }
    }
     
     
     
    
    XO(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(255,105,180));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        
        text.setBackground(new Color(255,192,203));
        text.setForeground(new Color(255,20,147));
        text.setFont(new Font("Ink Free",Font.BOLD,75));
	text.setHorizontalAlignment(JLabel.CENTER);
        text.setText("Tic-Tac-Toe");
	text.setOpaque(true);
        
        title.setLayout(new BorderLayout());
        title.setBounds(0,0,800,100);
        
        buttons.setLayout(new GridLayout(3,3));
        buttons.setBackground(new Color(255,192,203));
        
        for(int i=0; i<9; i++){
            btns[i] = new JButton();
            btns[i].setFont(new Font("Ink Free",Font.BOLD,75));
            btns[i].setFocusable(false);
            btns[i].addActionListener(this);
            btns[i].setBackground(new Color(255,20,147));
            buttons.add(btns[i]);
        }
        
        frame.add(text,BorderLayout.NORTH);
        frame.add(title);
        frame.add(buttons);
                
        firstTurn();
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0; i<9; i++){
            if(e.getSource()==btns[i]){
                if(p1_turn){
                    if("".equals(btns[i].getText())){
                        btns[i].setForeground(new Color(255, 209, 220 ));
                        btns[i].setText("X");
                        p1_turn=false;
                        text.setText("O turn");
                        won();
                    }
                }
                else{
                    if("".equals(btns[i].getText())){
                        btns[i].setForeground(new Color(255, 209, 220 ));
                        btns[i].setText("O");
                        p1_turn=true;
                        text.setText("X turn");
                        won();
                    }
                }
            }
        }
        
    }
  
    
    
    
    
    public void won(){
        if((
                "X".equals(btns[0].getText())&&
                "X".equals(btns[2].getText())&&
                "X".equals(btns[1].getText()))){
            xWon(1,0,2);
        }
        if(
        ("X".equals(btns[0].getText())&&
                "X".equals(btns[3].getText())&&
                "X".equals(btns[6].getText()))){
            xWon(0,3,6);
        }
        if(
        ("X".equals(btns[0].getText())&&
                "X".equals(btns[4].getText())&&
                "X".equals(btns[8].getText()))){
            xWon(0,4,8);
        }
        if(
        ("X".equals(btns[1].getText())&&
                "X".equals(btns[4].getText())&&
                "X".equals(btns[7].getText()))){
            xWon(1,4,7);
        }
        if(
        ("X".equals(btns[2].getText())&&
                "X".equals(btns[5].getText())&&
                "X".equals(btns[8].getText()))){
            xWon(2,5,8);
        }
        if(
        ("X".equals(btns[2].getText())&&
                "X".equals(btns[4].getText())&&
                "X".equals(btns[6].getText()))){
            xWon(2,4,6);
        }
        if(
        ("X".equals(btns[4].getText())&&
                "X".equals(btns[3].getText())&&
                "X".equals(btns[5].getText()))){
            xWon(4,3,5);
        }
        if(
        ("X".equals(btns[7].getText())&&
                "X".equals(btns[8].getText())&&
                "X".equals(btns[6].getText()))){
            xWon(7,8,6);
        }
        
        
        if((
        "O".equals(btns[1].getText())&&
                "O".equals(btns[0].getText())&&
                "O".equals(btns[2].getText()))){
            oWon(1,0,2);
        }
        if(
        ("O".equals(btns[0].getText())&&
                "O".equals(btns[3].getText())&&
                "O".equals(btns[6].getText()))){
            oWon(0,3,6);
        }
        if(
        ("O".equals(btns[0].getText())&&
                "O".equals(btns[4].getText())&&
                "O".equals(btns[8].getText()))){
            oWon(0,4,8);
        }
        if(
        ("O".equals(btns[1].getText())&&
                "O".equals(btns[4].getText())&&
                "O".equals(btns[7].getText()))){
            oWon(1,4,7);
        }
        if(
        ("O".equals(btns[2].getText())&&
                "O".equals(btns[5].getText())&&
                "O".equals(btns[8].getText()))){
            oWon(2,5,8);
        }
        if(
        ("O".equals(btns[2].getText())&&
                "O".equals(btns[4].getText())&&
                "O".equals(btns[6].getText()))){
            oWon(2,4,6);
        }
        if(
        ("O".equals(btns[4].getText())&&
                "O".equals(btns[3].getText())&&
                "O".equals(btns[5].getText()))){
            oWon(4,3,5);
        }
        if(
        ("O".equals(btns[7].getText())&&
                "O".equals(btns[8].getText())&&
                "O".equals(btns[6].getText()))){
            oWon(7,8,6);
        }
        
    }
    public void xWon(int a, int b, int c){
        btns[a].setBackground(new Color(255, 209, 220));
        btns[b].setBackground(new Color(255, 209, 220));
        btns[c].setBackground(new Color(255, 209, 220));
        
        btns[a].setForeground(new Color(255,20,147));
        btns[b].setForeground(new Color(255,20,147));
        btns[c].setForeground(new Color(255,20,147));
        
        for(int i=0; i<9; i++){
            btns[i].setEnabled(false);
        }
        text.setText("X wins");
    }
    public void oWon(int a, int b, int c){
        btns[a].setBackground(new Color(255, 209, 220));
        btns[b].setBackground(new Color(255, 209, 220));
        btns[c].setBackground(new Color(255, 209, 220));
        
        btns[a].setForeground(new Color(255,20,147));
        btns[b].setForeground(new Color(255,20,147));
        btns[c].setForeground(new Color(255,20,147));
        
        for(int i=0; i<9; i++){
            btns[i].setEnabled(false);
        }
        text.setText("O wins");
    }
}
