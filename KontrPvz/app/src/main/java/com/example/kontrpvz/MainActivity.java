package com.example.kontrpvz;

import android.content.IntentFilter;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Receiver receiver = new Receiver();
    private static MainActivity ins;

    public static MainActivity getInstance() {
        return ins;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intent = new IntentFilter("1_Programos_nesist_trans");
        registerReceiver(receiver, intent);
        ins = this;
    }

    public void updateTheTextView(final String senderIntent, final String senderProgram, final String data) {
        runOnUiThread(new Runnable() {
            public void run() {
                TextView textViewTitle = findViewById(R.id.title);
                textViewTitle.setText("Gautas naujas transliavimo pranešimas:");
                TextView textViewIntentName = findViewById(R.id.textViewIntentName);
                textViewIntentName.setText("Intentas: " + senderIntent);
                TextView textViewProgramName = findViewById(R.id.textViewSenderName);
                textViewProgramName.setText("Siuntėjas: " + senderProgram);
                TextView textView = findViewById(R.id.textViewData);
                textView.setText("Papildoma informacija: " + data);
            }
        });
    }
}
