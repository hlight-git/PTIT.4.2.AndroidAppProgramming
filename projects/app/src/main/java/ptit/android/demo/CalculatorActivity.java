//package ptit.android.demo;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.EditText;
//import android.widget.Spinner;
//
//public class CalculatorActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
//    EditText e1, e2;
//
//    Spinner sp;
//
//    void init(){
//        sp = findViewById(R.id.spinner);
//        String[] list = getResources().getStringArray((R.array.phep));
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.item, list);
//        sp.setAdapter(adapter);
//    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.test_constraint_layout);
//    }
//
//    @Override
//    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//        double x = 1;
//        double y = 2;
//        String o = (String) sp.getAdapter().getItem(i);
//
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//
//    }
//
//    private double calculate(double x, double y, String op){
//        switch (op){
//            case "+": return x + y;
//            case "-": return x - y;
//            case "*": return x * y;
//            case "/": return x / y;
//        }
//        return 0;
//    }
//}