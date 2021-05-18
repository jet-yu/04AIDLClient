package com.leon.aidlserver;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = new Intent();
        // 设置Intent的Action 属性
        intent.setAction("com.leon.aidlserver.MyRemoteService");

        //等价1
//     Intent finalIntent = IntentUtils.createExplicitFromImplicitIntent(this, intent);

        //等价2
        Intent finalIntent = new Intent(intent);
        finalIntent.setComponent(new ComponentName("com.leon.aidlserver", "com.leon.aidlserver.MyRemoteService"));

        
        startService(finalIntent);
    }
}