package com.example.apple.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * Created by apple on 16/4/13.
 */
public class Myservice extends Service {
     MyTest.Stub Mybinder;
    Test test;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        if(Mybinder==null){
            Mybinder=new MyTest.Stub(){

                @Override
                public String testSay() throws RemoteException {
                    if (test==null){
                        test=new Test();
                    }
                    return test.testSay();
                }

                @Override
                public void sayhello() throws RemoteException {
                    if (test==null){
                        test=new Test();
                    }
                    test.sayhello();

                }
            };
        }
        return Mybinder;
    }

}
