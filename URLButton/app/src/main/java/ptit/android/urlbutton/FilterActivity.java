package ptit.android.urlbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class FilterActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        tv = findViewById(R.id.tv);
//        Uri url = getIntent().getData();
//        String st = "Scheme:" + url.getScheme() + "\nHost:"+url.getHost();
//        int k = 1;
//        for (String s:url.getPathSegments()){
//            st += "\nSegment " + (k++) + " " + s;
//        }
//        tv.setText(st);

        String s = "Content:" + getIntent().getStringExtra("sms_body");
        String pNum = getIntent().getDataString();
        s += "\npattern:"+pNum;
        tv.setText(s);
    }
}