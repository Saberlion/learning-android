package info.saberlion.zhihudaily;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Arthur on 2015/10/29.
 */
public class DatePagerAdapter extends FragmentPagerAdapter {

    String[] DateArray = {"abc", "bcd", "efg"};

    public DatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new Fragment();
    }

    @Override
    public int getCount() {
        return DateArray.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return DateArray[position];
    }

}
