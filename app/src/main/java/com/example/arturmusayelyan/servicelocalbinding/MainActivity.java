package com.example.arturmusayelyan.servicelocalbinding;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    // MediaPlayer example

    private Button startBtn, stopBtn;
    private Intent intent;

    private ServiceConnection serviceConnection;
    private boolean bound=false;
    private MyService myService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startBtn = findViewById(R.id.start_btn);
        stopBtn = findViewById(R.id.stop_btn);

        serviceConnection=new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
    }

    public void startOnClick(View view) {
        intent = new Intent(this, MyService.class);
        startService(intent);
    }

    public void stopOnClick(View view) {
        intent = new Intent(this, MyService.class);
        stopService(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        intent = new Intent(this, MyService.class);
        stopService(intent);
    }
}
