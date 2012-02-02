package com.christophercotton.android.deviceinfo;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.TextView;

public class DeviceInfoActivity extends Activity
{
    private static final String TAG = "DeviceInfo";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Android ID
        String androidId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        TextView tx = (TextView) findViewById(R.id.androidid);
        tx.setText(androidId);
        Log.i(TAG, "ANDROID_ID " + androidId);

        // Wifi Service
        WifiManager manager = ( WifiManager ) getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = manager.getConnectionInfo();
        String wifiString = wifiInfo.getMacAddress();

        tx = (TextView) findViewById(R.id.macaddress);
        tx.setText(wifiString);
        Log.i(TAG, "WiFi MAC Address " + wifiString);
        
        // Hardware Serial Number
        String serialString = Build.SERIAL;
        tx = (TextView) findViewById(R.id.serial);
        tx.setText(serialString);
        Log.i(TAG, "Hardware Serial " + serialString);

        
    }
}
