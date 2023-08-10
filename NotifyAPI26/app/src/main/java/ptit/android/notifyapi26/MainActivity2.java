package ptit.android.notifyapi26;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity {
    TimePicker timePicker;
    Button buttonHen, buttonBo;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        timePicker = findViewById(R.id.timePick);
        buttonHen = findViewById(R.id.henGioBut);
        buttonBo = findViewById(R.id.boBut);
        buttonHen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
                calendar.set(Calendar.MINUTE, timePicker.getCurrentMinute());
                Intent intent = new Intent(MainActivity2.this, MyReceiver.class);
                intent.setAction("ABC");
                intent.putExtra("name", "tqh");
                intent.putExtra("content", "code");
                alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                pendingIntent = PendingIntent.getBroadcast(MainActivity2.this, 23092001, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
            }
        });
    }
}