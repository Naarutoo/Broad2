package com.example.broadcastass2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView mTvFirstName, mTvLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initview();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(inent);
            }
        });

        IntentFilter intentFilter = new IntentFilter("action");
        LocalBroadcastManager.getInstance(this).registerReceiver(new Receiver(), intentFilter);
    }

    private void initview() {
        button = findViewById(R.id.buttonClick);
        mTvFirstName = findViewById(R.id.tvFirstName);
        mTvLastName = findViewById(R.id.tvLastName);
    }

    public class Receiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                mTvFirstName.setText(intent.getStringExtra("FN"));
                mTvLastName.setText(intent.getStringExtra("LN"));
            }
        }
    }
}