package com.royalideas.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.royalideas.R;
import com.royalideas.fragments.ProductFragment;
import com.royalideas.fragments.SectionsFragment;

/**
 * Created by ahmed on 05/05/17.
 */

public class SectionsPagerAdapter extends FragmentStatePagerAdapter {
    Context context;
    boolean sectionadapter;
    public SectionsPagerAdapter(FragmentManager fm,Context context,boolean sectionadapter) {
        super(fm);
        this.context=context;
        this.sectionadapter=sectionadapter;
    }

    @Override
    public Fragment getItem(int position) {
        if(sectionadapter)
            return SectionsFragment.PlaceholderFragment.newInstance(position + 1);
        else
            return ProductFragment.PlaceholderFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getResources().getString(R.string.height);
            case 1:
                return context.getResources().getString(R.string.width);
        }
        return null;
    }
}
