package ptit.android.kt2_template.fragment.tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import ptit.android.kt2_template.R;
import ptit.android.kt2_template.fragment.AdapterViewPager;
import ptit.android.kt2_template.fragment.HorizontalFlipTransformation;

public class Tablayout extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    AdapterViewPager adapterViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        viewPager = findViewById(R.id.vp);
        adapterViewPager = new AdapterViewPager(getSupportFragmentManager(), 3);
        viewPager.setPageTransformer(true, new HorizontalFlipTransformation());
        viewPager.setAdapter(adapterViewPager);

        tabLayout = findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);
    }
}