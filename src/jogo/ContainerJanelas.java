/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import java.awt.PopupMenu;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Gabriel
 */
public class ContainerJanelas extends JFrame{ 
    
    
    public ContainerJanelas(){
        add(new Fase());
        setTitle("Meu primeiro jogo");
        setSize(500,400);
        setResizable(false);
        setLocationRelativeTo(null);    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }  

        public static void main(String[] args){
        new ContainerJanelas();
    }
    
    
}
