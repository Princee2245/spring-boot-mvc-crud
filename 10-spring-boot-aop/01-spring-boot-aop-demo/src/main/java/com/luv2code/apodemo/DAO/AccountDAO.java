package com.luv2code.apodemo.DAO;

import com.luv2code.apodemo.Account;

public interface AccountDAO {
    void addAccount(Account theAccount,boolean vipFlag);

    boolean doWork();
}
