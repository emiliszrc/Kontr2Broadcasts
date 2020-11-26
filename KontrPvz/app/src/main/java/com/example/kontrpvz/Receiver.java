package com.example.kontrpvz;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if ("1_Programos_nesist_trans".equals(intent.getAction())) {
            String data = intent.getStringExtra("extra_data");
            String senderIntent = intent.getAction();
            String senderProgram = intent.getStringExtra("sender_application");
            String senderLocation = intent.getStringExtra("sender_location");
            String replyTo = intent.getStringExtra("reply_to");

            setMainText(senderIntent, senderProgram, data);
            Toast.makeText(context, data, Toast.LENGTH_SHORT).show();

            respondToSender(senderLocation, replyTo);
        }
    }

    private void respondToSender(String senderLocation, String replyTo) {
        Intent intent = new Intent("2_Programos_nesist_isreikst_trans");
        ComponentName cn1 = new ComponentName(senderLocation, replyTo);
        intent.setComponent(cn1);
        MainActivity.getInstance().sendBroadcast(intent);
    }

    private void setMainText(String senderIntent, String senderProgram, String data)
    {
        try {
            MainActivity.getInstance().updateTheTextView(senderIntent, senderProgram, data);
        } catch (Exception e) {

        }
    }
}
