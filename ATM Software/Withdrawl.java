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
public class Withdrawl extends Transaction {
 
    private int amount;

    private Keypad keypad;
    private CashDispenser cashdispense;
    
    /*Constructor is not inherited, thus have to include constructor lines. 
    Each subclass constructor must implicity or explicitly call its superclass
    constructor to ensure - instance variables inherited are initiated properly.
    Have to use get methods to retrieve the values of the superclass's instance variables*/
    public Withdrawl(int accountnumb, screen scrn, BankDatabase bankdata, Keypad key, CashDispenser shoot){
     
        super(accountnumb, scrn, bankdata); //inherits accountnumber, screen, and bank data from Super Class Transaction
       
        keypad = key;             //associations in figure diagram
        cashdispense = shoot;       //associations in figure diagram
    }
    
      /*Takes Transaction's get methods and formats them to transaction using super. Overides 
    abstract exe() method by using concrete implementation. Concrete class instantiate objects; 
    provide specifics.*/   
    public void exe(){
     test(denom());  
    }
    
     private void test(int numb){
         BankDatabase bankdatabase = getBK();
       screen Screen = getScreen();
        
        if (numb == 0)
        {
        }
        else if(numb < bankdatabase.getAvailableBalance(getAcnt() ))
        {
            if(cashdispense.isCashAvailable(numb) == true)
            {
            
                
             Screen.displayMessage("--------------------------");   
             Screen.displayMessage("Old Balance \n\nAvailable: ");
             Screen.amount(bankdatabase.getAvailableBalance(getAcnt()));
             Screen.displayMessage("\nTotal Balance: ");
             Screen.amount(bankdatabase.getTotalBalance(getAcnt()));
             
             bankdatabase.credit(getAcnt(), numb);
             Screen.displayMessage("\n--------------------------");   
             Screen.displayMessage("\nDispensed " + cashdispense.dispenseCash(numb) + " bills\n");
             Screen.displayMessage("--------------------------");   
             
              Screen.displayMessage("\nNew Balance \n\nAvailable: ");
             Screen.amount(bankdatabase.getAvailableBalance(getAcnt()));
             Screen.displayMessage("\nTotal Balance: ");
             Screen.amount(bankdatabase.getTotalBalance(getAcnt()));
            
             
            } else
            {
             Screen.displayMessage("\nATM currently cannot dispense requested amount");
            }
                
        } else
        {
            Screen.displayMessage("\nYou don't have that much");
            Screen.displayMessage("\n Account Balance \n\n Available: ");
            Screen.amount(bankdatabase.getAvailableBalance(getAcnt()));
             Screen.displayMessage("\nTotal Balance: ");
             Screen.amount(bankdatabase.getTotalBalance(getAcnt()));
        }  
         
     }
     
     
     
    
    private int denom(){
          screen Screen = getScreen();
        Screen.displayMessage("WithDrawal");  
        Screen.displayMessage("---------"); 
        Screen.displayMessage("1: $20"); 
        Screen.displayMessage("2: $40"); 
        Screen.displayMessage("3: $60"); 
        Screen.displayMessage("4: $80"); 
        Screen.displayMessage("5: $100");
        Screen.displayMessage("6) Exit"); 
        Screen.displayMessage("Enter Menu Number"); 
        return keypad.cash();
    }
    
    
    
}
