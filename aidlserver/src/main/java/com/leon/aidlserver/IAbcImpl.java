package com.leon.aidlserver;

import android.os.RemoteException;

public class IAbcImpl extends IAbcAidlInterface.Stub {

    private int age = 10;
    private String name = "defaultName";

    @Override
    public void setAge(int age) throws RemoteException {
        this.age = age;
    }

    @Override
    public void setName(String name) throws RemoteException {
        this.name = name;
    }

    @Override
    public String disPlay() throws RemoteException {
        return "name =" + name + "  age=" + age;
    }
}
