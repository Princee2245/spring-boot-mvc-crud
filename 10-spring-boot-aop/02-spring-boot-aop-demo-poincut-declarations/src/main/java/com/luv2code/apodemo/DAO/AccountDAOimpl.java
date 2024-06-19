package com.luv2code.apodemo.DAO;

import com.luv2code.apodemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOimpl implements AccountDAO{

    private String name;
    private String serviceCode;

    @Override
    public void addAccount(Account theAccount,boolean vipFlag) {
        System.out.println(getClass()+" Adding the account");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass()+": doWork()");
        return false;
    }

    public String getName() {
        System.out.println(getClass()+": getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+": setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+": getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+": setServiceCode()");
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts() {
       return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        if(tripWire){
            throw new RuntimeException("no soup for you!!");
        }

        List<Account> myAccounts=new ArrayList<>();

        Account account1=new Account("Shivam","silver");
        Account account2=new Account("Ritik","platinum");
        Account account3=new Account("prince","gold");

        myAccounts.add(account1);
        myAccounts.add(account2);
        myAccounts.add(account3);

        return myAccounts;
    }
}
