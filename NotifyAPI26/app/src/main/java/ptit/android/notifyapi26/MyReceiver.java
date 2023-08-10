package ptit.android.notifyapi26;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import java.util.Date;

public class MyReceiver extends BroadcastReceiver {
    final static String CHANNEL_ID = "channel 1";
    @SuppressLint({"MissingPermission", "NotificationPermission"})
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("ABC")){
            NotificationManager notificationManager =
                    (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                NotificationChannel channel1 = new NotificationChannel(
                        CHANNEL_ID,
                        "Channel 1",
                        NotificationManager.IMPORTANCE_HIGH);
                channel1.setDescription("Hen gio 1");
                notificationManager.createNotificationChannel(channel1);
            }
            NotificationCompat.Builder builder = new NotificationCompat.Builder(
                    context,
                    CHANNEL_ID
            )
                    .setContentTitle("Thong bao 2")
                    .setContentText("Ndung thong bao 2")
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setColor(Color.RED)
                    .setDefaults(NotificationCompat.DEFAULT_SOUND)
                    .setCategory(NotificationCompat.CATEGORY_ALARM);
            notificationManager.notify(getId(), builder.build());
        }
    }

    private int getId(){
        return (int)new Date().getTime();
    }
}
