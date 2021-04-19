package com.example.androidwahoo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.IBinder;

import com.example.androidwahoo.services.heartSensorService;
import com.wahoofitness.connector.HardwareConnector;


public class MainActivity extends AppCompatActivity implements ServiceConnection {

    private HardwareConnector mHardwareConnector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, heartSensorService.class);
        this.startService(intent);
        setContentView(R.layout.content_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = new Intent(this, heartSensorService.class);
        bindService(intent, this, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unbindService(this);
    }



    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {

    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}