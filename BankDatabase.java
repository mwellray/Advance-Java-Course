/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmproj;
//
/**
 *
 * @author Maxwell 
 */
//authenticates a user, retrieves an account balance, credits a withdrawal, debits a deposit
public class BankDatabase {
    private Account Accounts[];
    //private Account current;
  
    public BankDatabase(){
     Accounts = new Account[2];
     Accounts[0] = new Account(123456789, 4321, 250.00, 500.25);  
     Accounts[1] = new Account(987654321, 1234, 560.43, 1000.50);
   
    } 
    
    
    private Account accounthole (int numb)
    {
         for(int k = 0; k < Accounts.length; ++k)
        {   
            if(Accounts[k].getAccnt() == numb)
            {
                return Accounts[k];
            } 
        }
         return null;      
        
    }
    
    private Account getaccount (int numb) {
         for(Account currentAccount: Accounts)
        {   
            if(currentAccount.getAccnt() == numb)
            {
                return currentAccount;
            } 
        }
         return null;
        
    }
    
    
     
    public boolean authenticateUser(int numb, int pn ) {
        
        if (accounthole(numb) != null)
        {
          if(accounthole(numb).validatePIN(pn) == pn)
          {
            return true;
          }  
        }      
      
        return false;
    } 
    
   public double getAvailableBalance(int numb){
        return getaccount(numb).getAvailableBalance();
   } 
    
   
     public double getTotalBalance(int numb){
        return getaccount(numb).getTotalBalance();
      
    }
     
       public void debit(int numb, double amt){
              getaccount(numb).debit(amt);
            }  
     
     public void credit(int numb, double amt){
        getaccount(numb).credit(amt);
        
     } 
     
    
    }
    
    


