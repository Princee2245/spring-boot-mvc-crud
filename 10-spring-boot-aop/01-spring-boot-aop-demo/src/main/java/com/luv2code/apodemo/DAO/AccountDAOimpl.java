package com.luv2code.apodemo.DAO;

import com.luv2code.apodemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOimpl implements AccountDAO{

    @Override
    public void addAccount(Account theAccount,boolean vipFlag) {
        System.out.println(getClass()+" Adding the account");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass()+": doWork()");
        return false;
    }
}
