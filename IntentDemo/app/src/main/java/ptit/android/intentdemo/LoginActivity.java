package ptit.android.intentdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ptit.android.intentdemo.model.User;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private final static int REQUEST_CODE = 23092001;
    List<User> users = new ArrayList<User>(){{
        add(new User("admin", "admin"));
    }};
    Button loginBut, registerBut;
    EditText usernameText, passwordText;

    void init(){
        usernameText = findViewById(R.id.usernameFieldLogin);
        passwordText = findViewById(R.id.passwordFieldLogin);
        loginBut = findViewById(R.id.loginBut);
        registerBut = findViewById(R.id.registerBut);
        loginBut.setOnClickListener(this);
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
            case R.id.loginBut:{
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                User user = new User(usernameText.getText().toString(),
                        passwordText.getText().toString());
                for (User u:users){
                    if (u.getUsername() == user.getUsername() && u.getPassword() == user.getPassword()){
                        intent.putExtra("User", user);
                        startActivity(intent);
                        break;
                    }
                }
                break;
            }
            case R.id.registerBut:{
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                if(data == null) {
                    Toast.makeText(getApplicationContext(), "Ban da huy dang ki",
                            Toast.LENGTH_LONG).show();
                } else {
                    User u = (User) data.getSerializableExtra("User");
                    usernameText.setText(u.getUsername());
                    passwordText.setText(u.getPassword());
                    users.add(u);
                }
            }
        }
    }
}