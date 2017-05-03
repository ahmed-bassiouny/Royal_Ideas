package com.royalideas.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.royalideas.MainActivity;
import com.royalideas.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Sections extends Fragment {

    private ViewPager mViewPager;
    TabLayout tabLayout;
    SectionsPagerAdapter sectionsPagerAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sections, container, false);
        mViewPager = (ViewPager) view.findViewById(R.id.container);
        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        sectionsPagerAdapter=new SectionsPagerAdapter(getFragmentManager());
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewPager.setAdapter(sectionsPagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);
    }

    public static class PlaceholderFragment extends Fragment {
        ListView listView;  ArrayAdapter<String> adapter;
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt("mynumber", sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tab, container, false);
            //TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            //textView.setText(
            //       getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            //Log.i("**** info ****", getArguments().getInt("mynumber")+"");
            listView = (ListView) rootView.findViewById(R.id.list);
            String [] arr = {"aaaaa","wwwwwwwwww","5555555"};
            String [] arr2 = {"aaaaa","wwwwwwwwww"};
            if(arr.length>0&&getArguments().getInt("mynumber")==1) {
                adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, arr);
                Toast.makeText(getActivity(), "1111", Toast.LENGTH_SHORT).show();
                listView.setAdapter(adapter);

            }else if(arr.length>0&&getArguments().getInt("mynumber")==2) {{
                adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, arr2);
                listView.setAdapter(adapter);
            }
            }
            return rootView;
        }

    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
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
                    return getResources().getString(R.string.height);
                case 1:
                    return getResources().getString(R.string.width);
            }
            return null;
        }
    }
}
