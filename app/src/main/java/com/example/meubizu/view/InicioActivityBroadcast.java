package com.example.meubizu.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class InicioActivityBroadcast extends BroadcastReceiver {
 
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Intent i = new Intent(context, TelaAberturaActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //chamando o startactivty de fora do contexto
            context.startActivity(i);
        }
    }
}