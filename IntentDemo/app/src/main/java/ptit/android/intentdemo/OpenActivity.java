package ptit.android.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import ptit.android.intentdemo.model.Student;

public class OpenActivity extends AppCompatActivity {
    Button preActBut;
    ImageView imageView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);
        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);
        Intent t = getIntent();
        Student s = (Student) t.getSerializableExtra("student");
        imageView.setImageResource(s.getImage());
        textView.setText(s.getName());
        preActBut = findViewById(R.id.preActBut);
        preActBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}