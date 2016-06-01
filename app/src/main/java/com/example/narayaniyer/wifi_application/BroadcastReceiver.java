package com.example.narayaniyer.wifi_application;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;

/**
 * Created by Narayan.Iyer on 5/24/2016.
 */
public class BroadcastReceiver extends Activity {

    public void OnReceive(Context context, Intent intent)
    {
        Wifi_Activity activity=new Wifi_Activity();
        String action=intent.getAction();
        if(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION.equals(action))
        {
            int state =intent.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE, -1);
            if(state==WifiP2pManager.WIFI_P2P_STATE_ENABLED)
            {
                activity.setIsWifiP2pEnabled(true);
            }
            else
            {
               activity.setIsWifiP2pEnabled(false);
            }
        }
        else if(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION.equals(action)){
            //The peer list has changed action has to be taken
        }
        else if(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION.equals(action))
        {
            //The connection has changed action has to be taken
        }
        else if(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION.equals(action))
        {
            DeviceListFragment fragment=(DeviceListFragment)activity.getFragmentManager()
                                          .findFragmentById(R.id.frag_list);
        }
    }

}
