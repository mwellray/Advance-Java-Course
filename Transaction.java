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
/*Class Transaction is a generalization of classes BalanceInq, Withdrawal, and Deposit.
A abstract class delcareds commmon attributes and behaviors of its subclasses in an inheritance hierarchy
Transaction Class defines the concept of what it means to be a transaction that has a account number
*/

/*The super class
abstract class - other classes can inherit and share a common design from 
a super class.*/
public abstract class Transaction { //why abstract
    private int accountNumb;
    private screen Screen;
    private BankDatabase bankdatabase;
    //If variables are protected are inherited by all subclasses, but nonsubclasses cannot access.
    
    /*Constructor takes current users account #, refrences to screen, and bank database as arguments. Since Transaction is a abstract class
    constructor will never be called directly to initiate Transaction Objects; constructors of Transaction subclasses will use super to invoke
    this constructor
    
    Inheritance new class is created by absorbing an existing class's members and embellishing them with new 
    or modified capabilities. Rather than declaring completely new members you can designate that the new class should 
    inherit the members of an existing class. Existing class is SuperCLass, new class is sub class. Each subclass
    can become superclass for future subclasses. If changes are required for common features only the super class needs to be edited.*/
    public Transaction(int accountnumb, screen scrn, BankDatabase bankdata){
        accountNumb = accountnumb;            
        Screen = scrn;
        bankdatabase = bankdata;
    }
    
    /*Transaction subclasses inherit these three get methods to obtain private attributes*/
    public screen getScreen(){
        return Screen;
    }
    
    public BankDatabase getBK(){
        return bankdatabase;
    }
    
    
    public int getAcnt(){
        return accountNumb;
    }
    
    
    /* Balance Inq, Withdraw, Deposit all share exe(). Do not implement exe in Transaction
    because exe() depends on the type of transaction, therefore is declared an abstract. 
    Any class that contains at least one abstract method must also be declared abstract. Any
    subclasses are forced to be concrete classes to implement method exe().
    
    Each subclass exe() overrides Transaction's exe() method with a unique concrete implementation that 
    performs steps for the required transaction. We must include a exe() in this superclass so that
    ATMmain can polymorphically invoke each subclass's overriden version of this method through a 
    Transaction reference. Making it abstract forces the implementor of the subclasses to override with concrete
    implementations or else the subclasses will be abstract as well preventing objects of those subclasses
    from being used. 
    */
    
    abstract public void exe();// EACH CLASS BE NAMED THIS
}

/*Should we wish to create an additional Transaction, we would simply
create another Transaction subclass that overides the exe() method with the 
appropriate concrete implementation to execute the new Transaction.
Polymorphic relationships make it easy to add new classes that are part
of the inheritance hierarchy. 
*/