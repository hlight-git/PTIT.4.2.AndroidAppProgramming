package ptit.android.urlbutton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    static final int REQUEST_CALL_PHONE = 10000;
    Button but1, but2, but3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but1 = findViewById(R.id.but1);
        but2 = findViewById(R.id.but2);
        but3 = findViewById(R.id.but3);
        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        but3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.but1:
                Intent t = new Intent(Intent.ACTION_VIEW);
                t.setData(Uri.parse("https://www.youtube.com/playlist?list=PLD8zSU7U1L2GVhpPIUlJegpP8HRC2r58w"));
                startActivity(t);
                break;
            case R.id.but2:
                Intent t2 = new Intent(Intent.ACTION_VIEW);
                t2.setData(Uri.parse("sms: 0123456789"));
                t2.putExtra("sms_body", "SMS");
                startActivity(t2);
                break;
            case R.id.but3:
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:0123456789"));
                    startActivity(callIntent);
                } else {
                    ActivityCompat.requestPermissions(this, new
                            String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PHONE);
                }
                break;
        }
    }
}