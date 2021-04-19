package com.example.androidwahoo.services;

import android.app.Service;
import android.content.Intent;
import android.net.nsd.NsdManager;
import android.os.IBinder;

import androidx.annotation.NonNull;

import com.wahoofitness.connector.HardwareConnector;
import com.wahoofitness.connector.HardwareConnector.Listener;
import com.wahoofitness.connector.HardwareConnectorEnums;
import com.wahoofitness.connector.HardwareConnectorTypes;
import com.wahoofitness.connector.capabilities.Capability;
import com.wahoofitness.connector.capabilities.Heartrate;
import com.wahoofitness.connector.conn.connections.SensorConnection;
import com.wahoofitness.connector.conn.connections.params.ConnectionParams;
import com.wahoofitness.connector.listeners.discovery.DiscoveryListener;

public class heartSensorService extends Service implements DiscoveryListener, SensorConnection.Listener ,Heartrate.Listener {
    private HardwareConnector mHardwareConnector;
    private final HardwareConnector.Listener mHardwareConnectorListener = new HardwareConnector.Listener() {
        @Override
        public void onHardwareConnectorStateChanged(@NonNull HardwareConnectorTypes.NetworkType networkType, @NonNull HardwareConnectorEnums.HardwareConnectorState hardwareConnectorState) {

        }

        @Override
        public void onFirmwareUpdateRequired(@NonNull SensorConnection sensorConnection, @NonNull String s, @NonNull String s1) {

        }


    };

    public heartSensorService() {

    }

    @Override
    public void onCreate(){
        super.onCreate();
        initWahooHardwareConnector();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.

        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mHardwareConnector.shutdown();
    }

    private void initWahooHardwareConnector ()
    {
        com.wahoofitness.common.log.Logger.setLogLevel(android.util.Log.VERBOSE );
        mHardwareConnector = new HardwareConnector( this, mHardwareConnectorListener );
    }


    @Override
    public void onHeartrateData(@NonNull Heartrate.Data data) {

    }

    @Override
    public void onHeartrateDataReset() {

    }

    @Override
    public void onNewCapabilityDetected(@NonNull SensorConnection sensorConnection, @NonNull Capability.CapabilityType capabilityType) {

    }

    @Override
    public void onSensorConnectionStateChanged(@NonNull SensorConnection sensorConnection, @NonNull HardwareConnectorEnums.SensorConnectionState sensorConnectionState) {

    }

    @Override
    public void onSensorConnectionError(@NonNull SensorConnection sensorConnection, @NonNull HardwareConnectorEnums.SensorConnectionError sensorConnectionError) {

    }

    @Override
    public void onDeviceDiscovered(@NonNull ConnectionParams connectionParams) {

    }

    @Override
    public void onDiscoveredDeviceLost(@NonNull ConnectionParams connectionParams) {

    }

    @Override
    public void onDiscoveredDeviceRssiChanged(@NonNull ConnectionParams connectionParams, int i) {

    }
}