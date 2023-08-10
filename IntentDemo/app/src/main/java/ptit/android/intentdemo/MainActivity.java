package ptit.android.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ptit.android.intentdemo.model.Student;
import ptit.android.intentdemo.model.User;

public class MainActivity extends AppCompatActivity {
    Button nextActBut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextActBut = findViewById(R.id.nextActBut);
        nextActBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = (User) getIntent().getSerializableExtra("User");
                Intent intent = new Intent(MainActivity.this, OpenActivity.class);
                intent.putExtra("student", new Student(R.drawable.chinh, user.getUsername()));
                startActivity(intent);
            }
        });
    }
}