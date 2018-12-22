package ru.airportnn.www.strigino.Adapter;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import ru.airportnn.www.strigino.Fragment.Fragment;
import ru.airportnn.www.strigino.R;

public class TabsPagerFragmentAdapter extends FragmentPagerAdapter {

    private String[] tabs;
    private String planeNumber;
    private String direction;

    public TabsPagerFragmentAdapter(Context context, String planeNumber, String direction, FragmentManager fm) {
        super(fm);

        this.planeNumber = planeNumber;
        this.direction = direction;

        tabs = new String[] {
                context.getString(R.string.tabs_item_arrival),
                context.getString(R.string.tabs_item_departure)
        };
    }

    @Override
    public androidx.fragment.app.Fragment getItem(int position) {
        switch (position) {
            case 0:
                if (direction != null && direction.equals("arrival")) {
                    return Fragment.getInstance("arrival", planeNumber);
                } else {
                    return Fragment.getInstance("arrival", null);
                }
            case 1:
                if (direction != null && direction.equals("departure")) {
                    return Fragment.getInstance("departure", planeNumber);
                } else {
                    return Fragment.getInstance("departure", null);
                }
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabs.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
}