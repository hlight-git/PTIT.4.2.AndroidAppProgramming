package ptit.android.kt2_template.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

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
            case 0: return "title1";
            case 1: return "title2";
            case 2: return "title3";
        }
        return null;
    }
}