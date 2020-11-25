package com.example.kontrpvz;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if ("com.example.broadcast.MY_NOTIFICATION".equals(intent.getAction())) {
            String receivedText = intent.getStringExtra("com.codinginflow.EXTRA_TEXT");
            String data = intent.getStringExtra("extra_data");
            String senderIntent = intent.getAction();
            String senderProgram = intent.getPackage();

            setMainText(senderIntent, senderProgram, data);
            Toast.makeText(context, data, Toast.LENGTH_SHORT).show();

            respondToSender();
        }
    }

    private void respondToSender() {
        Intent intent = new Intent("com.example.RESPONSE_ACTION");
        ComponentName cn1 = new ComponentName("com.example.sender1",
                "com.example.sender1.ResponseBroadcastReceiver");
        intent.setComponent(cn1);
        MainActivity.getInstace().sendBroadcast(intent);
    }

    private void setMainText(String senderIntent, String senderProgram, String data)
    {
        try {
            MainActivity.getInstace().updateTheTextView(senderIntent, senderProgram, data);
        } catch (Exception e) {

        }
    }
}
