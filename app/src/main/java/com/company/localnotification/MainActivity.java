package com.company.localnotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;
    public final String CHANEL_ID = "1";
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                button.setText(""+count);
                if(count==5){
                    startNotification();
                }
            }
        });
    }

    //    start

    public void startNotification(){

        NotificationChannel channel = new NotificationChannel(CHANEL_ID,"1", NotificationManager.IMPORTANCE_DEFAULT);
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.createNotificationChannel(channel);

        Notification.Builder builder = new Notification.Builder(MainActivity.this,CHANEL_ID);
         builder.setSmallIcon(R.drawable.ic_baseline_notifications_24)
                 .setContentTitle("Notification")
                 .setContentText("Notifying you");

        NotificationManagerCompat compat = NotificationManagerCompat.from(MainActivity.this);
        compat.notify(1,builder.build());

    }

//    end ========>>>>>   only this much for local notification
}