package com.example.broadcastass2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    EditText fn, ln;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initview();
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent("action");
                String firstName = fn.getText().toString();
                String lastname = ln.getText().toString();


                intent2.putExtra("FN", firstName);
                intent2.putExtra("LN", lastname);
                LocalBroadcastManager.getInstance(MainActivity2.this).sendBroadcast(intent2);
            }
        });

    }

    private void initview() {
        fn = findViewById(R.id.etFirstname);
        ln = findViewById(R.id.etLastName);
        send = findViewById(R.id.btnSend);
    }
}