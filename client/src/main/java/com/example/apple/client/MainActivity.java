package com.example.apple.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    ServiceConnection serviceConnection;
    MyTest binder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        serviceConnection =new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                binder =(MyTest)MyTest.Stub.asInterface(service);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };

    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent=new Intent("com.example.apple.service.Myservice");
        bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE);
        try {
            binder.testSay();
            binder.sayhello();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
