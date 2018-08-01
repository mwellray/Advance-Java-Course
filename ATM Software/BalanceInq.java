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
//Specialization of class Transaction

/*Java compiler sets the superclass of a class to Object when the class declaration does not 
explicity extend a superclass*/
public class BalanceInq extends Transaction {
     /*Constructor is not inherited, thus have to include constructor lines. 
    Each subclass constructor must implicity or explicitly call its superclass
    constructor to ensure - instance variables inherited are initiated properly.
    Have to use get methods to retrieve the values of the superclass's instance variables*/ 
    public BalanceInq(int accountnumb, screen scrn, BankDatabase bankdata){
       super(accountnumb, scrn, bankdata); //inherits accountnumber, screen, and bank data from Super Class Transaction
    }

    
        
   /*Takes Transaction's get methods and formats them to transaction using super. Overides 
    abstract exe() method by using concrete implementation.*/
    
    public void exe()
    {        
        
      BankDatabase bankdata = getBK();
      screen scrn = getScreen();
      
      double available = bankdata.getAvailableBalance(getAcnt());
      double total = bankdata.getTotalBalance(getAcnt());
              
      scrn.displayMessage(" \n- Information for your Account - ");
         scrn.displayMessage("Account Number: " + scrn.cntdisplay(getAcnt()));
      scrn.displayMessage("Available Balance: "); 
      scrn.amount(available);
      scrn.displayMessage("");
      scrn.displayMessage("Total Balance: ");
      scrn.amount(total);
     scrn.displayMessage("");
     
     
   
    
      
      
    }
     
    

       
    

}


