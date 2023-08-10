package ptit.android.notifyapi26;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button nbut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nbut = findViewById(R.id.nbut);
        nbut.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(
                        MainActivity.this,
                        MyNotification.CHANNEL_ID
                )
                        .setContentTitle("Thong bao")
                        .setContentText("Ndung thong bao")
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setColor(Color.RED)
                        .setDefaults(NotificationCompat.DEFAULT_SOUND)
                        .setCategory(NotificationCompat.CATEGORY_ALARM);
                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getApplicationContext());
                managerCompat.notify(getId(), builder.build());
            }
        });
    }
    private int getId(){
        return (int)new Date().getTime();
    }
}