package ptit.android.fragment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import ptit.android.fragment2.adapter.AdapterViewPager;

public class MainActivity extends AppCompatActivity {
    TabLayout tab;
    ViewPager vp;
    AdapterViewPager avp;

    BottomNavigationView bottomNav;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tab = findViewById(R.id.tab);
        vp = findViewById(R.id.vp);
        avp = new AdapterViewPager(getSupportFragmentManager(), 3);
        vp.setPageTransformer(true, new HorizontalFlipTransformation());
        vp.setAdapter(avp);
        tab.setupWithViewPager(vp);

        floatingActionButton = findViewById(R.id.floatingButton);
        bottomNav = findViewById(R.id.bottom_nav);

        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0: bottomNav.getMenu().findItem(R.id.mFragA).setChecked(true); break;
                    case 1: bottomNav.getMenu().findItem(R.id.mFragB).setChecked(true); break;
                    case 2: bottomNav.getMenu().findItem(R.id.mFragC).setChecked(true); break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.mFragA: vp.setCurrentItem(0); break;
                    case R.id.mFragB: vp.setCurrentItem(1); break;
                    case R.id.mFragC: vp.setCurrentItem(2); break;
                }
                return false;
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}