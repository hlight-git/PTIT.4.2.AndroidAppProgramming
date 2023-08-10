package ptit.android.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import ptit.android.sqlite.model.Category;
import ptit.android.sqlite.model.Item;

public class MainActivity extends AppCompatActivity {
    Spinner spCate;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spCate = findViewById(R.id.spinner);
        txt = findViewById(R.id.txt);

        Database database = new Database(this);
//        database.insertCate(new Category("Cate 1"));
//        database.insertCate(new Category("Cate 2"));
//        database.insertCate(new Category("Cate 3"));
        List<Category> list = database.getCates();
        String[] st = new String[list.size()];
        for (int i=0; i<list.size(); i++){
            st[i] = list.get(i).getId() + "-" + list.get(i).getName();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item, st);
        spCate.setAdapter(adapter);

//        database.insertItem(new Item("tqh", 100, "23/09/2001", new Category(1, "")));
//        database.insertItem(new Item("dtc", 200, "03/04/2003", new Category(2, "")));
//        List<Item> items = database.getItems();
//        String ss = "";
//        for (Item item:items){
//            ss += "\n" + item.getName() + "-" + item.getCategory().getName();
//        }
//        txt.setText(ss);

        Item item = database.getItemById(1);
        txt.setText(item.getName());

        item.setName(item.getName() + "update");
        database.update(item);
        item = database.getItemById(1);
        txt.setText(item.getName());
    }
}