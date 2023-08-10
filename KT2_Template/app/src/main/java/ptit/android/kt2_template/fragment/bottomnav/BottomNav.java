package ptit.android.kt2_template.fragment.bottomnav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import ptit.android.kt2_template.R;
import ptit.android.kt2_template.fragment.AdapterViewPager;
import ptit.android.kt2_template.fragment.HorizontalFlipTransformation;

public class BottomNav extends AppCompatActivity {
    ViewPager viewPager;
    AdapterViewPager adapterViewPager;
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);
        viewPager = findViewById(R.id.vp2);
        adapterViewPager = new AdapterViewPager(getSupportFragmentManager(), 3);
        viewPager.setPageTransformer(true, new HorizontalFlipTransformation());
        viewPager.setAdapter(adapterViewPager);

        bottomNav = findViewById(R.id.botnav);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
                    case R.id.mFragA: viewPager.setCurrentItem(0); break;
                    case R.id.mFragB: viewPager.setCurrentItem(1); break;
                    case R.id.mFragC: viewPager.setCurrentItem(2); break;
                }
                return false;
            }
        });
    }
}