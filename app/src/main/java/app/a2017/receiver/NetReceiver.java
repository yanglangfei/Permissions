package app.a2017.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;

import java.io.FileOutputStream;

public class NetReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        ConnectivityManager cm= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = cm.getActiveNetworkInfo();

        if(activeNetworkInfo.isAvailable()){
            NetworkInfo.State type = activeNetworkInfo.getState();
            if(type==NetworkInfo.State.CONNECTED){
               //连接上网络
            }
        }
    }
}
