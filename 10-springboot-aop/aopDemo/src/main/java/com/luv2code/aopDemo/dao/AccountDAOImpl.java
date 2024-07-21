package com.luv2code.aopDemo.dao;

import com.luv2code.aopDemo.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {
    private String name;
    private String serviceCode;

    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {
        if (tripWire) {
            throw new RuntimeException("No soup for you!");
        }
        Account account1 = new Account("John", "Silver");
        Account account2 = new Account("Madhu", "Platinum");
        Account account3 = new Account("Luca", "Gold");
        List<Account> accounts = List.of(account1, account2, account3);
        return accounts;
    }

    public void addAccount(Account account) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public void doWork() {
        System.out.println(getClass() + ": DOING MY WORK");
    }
}
