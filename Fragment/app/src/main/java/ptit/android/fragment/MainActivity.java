package ptit.android.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ptit.android.fragment.fragment.FragmentA;
import ptit.android.fragment.fragment.FragmentB;
import ptit.android.fragment.fragment.FragmentC;

public class MainActivity extends AppCompatActivity {
    FragmentManager manager;
    Button bt1, bt2, bt3;
    Button rbt1, rbt2, rbt3;
    Button popAbt;

    void init(){
        bt1 = findViewById(R.id.openfragment_a);
        bt2 = findViewById(R.id.openfragment_b);
        bt3 = findViewById(R.id.openfragment_c);

        rbt1 = findViewById(R.id.removeA);
        popAbt = findViewById(R.id.popA);

        rbt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeFragment("fragmentA");
            }
        });
        popAbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popFragment(view);
            }
        });
        manager = getSupportFragmentManager();

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentA fragmentA = new FragmentA();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.frame, fragmentA, "fragmentA");
                transaction.addToBackStack("fragmentA");
                transaction.commit();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentB fragmentB = new FragmentB();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.frame, fragmentB, "fragmentB");
                transaction.addToBackStack("fragmentB");
                transaction.commit();
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentC fragmentC = new FragmentC();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.frame, fragmentC, "fragmentC");
                transaction.addToBackStack("fragmentC");
                transaction.commit();
            }
        });
    }

    void removeFragment(String tag){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(manager.findFragmentByTag(tag));
        transaction.commit();
    }

    void popFragment(View v){
        manager.popBackStack("fragmentA", 0);
    }
    @Override
    public void onBackPressed() {
        if(manager.getBackStackEntryCount() > 0){
            manager.popBackStack();
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
}