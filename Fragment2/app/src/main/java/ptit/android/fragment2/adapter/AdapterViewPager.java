package ptit.android.fragment2.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import ptit.android.fragment2.fragment.FragmentA;
import ptit.android.fragment2.fragment.FragmentB;
import ptit.android.fragment2.fragment.FragmentC;

public class AdapterViewPager extends FragmentPagerAdapter {
    private int numPage;
    public AdapterViewPager(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.numPage = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new FragmentA();
            case 1: return new FragmentB();
            case 2: return new FragmentC();

        }
        return null;
    }

    @Override
    public int getCount() {
        return numPage;
    }

    public CharSequence getPageTitle(int possition){
        switch (possition){
            case 0: return "food";
            case 1: return "movie";
            case 2: return "travel";
        }
        return null;
    }
}