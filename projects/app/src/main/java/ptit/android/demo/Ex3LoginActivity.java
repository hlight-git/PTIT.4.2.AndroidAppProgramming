package ptit.android.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class Ex3LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText u, p;
    Button loginBut, registerBut;
    String[] username = {"admin", "tqh"};
    String[] password = {"admin", "tqh"};
    HashMap <String, String> users;
    void init(){
        u = findViewById(R.id.editUsername);
        p = findViewById(R.id.editPassword);
        loginBut = findViewById(R.id.loginbut);
        registerBut = findViewById(R.id.registerbut);
        loginBut.setOnClickListener(this);
        registerBut.setOnClickListener(this);
        users = new HashMap<>();
        for (int i=0; i<username.length; i++){
            users.put(username[i], password[i]);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise03_1);
        init();
    }

    @Override
    public void onClick(View view) {
        if (view == loginBut){
            String message = "Success!";
            String loginUsername = String.valueOf(u.getText());
            String loginPassword = String.valueOf(p.getText());
            if (!users.containsKey(loginUsername) | users.get(loginUsername).compareTo(loginPassword) != 0){
                message = "Fail!";
            }
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
        if (view == registerBut){
            Intent intent = new Intent(this, Ex3RegisterActivity.class);
            startActivity(intent);
        }
    }
    public void Login(View view){
//        Toast.makeText(this, String.format("LoggedIn with username is %s and password is %s", u.getText(), p.getText()), Toast.LENGTH_LONG).show();
    }
}
