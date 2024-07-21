package com.luv2code.aopDemo.dao;

import com.luv2code.aopDemo.Account;

import java.util.List;

public interface AccountDAO {
    List<Account> findAccounts(boolean tripWire);
    void addAccount(Account account);
    void doWork();
    String getName();
    void setName(String name);
    String getServiceCode();
    void setServiceCode(String serviceCode);

}
