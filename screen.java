/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmproj;

/**
 *
 * @author Maxwell 
 */
//displays a message to the user
public class screen {
    
    public void displayMessage(String input){
        System.out.println(input);
       
    }


    
   public void amount ( double input){
       System.out.printf("$"+"%.2f", input);
   }
   
   
   /*public String cntdisplay (long dash){       //add dashes in the account 
           return Long.toString(dash).substring(0 , 3) + "-" + Long.toString(dash).substring(3 , 6) + "-" + Long.toString(dash).substring(6 , 9);
           
       } */
 public String cntdisplay(int dash){
  return Integer.toString(dash).substring(0 , 3) + "-" + Integer.toString(dash).substring(3 , 6) + "-" + Integer.toString(dash).substring(6 , 9);
 }
   
   
   
}
