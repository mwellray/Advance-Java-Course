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
/*Java compiler sets the superclass of a class to Object when the class declaration does not 
explicity extend a superclass*/
public class Deposit extends Transaction{
    private int accountnumb;
    private double amount;
    private DepositSlot depositslot;
    private Keypad keyp;
    
//Specialization of class Transaction    
    
  /*Constructor is not inherited, thus have to include constructor lines. 
    Each subclass constructor must implicity or explicitly call its superclass
    constructor to ensure - instance variables inherited are initiated properly.
    Have to use get methods to retrieve the values of the superclass's instance variables*/  
public Deposit(int accountnumb, screen scrn, BankDatabase bankdata, Keypad key, DepositSlot slot){
 
super(accountnumb, scrn, bankdata);     //inherits accountnumber, screen, and bank data from Super Class Transaction

keyp = key;                //associations in figure diagram
depositslot = slot;             //associations in figure diagram

}
 /*Takes Transaction's get methods and formats them to transaction using super. Overides 
    abstract exe() method by using concrete implementation.*/
public void exe(){
test(amountdeposit());
    
}


private void test(int numb){
        BankDatabase bankdatabase = getBK();
       screen Screen = getScreen();
       DepositSlot dp = new DepositSlot();
        boolean received = dp.isEnvelopeReceived();
      
        if (numb == 0)
        {
        }
        else if(received)
        {
            Screen.displayMessage("--------------------------");     
            Screen.displayMessage("\nEnvelope Received");
             
             Screen.displayMessage("\nOld Balance \n \nAvailable: ");
             Screen.amount(bankdatabase.getAvailableBalance(getAcnt()));
             Screen.displayMessage("\nTotal Balance: ");
             Screen.amount(bankdatabase.getTotalBalance(getAcnt()));
              
              
              bankdatabase.debit(getAcnt(), numb);
              Screen.displayMessage("\n--------------------------");   
              Screen.displayMessage("\n\nDeposited : ");
              Screen.amount(numb);
              Screen.displayMessage("\n--------------------------");   
              Screen.displayMessage("\n\nNew Balance \n\nAvailable: ");
             Screen.amount(bankdatabase.getAvailableBalance(getAcnt()));
             Screen.displayMessage("\nTotal Balance: ");
             Screen.amount(bankdatabase.getTotalBalance(getAcnt()));
        }      
         else
        {
            Screen.displayMessage("\nYou have not entered the envelope");
        }  
         
     }
    
 
private int amountdeposit(){
     screen Screen = getScreen();
     Keypad keypad = new Keypad();
        Screen.displayMessage("Enter Amount to Deposit - Bills only - 0 to exit");  
        return keypad.depo();
    
}



}