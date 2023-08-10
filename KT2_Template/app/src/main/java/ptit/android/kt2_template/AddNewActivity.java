package ptit.android.kt2_template;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ptit.android.kt2_template.model.MyModel;

public class AddNewActivity extends AppCompatActivity {

    Button hoanTatBut, quayLaiBut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);
        hoanTatBut = findViewById(R.id.hoanTatBut);
        quayLaiBut = findViewById(R.id.quaylaiBut);

        quayLaiBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        hoanTatBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyModel myModel = (MyModel) getIntent().getSerializableExtra("myModel");


                finish();
            }
        });
    }
}