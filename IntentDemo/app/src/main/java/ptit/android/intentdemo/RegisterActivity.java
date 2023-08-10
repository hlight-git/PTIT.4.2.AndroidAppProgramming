package ptit.android.intentdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ptit.android.intentdemo.model.User;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    Button cancelBut, registerBut;
    EditText usernameText, passwordText;
    void init(){
        usernameText = findViewById(R.id.usernameFieldRegister);
        passwordText = findViewById(R.id.passwordFieldRegister);
        cancelBut = findViewById(R.id.cancelRegBut);
        registerBut = findViewById(R.id.okRegBut);
        cancelBut.setOnClickListener(this);
        registerBut.setOnClickListener(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cancelRegBut:{
                setResult(RESULT_CANCELED, null);
                finish();
                break;
            }
            case R.id.okRegBut:{
                User user = new User(usernameText.getText().toString(),
                        passwordText.getText().toString());
                Intent intent = new Intent();
                intent.putExtra("User", user);
                setResult(RESULT_OK, intent);
                finish();
                break;
            }
        }
    }

}