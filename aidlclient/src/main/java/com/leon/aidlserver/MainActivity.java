package com.leon.aidlserver;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private IAbcAidlInterface iAbc;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            Log.d("MainActivity", "onServiceConnected()---------->");
            // 获得IPerson接口
            iAbc = IAbcAidlInterface.Stub.asInterface(service);
            Log.d("MainActivity", "iperson----------:" + iAbc);


        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            iAbc = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = new Intent();
        intent.setPackage("com.leon.aidlserver");
        intent.setAction("com.leon.aidlserver.MyRemoteService");
        bindService(intent, connection, Service.BIND_AUTO_CREATE);

        findViewById(R.id.abc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    iAbc.setAge(20);
                    iAbc.setName("abc");
                    String msg = iAbc.disPlay();
                    Log.d("MainActivity", "msg----------:" + msg);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    protected void onDestroy() {
        if (connection != null) {
            unbindService(connection);
        }
        super.onDestroy();
    }

}