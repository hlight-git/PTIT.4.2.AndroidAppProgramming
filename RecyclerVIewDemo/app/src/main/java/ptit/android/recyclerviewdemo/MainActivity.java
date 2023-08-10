package ptit.android.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ptit.android.recyclerviewdemo.adapter.PersonAdapter;
import ptit.android.recyclerviewdemo.model.Person;

public class MainActivity extends AppCompatActivity implements PersonAdapter.PersonItemListener {
    RecyclerView recyclerView;
    Button addButton;
    PersonAdapter adapter;
    List<Person> people;

    private void getPeople(){
        people = new ArrayList<>();
        people.add(new Person(R.drawable.pic1, "pic1"));
        people.add(new Person(R.drawable.pic2, "pic2"));
        people.add(new Person(R.drawable.pic3, "pic3"));
        people.add(new Person(R.drawable.pic4, "pic4"));
        people.add(new Person(R.drawable.pic5, "pic5"));
    }
    public void init(){
        recyclerView = findViewById(R.id.recyclerView);
        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.addPerson(people.get(0));
            }
        });
        getPeople();
        adapter = new PersonAdapter(this, people);
        adapter.setPersonItemListener(this);
        recyclerView.setAdapter(adapter);

        GridLayoutManager manager = new GridLayoutManager(this, 3);
//        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    public void onItemClicked(View view, int position) {
        Person person = adapter.getPersonAt(position);
        Toast.makeText(this, person.getName(), Toast.LENGTH_SHORT).show();
    }
}