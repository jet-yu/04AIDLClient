package com.leon.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MyRemoteService extends Service {
    private IAbcImpl iAbc;

    public MyRemoteService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (iAbc == null) {
            iAbc = new IAbcImpl();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return iAbc;
    }
}