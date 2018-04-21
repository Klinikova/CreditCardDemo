/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PolinaYoga
 */
public class CreditCard {
    
    private Money balance;
    private Money creditLimit;
    private Person owner;
    
    public CreditCard(Person newCardHolder, Money limit)
    {
        balance = new Money(0);
        creditLimit = new Money(limit);
        owner = new Person (newCardHolder);
    }
    
    public Money getBalance()
    {
        Money copyBalance = new Money(this.balance);
        return copyBalance;
    }
    
    public Money getCreditLimit()
    {
        Money copyLimit = new Money(this.creditLimit);
        return copyLimit;
    }
    
    public String getPersonals()
    {
        String personals = this.owner.toString();
        return personals;
    }
    
    public void charge(Money amount)
    {
       Money copyBalance = getBalance(); // вызвали метод getBalance, чтобы получить копию оригинального баланса
       Money copyLimit = getCreditLimit(); 
       Money newBalance = copyBalance.add(amount); // новый баланс полученный из копии оригинального баланса
       //int difference = newBalance.compareTo(copyLimit);
       int difference = copyLimit.compareTo(newBalance);
       if(difference >= 0)
       {
           this.balance = newBalance;
           System.out.println("Charge: " + amount.toString());
       }
       else
       {
          System.out.println("Exceeds credit limit");
       }
    }
        
    public void payment(Money amount)
    {
        Money copyBalance = getBalance();
        Money newBalance = copyBalance.subtract(amount);
        this.balance = newBalance;
        System.out.println("Payment: " + amount.toString());
    }
    
   
    
}
