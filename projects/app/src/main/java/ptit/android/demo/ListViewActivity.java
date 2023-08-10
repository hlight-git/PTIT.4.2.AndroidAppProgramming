package ptit.android.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ptit.android.demo.model.Alphabet;
import ptit.android.demo.model.AlphabetAdapter;

public class ListViewActivity extends AppCompatActivity {
    ListView lv;


    private Alphabet[] list;
    private AlphabetAdapter adapter;
    void init(){
        // Basic listview
//        lv = findViewById(R.id.listView);
//        String[] sa = getResources().getStringArray(R.array.alphabet);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.item, sa);
//        lv.setAdapter(adapter);
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(ListViewActivity.this, lv.getAdapter().getItem(i).toString(), Toast.LENGTH_LONG).show();
//            }
//        });


        // Alphabet listview
        lv = findViewById(R.id.listView);

        Integer[] imgs = {
                R.drawable.i1,
                R.drawable.i2,
                R.drawable.i3,
                R.drawable.i4
        };
        String[] titles = {"A", "B", "C", "D"};
        String[] descs = {"chu A", "chu B", "chu C", "chu D"};
        list = new Alphabet[imgs.length];
        for (int i=0; i < list.length; i++){
            list[i] = new Alphabet(imgs[i], titles[i], descs[i]);
        }
        adapter = new AlphabetAdapter(this, list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                for (int j=0; j<adapter.getCount(); j++){
                    lv.getChildAt(j).setBackgroundColor(Color.TRANSPARENT);
                }
                lv.getChildAt(i).setBackgroundColor(Color.GRAY);
                Toast.makeText(getApplicationContext(), adapter.getItem(i).getTitle(), Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        init();
    }
}