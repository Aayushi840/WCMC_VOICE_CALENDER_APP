package com.example.voicecalendar;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
//import android.support.v4.app.NotificationCompat;

import androidx.core.app.NotificationCompat;

public class Notification_receiver  extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Intent repeating_intent = new Intent(context,screen2.class);
        repeating_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context,100,repeating_intent,PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context).setContentIntent(pendingIntent)
                .setSmallIcon(android.R.drawable.arrow_up_float).setContentTitle("Schedule Manager")
                .setContentText("Make sure to check if you have any schedule today")
                .setAutoCancel(true);

        notificationManager.notify(100,builder.build());
    }
}
