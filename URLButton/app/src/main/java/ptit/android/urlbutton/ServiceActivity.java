package ptit.android.urlbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ServiceActivity extends AppCompatActivity {
    Intent serviceIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        serviceIntent = new Intent(this, MyService.class);
    }

    public void start(View view){
        serviceIntent.putExtra("param", "data");
        startService(serviceIntent);
    }
    public void stop(View view){
        stopService(serviceIntent);
    }
}