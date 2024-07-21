package com.luv2code.aopDemo;

import com.luv2code.aopDemo.dao.AccountDAO;
import com.luv2code.aopDemo.dao.MemberShipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MemberShipDAO memberShipDAO) {
        return runner -> {
            // demoTheBeforeAdvice(accountDAO, memberShipDAO);
           // demoAfterReturningAdvice(accountDAO, memberShipDAO);
            demoAfterThrowingAdvice(accountDAO, memberShipDAO);
        };
    }

    private void demoAfterThrowingAdvice(AccountDAO accountDAO, MemberShipDAO memberShipDAO) {
        List<Account> accounts= null;

        System.out.println("Main Program: AfterThrowingDemoApp");
        System.out.println("----");
        try {
            boolean tripWire = true;
            accounts = accountDAO.findAccounts(tripWire);
        } catch (Exception e) {
            System.out.println("Main Program ... caught exception: " + e);
        }

    }

    private void demoAfterReturningAdvice(AccountDAO accountDAO, MemberShipDAO memberShipDAO) {
        System.out.println("Performing after returning advice");
       // System.out.println("AccountDAO: " + accountDAO.findAccounts(tripWire));

    }

    private void demoTheBeforeAdvice(AccountDAO accountDAO, MemberShipDAO memberShipDAO) {
        memberShipDAO.addAccount();
        accountDAO.addAccount(new Account());
        accountDAO.setName("foobar");
        accountDAO.setServiceCode("silver");
        String name = accountDAO.getName();
        String serviceCode = accountDAO.getServiceCode();

        accountDAO.doWork();
        memberShipDAO.goToSleep();
    }
}
