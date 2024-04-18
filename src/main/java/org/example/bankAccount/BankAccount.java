package org.example.bankAccount;

import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private final UUID uuid;
    private Double balance;

    private Lock lock;

    public BankAccount(UUID uuid) {
        this.uuid = uuid;
        this.balance = 0D;
        this.lock = new ReentrantLock();
    }

    public BankAccount(Double balance){
        this.uuid = UUID.randomUUID();
        this.balance = balance;
        this.lock = new ReentrantLock();
    }

    public void deposit(Double amount){
        lock.lock();
        try {
        this.balance += amount;
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(Double amount){
        lock.lock();
        try {
            if (balance >= amount){
                balance -= amount;
            }else {
                System.out.println("Insufficient funds.");
            }
        } finally {
            lock.unlock();
        }
    }

    public Double getBalance(){
        return balance;
    }
}
