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
public class ATMmain {
   //Instance Variables, private is a access modifier accessible only to methods of class
    //Primitive store one value of declared type
    private BankDatabase bankdatabase;
    private Keypad keypad;
    private screen Screen;
   // private Withdrawl withdrawl;
    private CashDispenser cashdispense;
    private DepositSlot depositslot;
    
    private boolean userAuth;
    private int accNumb;
    private int accPin;
    private int menu;
    private char mn; 
    
   
    /*Java requires a constructor call for every object that is created.
    default constuctor of 0, false, or null is giving until changed. 
    Constructors take arguments to initizate the objects data*/
    public ATMmain(){
        userAuth = false;
        accNumb = 0;
        accPin = 0;
        menu = 0;
     
       bankdatabase = new BankDatabase();
       keypad = new Keypad();
       Screen = new screen();
       cashdispense = new CashDispenser();
     
    }
    /*3 ways to delcare and use method:
    1) method name to call another method of same class
    2) reference to an object(dot) method name to call
    3) class name (dot) static method of a class*/
    
    public void start(){
      
 while (true){    
     Screen.displayMessage("------------ Test Account: 123456789  Pin: 4321");
     Screen.displayMessage("****ATM****");
     Screen.displayMessage("Enter Account Number: ");
      accNumb = keypad.inputcheck();
       Screen.displayMessage("Enter Pin Number: ");
      accPin = keypad.pincheck();
      
      userAuth = bankdatabase.authenticateUser(accNumb, accPin);
                  
        if (userAuth == true)
        {
           
        } else 
        {    
            Screen.displayMessage("Invalid Account/PIN #");   
        }
        
        
         mn = 'a';
        
        while (mn != 'b') {    
         
        transaction(menu());
 
    }
 }   
    }
    
      private int menu(){
        Screen.displayMessage("");
        Screen.displayMessage("------------");
        Screen.displayMessage("ATM MENU");  
        Screen.displayMessage("---------"); 
        Screen.displayMessage("1: View Balance"); 
        Screen.displayMessage("2: Withdraw Money"); 
        Screen.displayMessage("3: Deposit Money"); 
        Screen.displayMessage("4: Exit"); 
        Screen.displayMessage("Enter Menu Number"); 
        return keypad.menucheck();
    } 

  private Transaction transaction(int k)
    {
        /*Inheritance provides ATM with ability to execute all transactions required. ATMmain sets 
        a Transaction reference to a new object of either BalanceInq, WIthdraw, or Deposit. The exe() is
        called when the reference is used. ATMmain at any given moment is either executing a transaction or isnt
        (zero or one of the objects of Transaction exist in the system at a time). */  
        
        //Initialize multiple object by one type 
        Transaction multipleobjs;
        
        if (k == 1)   //balance inq
        {
         
         multipleobjs = new BalanceInq(accNumb, Screen, bankdatabase);
  
           multipleobjs.exe();
        
        } else if (k == 2)     //withdrawl
        {
             multipleobjs = new Withdrawl(accNumb, Screen, bankdatabase, keypad, cashdispense);
             multipleobjs.exe();
           
        } else if (k == 3)      //deposit
        {
           multipleobjs = new Deposit(accNumb, Screen, bankdatabase, keypad, depositslot);  
        
          multipleobjs.exe();
       
        }        
         else if (k == 4 || k ==6)     //break
        {
            mn = 'b'; //break loop
            Screen.displayMessage("*Have a Nice Day Thank You*");
           
        } 
         return null;
    }       
} 
    

   


