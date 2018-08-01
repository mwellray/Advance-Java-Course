/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
/**
 *
 * @author Turtle
 */

public class JavaApplication9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        pan gui = new pan();
        
      
        
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(gui);
     frame.setSize(500, 500);
      frame.add(gui);
     frame.pack();
      frame.setVisible(true);
      
     
      
   
        
    }
    
   
    
}
