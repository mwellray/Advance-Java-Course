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

//dispenses cash, indicates whether it contains enough cash to satisfy a withdrawl request
public class CashDispenser {
    private static int count;
    private Withdrawl withdrawl;


public CashDispenser(){
     count = 500;   
     
 }



    public boolean isCashAvailable(int amount){
         if (amount <= count)
          {   
        return true;
           } else
            {
            return false;
            }
}

    public int dispenseCash(int amount){
      int count = 0;
        while (amount > 0 )
        { 
          amount -= 20;
          count++;
        }   
        return count;

    } 




    
}