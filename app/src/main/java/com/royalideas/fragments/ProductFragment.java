package com.royalideas.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.royalideas.R;
import com.royalideas.adapter.Product;
import com.royalideas.adapter.WidthAdapterProduct;


import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductFragment extends Fragment {


    ViewPager mViewPager;
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
        mViewPager.setAdapter(sectionsPagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Product products = new Product();
        products.getMultiProducts(getActivity(),this);
    }

    public static class PlaceholderFragment extends Fragment{
        RecyclerView recyclerView;
        //HeightAdapterSection heightAdapterSection;
        //WidthAdapterSection widthAdapterSection;
        WidthAdapterProduct widthAdapterProduct;
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

            recyclerView = (RecyclerView) rootView.findViewById(R.id.list);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setHasFixedSize(true);
            ArrayList<String>arr = new ArrayList<>();
            arr.add("first");
            arr.add("secomd");
            widthAdapterProduct= new WidthAdapterProduct(arr,getActivity());
            recyclerView.setAdapter(widthAdapterProduct);
            /*if(getArguments().getInt("mynumber")==1) {
                widthAdapterSection = new WidthAdapterSection(ProductsCategoriesList,getContext());
                recyclerView.setAdapter(widthAdapterSection);
            }else if(getArguments().getInt("mynumber")==2)
            {
                heightAdapterSection = new HeightAdapterSection(ProductsCategoriesList,getContext());
                recyclerView.setAdapter(heightAdapterSection);

            }*/
            return rootView;
        }


    }

    public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

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
