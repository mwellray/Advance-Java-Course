/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objss;

/**
 *
 * @author Maxwell Ray
 */


//Object for date and price
public class obj  {
       private String date;
      private double close;
    
        
    public obj(String dte, double price){
     date = dte;
     close = price;
    }
    
    public String getdate(){
     return date;   
    }
    
    public double price(){
     return close;   
    } 
    
    
    
    
    
}