package ptit.android.kt1_b19dccn333;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ptit.android.kt1_b19dccn333.model.Project;
import ptit.android.kt1_b19dccn333.model.ProjectAdapter;


public class MainActivity extends AppCompatActivity implements ProjectAdapter.ItemClickListener, SearchView.OnQueryTextListener {
    RecyclerView recyclerView;
    ProjectAdapter adapter;
    SearchView searchView;
    EditText prjNameEdit, startDayEdit, endDayEdit;
    CheckBox checkFinished;
    Button addButton, updateButton;

    int currentSelectedPosition;

    void findButtons(){
        addButton = findViewById(R.id.addButton);
        updateButton = findViewById(R.id.updateButton);
        updateButton.setEnabled(false);
    }
    void findStaticElements(){
        prjNameEdit = findViewById(R.id.projectNameEdit);
        startDayEdit = findViewById(R.id.startDayEdit);
        startDayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                int cy = c.get(Calendar.YEAR);
                int cm = c.get(Calendar.MONTH);
                int cd = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                                startDayEdit.setText(d +"/" + m + "/" + y);
                            }
                        }, cy, cm, cd
                );
                dialog.show();
            }
        });
        endDayEdit = findViewById(R.id.endDayEdit);
        endDayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                int cy = c.get(Calendar.YEAR);
                int cm = c.get(Calendar.MONTH);
                int cd = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                                endDayEdit.setText(d +"/" + m + "/" + y);
                            }
                        }, cy, cm, cd
                );
                dialog.show();
            }
        });
        checkFinished = findViewById(R.id.checkFinished);
    }
    void init(){
        recyclerView = findViewById(R.id.recycleView);
        findStaticElements();
        findButtons();
        searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        adapter = new ProjectAdapter(this, this);
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Project item = new Project();
                String name = prjNameEdit.getText().toString();
                if (name.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Project name field is empty!", Toast.LENGTH_SHORT).show();
                    return;
                }

                String startDayString = startDayEdit.getText().toString();
                String endDayString = endDayEdit.getText().toString();
                if (startDayString.isEmpty() || endDayString.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Start day field or End day field is empty!", Toast.LENGTH_SHORT).show();
                    return;
                }
                boolean isFinished = checkFinished.isChecked();
                item.setName(name);
                item.setStartDay(startDayString);
                item.setEndDay(endDayString);
                item.setFinished(isFinished);
                adapter.add(item);
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Project item = adapter.getItem(currentSelectedPosition);
                String name = prjNameEdit.getText().toString();
                if (name.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Project name field is empty!", Toast.LENGTH_SHORT).show();
                    return;
                }

                String startDayString = startDayEdit.getText().toString();
                String endDayString = endDayEdit.getText().toString();
                if (startDayString.isEmpty() || endDayString.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Start day field or End day field is empty!", Toast.LENGTH_SHORT).show();
                    return;
                }
                boolean isFinished = checkFinished.isChecked();
                item.setName(name);
                item.setStartDay(startDayString);
                item.setEndDay(endDayString);
                item.setFinished(isFinished);

                addButton.setEnabled(true);
                updateButton.setEnabled(false);
                adapter.update(currentSelectedPosition, item);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClicked(View view, int position) {
        addButton.setEnabled(false);
        updateButton.setEnabled(true);
        currentSelectedPosition = position;
        Project item = adapter.getItem(position);
//        int img = item.getImg();
//        int p = 0;
//        for (int i = 0; i < imgs.length; i++){
//            if(img == imgs[i]){
//                p = i;
//                break;
//            }
//        }
//        spinner.setSelection(p);
//        textViewExample.setText(item.getExample());
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        System.out.println(1);
        filter(s);
        return false;
    }
    void filter(String s){
        List<Project> filterList = new ArrayList<>();
        for(Project item:adapter.getListBackUp()){
            if(item.getName().toLowerCase().contains(s.toLowerCase())){
                filterList.add(item);
            }
        }
        adapter.filterList(filterList);
        if(filterList.isEmpty()){
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }
    }
}