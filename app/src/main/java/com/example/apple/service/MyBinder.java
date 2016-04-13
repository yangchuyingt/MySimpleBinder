package com.example.apple.service;

import android.os.Binder;
import android.os.Parcel;
import android.os.RemoteException;

/**
 * Created by apple on 16/4/13.
 */
public class MyBinder extends Binder {
    Test test;
    @Override
    protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        if(test==null){
            test=new Test();
        }
        test.testSay();

        return super.onTransact(code, data, reply, flags);
    }


}
