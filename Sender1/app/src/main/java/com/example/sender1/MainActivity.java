package com.example.sender1;

import android.Manifest;
import android.content.Intent;
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
        Intent intent = new Intent("com.example.broadcast.MY_NOTIFICATION");
        intent.putExtra("com.codinginflow.EXTRA_TEXT", "Broadcast received");
        intent.putExtra("extra_data","Anime gal nereikia");
        sendBroadcast(intent);
    }
}
