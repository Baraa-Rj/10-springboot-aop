package com.luv2code.aopDemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MemberShipDaoImpl implements MemberShipDAO {
    public void addAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT");
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + ": I'm going to sleep now...");
    }

}
