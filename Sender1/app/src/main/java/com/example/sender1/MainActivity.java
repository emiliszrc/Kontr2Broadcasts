package com.example.sender1;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendBroadcast(View v) {
        String receiverLocation = ResponseBroadcastReceiver.class.toString();
        String replyTo = receiverLocation.replace("class ", "");

        Intent intent = new Intent("1_Programos_nesist_trans");
        intent.putExtra("sender_application", getApplicationName(this));
        intent.putExtra("extra_data","ping");
        intent.putExtra("sender_location", getApplicationContext().getPackageName());
        intent.putExtra("reply_to", replyTo);

        sendBroadcast(intent);
    }

    public static String getApplicationName(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int stringId = applicationInfo.labelRes;
        return stringId == 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(stringId);
    }
}
