/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmproj;
import java.util.Scanner;
import java.util.Locale;

/**
 *
 * @author Maxwell 
 */

//receives numeric input from the user

public class Keypad {

   
    public int inputcheck(){
        int accntnumb;
        Scanner reader = new Scanner(System.in);
       
     
     while(true){                                           //new java method for checking numeral input like it alot
        while(!reader.hasNextInt()){
            String put = reader.next();
            
           
        }
        accntnumb = reader.nextInt(); 
        
        int length = String.valueOf(accntnumb).length();
        if (length == 9)
        {
         
            return accntnumb;
           
            
        } else
        {
           
                        
        }
     
     } 
      
      }
    
    public int pincheck(){
        int pin;
        Scanner reader = new Scanner(System.in);
     
        
     while(true){                                           //new java method for checking numeral input like it alot
        while(!reader.hasNextInt()){
            String put = reader.next();
       
           
        }
       
        pin = reader.nextInt(); 
        
        int length = String.valueOf(pin).length();
        if (length == 4)
        {
         
            return pin;
            
        } else
        {
                            
        }
      
     }
        
    }
    
     public int menucheck(){
        int option;
        Scanner reader = new Scanner(System.in);
     
        
     while(true){                                           //new java method for checking numeral input like it alot
        while(!reader.hasNextInt()){
            String put = reader.next();
                 
        }
       
       option = reader.nextInt(); 
        
        int length = String.valueOf(option).length();
        if (length == 1 && option == 1 || option == 2 || option == 3 || option ==4)
        {
         
            return option;
            
        } else
        {
     
                        
        }
        
        }
     }

     public int cash(){
        int option;
        Scanner reader = new Scanner(System.in);
     
        
     while(true){                                           //new java method for checking numeral input like it alot
        while(!reader.hasNextInt()){
            String put = reader.next();
      
           
        }
       
       option = reader.nextInt(); 
        
        int length = String.valueOf(option).length();
        if (length == 1 && option == 1)
        {
         
           return option = 20;
            
        } else if (length == 1 && option == 2)
        {
            return  option = 40;          
        } else if (length == 1 && option == 3)
        {   
            return  option = 60; 
        } else if (length == 1 && option == 4)
        {
            return  option = 80; 
        } else if (length == 1 && option == 5)
        {
           return  option = 100;
        } else if (length == 1 && option == 6)
        {
         return 0;
        }
     }
     
     
     }
     
     
     
     
     
     
       public int depo(){
        int option;
        Scanner reader = new Scanner(System.in);
      
              
                                              //new java method for checking numeral input like it alot
        while(!reader.hasNextInt()){
            String put = reader.next();
      
        }
        
       option = reader.nextInt(); 
       
       if(option > 0)
       {
        return option;   
       } else if (option < 0)  
       {
           return 0;
       } else 
       { return 0;
       }
              

 }
       
}
     
     
     
     
     
     
     
     
     
     
     
     
     
     
    
     
     
     
     
     
     
     
     
     
     
    

