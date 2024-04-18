package org.example.bankAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ConcurrentBank {
    private final List<BankAccount> accounts = new ArrayList<>();
    public BankAccount createAccount(){
        BankAccount account = new BankAccount(UUID.randomUUID());
        accounts.add(account);
        return account;
    }

    public void transfer(BankAccount sender, BankAccount recipient, Double amount){
        if (sender.getBalance() > amount){
            recipient.deposit(amount);
            sender.withdraw(amount);
        }else {
            System.out.print("Insufficient funds.");
        }
    }

    public Double getTotalBalance(){
        Double total = 0D;
        for (BankAccount account:accounts) {
            total += account.getBalance();
        }
        return total;
    }
}
