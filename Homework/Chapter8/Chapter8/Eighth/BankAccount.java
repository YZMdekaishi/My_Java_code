package Homework.Chapter8.Eighth;

import java.awt.*;

public class BankAccount {
    public static void main(String[] args) {
        SavingAccount savingAccount = new SavingAccount(5000);
        savingAccount.deposit(500);
        savingAccount.deposit(500);
        savingAccount.deposit(500);
        System.out.println(savingAccount.getBalance());
        savingAccount.withdraw(500);
        System.out.println(savingAccount.getBalance());
        savingAccount.earnMonthly();
        savingAccount.deposit(500);
        System.out.println(savingAccount.getBalance());
    }
    private double balance;
    public BankAccount(double initialBalance){
        this.balance = initialBalance;
    }
    //存款
    public void deposit(double amount){
        balance += amount;
    }
    //取款
    public void withdraw(double amount){
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
class CheckingAccount extends BankAccount{
    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }
    //取款：扣一块钱的手续费

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount + 1);
    }

    //存款：扣一块钱的手续费
    @Override
    public void deposit(double amount) {
        super.deposit(amount - 1);
    }
}
class SavingAccount extends  BankAccount{
    private double interest;
    private int count = 3;
    private double rate = 0.01;

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public SavingAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void deposit(double amount) {
        if(count > 0){
            super.deposit(amount);
        }else{
            super.deposit(amount - 1);
        }
        count--;
    }

    @Override
    public void withdraw(double amount) {
        if(count > 0){
            super.withdraw(amount);
        }else{
            super.withdraw(amount + 1);
        }
        count--;
    }
    public void earnMonthly(){
        count = 3;
        super.deposit(getBalance() * rate);

    }
}