/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objss;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Label;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Maxwell Ray
 */
public class Objss {

private fill f1;
static double numb;
static double price;
static String date;
static boolean buy;


public Objss(){
    f1 = new fill();
  
}
        /**
     * @param args the command line arguments
     */
    //JavaFX content into a Swing application
    //threading - multiple activites to coexist within a single process
    //Every program has one thread - main

    
     private static void initAndShowGUI() throws IOException {
        // Creates JFrame, adds JFXPanel object to it
        //JFrame displays grpahical window to user, ouse components and graphics on
        JFrame frame = new JFrame("Swing and JavaFX");
         //Creating an instance of the JFXPanel class implicitly starts the JavaFX runtime
         //JavaFX set of java graphics libraries for creating Java GUI apps.
         //Browsers have stopped supporitng plugs ins for applets
        final JFXPanel fxPanel = new JFXPanel();
       
      
      Label lbel = new Label("Google 50 day avg: "+ "$" + String.format("%.2f", numb));
      Label lbel1 = new Label("Stock Price: " + date + " $" + String.format("% .2f", price));
      Label lbel2 = new Label("Buy - Price below 50 Day Average");
      Label lbel3 = new Label("Sell - Price above 50 Day Average");
      
    
     lbel.setFont(new Font("Serif",Font.PLAIN,20));
      lbel1.setFont(new Font("Serif",Font.PLAIN,20));
       lbel2.setFont(new Font("Serif",Font.PLAIN,20));
        lbel3.setFont(new Font("Serif",Font.PLAIN,20));
         System.out.println(buy);
        
     if(buy == true){
      frame.add(lbel2, BorderLayout.NORTH);   
     } else if (buy == false){
         frame.add(lbel3, BorderLayout.NORTH);
         
     }
        
      frame.add(lbel, BorderLayout.WEST);
      frame.add(lbel1, BorderLayout.EAST);
      frame.add(fxPanel, BorderLayout.SOUTH);
      
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

                 Scene s = createScene();
                 fxPanel.setScene(s);
                
    }

   
        //Scene class is container for all content in a scene graph.
        //Scene Graph API makes graphical interaces easier to create. Tree data structure, retained mode API
     //maintains an internal model of all grpahical objects in your application. API classes act as root, branch or 
     //leaf nodes. Individual items are known as nodes. Branch node (have chldren) Leaf node (no children)
     //Group ojbect acts as the root node. 
   private static Scene createScene() throws IOException {
      //Group group node contains ObservableLIst of children that are rendered in order wheneer
      //this node is rendered. Any transform, effect, state applied to a Group will be applied to all children of that group
      //autoSizeChildren - resizing behaviour
       
       final CategoryAxis x = new CategoryAxis();
       final NumberAxis y = new NumberAxis();
        final LineChart<String,Number> line = new LineChart<>(x,y);
        //exclude zero
        y.setForceZeroInRange(false);
           y.setAutoRanging(true);
         XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
       
      series.setName("prices");
      
      fill fl = new fill();
      fl.check("google.txt");
      
   
    int count = fl.objects.length - 1;
      while (count > 1 ){
       series.getData().add(new XYChart.Data<String,Number>(fl.objects[count].getdate(),fl.objects[count].price()));
          
       --count;
      } 
      
      line.getData().add(series);
      //if group is used as a root, needed for specifying, contents of scene graph will be clipped 
      //by scenes width and height. Layout Region/Control is set as root, then root's size will track
      //the scene's size.
      Scene sc = new Scene(line,500,400);
       
       return sc;
    }
    
   
   
    
    public static void main(String[] args) throws IOException {
         
          fill test1 = new fill();
          test1.check("google.txt");
         numb = test1.fifty();
         price = test1.objects[0].price();
         date = test1.objects[0].getdate();
    
          initAndShowGUI();
   
        
        
    }
    }
    


