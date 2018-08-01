/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmproj;

import java.util.Locale;

/**
 *
 * @author Maxwell 
 */
//retrieves an account balance, credits a deposit amount to an account, debis a withdrawal amount from an account
public class Account  {
      private int accountNumber;
       private int pin;
      private double availB;
       private double total;
      
              
       public Account (int numb, int nu, double t, double to){
           accountNumber = numb;
           pin = nu;
           total = to;
           availB = t;
         
       }
      
         
       public double getAvailableBalance(){
           return availB;
           }
       
       public double getTotalBalance(){
        return total;   
       }
       

       public int validatePIN(int nmb){
           return pin;
       }
       
       public long getAccnt(){
        return accountNumber;
       }
    
        
       public void credit(double amount){  //asset account minus
            availB -= amount;
            total -= amount;
        }
        
        public void debit(double amount){   //asset account add
         total += amount;
        } 
    

}
