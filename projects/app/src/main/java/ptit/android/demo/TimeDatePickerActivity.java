package ptit.android.demo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class TimeDatePickerActivity extends AppCompatActivity
        implements View.OnClickListener {
    EditText timeEt, dateEt;
    Button timeBut, dateBut;

    void init(){
        timeEt = findViewById(R.id.timeEt);
        dateEt = findViewById(R.id.dateEt);
        timeBut = findViewById(R.id.timeBut);
        dateBut = findViewById(R.id.dateBut);
        timeBut.setOnClickListener(this);
        dateBut.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_date_picker);
        init();
    }

    @Override
    public void onClick(View view) {
        if (timeBut == view){
            Calendar c = Calendar.getInstance();
            int ch = c.get(Calendar.HOUR_OF_DAY);
            int cm = c.get(Calendar.MINUTE);
            TimePickerDialog dialog = new TimePickerDialog(TimeDatePickerActivity.this,
                    new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker timePicker, int i, int i1) {
                            timeEt.setText(i +":" + i1);
                        }
                    }, ch, cm, true
            );
            dialog.show();
        }
        if (dateBut == view){
            Calendar c = Calendar.getInstance();
            int cy = c.get(Calendar.YEAR);
            int cm = c.get(Calendar.MONTH);
            int cd = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog = new DatePickerDialog(TimeDatePickerActivity.this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                            dateEt.setText(d +"/" + m + "/" + y);
                        }
                    }, cy, cm, cd
            );
            dialog.show();
        }
    }
}
