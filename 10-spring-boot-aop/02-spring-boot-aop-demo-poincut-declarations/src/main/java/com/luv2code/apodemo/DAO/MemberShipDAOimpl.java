package com.luv2code.apodemo.DAO;

import org.springframework.stereotype.Repository;

@Repository
public class MemberShipDAOimpl implements MemberShipDAO{

    @Override
    public boolean addSilly() {

        System.out.println(getClass()+" Adding the member");
    return  false;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass()+" see you");
    }
}
