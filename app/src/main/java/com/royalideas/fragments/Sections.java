package com.royalideas.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.royalideas.Downloaded;
import com.royalideas.MainActivity;
import com.royalideas.R;
import com.royalideas.adapter.HeightAdapterSection;
import com.royalideas.adapter.Product;
import com.royalideas.adapter.ProductsCategories;
import com.royalideas.adapter.WidthAdapterSection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Sections extends Fragment implements Downloaded {

    ViewPager mViewPager;
    TabLayout tabLayout;
    SectionsPagerAdapter sectionsPagerAdapter;

    static ArrayList<ProductsCategories> ProductsCategoriesList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sections, container, false);
        mViewPager = (ViewPager) view.findViewById(R.id.container);
        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        ProductsCategoriesList=new ArrayList<>();

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        ProductsCategories productsCategories = new ProductsCategories();
        productsCategories.getProductsCategories(getActivity(),this);
    }

    @Override
    public void ProductsCategories(ArrayList<ProductsCategories> ProductsCategoriesList) {
        this.ProductsCategoriesList=ProductsCategoriesList;
        sectionsPagerAdapter=new SectionsPagerAdapter(getFragmentManager());
        mViewPager.setAdapter(sectionsPagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    public void MultiProducts(ArrayList<Product> MultiProductsList) {

    }


    public static class PlaceholderFragment extends Fragment{
        RecyclerView recyclerView;
        HeightAdapterSection heightAdapterSection;
        WidthAdapterSection widthAdapterSection;

        //WidthAdapterSection adapter;
        //int count =0;
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt("mynumber", sectionNumber);
            //Log.i(TAG, sectionNumber+"");
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //Log.i(TAG, count+"");
            //count++;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tab, container, false);
            //TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            //textView.setText(
            //       getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            //Log.i("**** info ****", getArguments().getInt("mynumber")+"");
            recyclerView = (RecyclerView) rootView.findViewById(R.id.list);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setHasFixedSize(true);
            if(getArguments().getInt("mynumber")==1)
            {
                widthAdapterSection = new WidthAdapterSection(ProductsCategoriesList,getActivity());
                recyclerView.setAdapter(widthAdapterSection);
            }else if(getArguments().getInt("mynumber")==2) {
                heightAdapterSection = new HeightAdapterSection(ProductsCategoriesList,getActivity());
                recyclerView.setAdapter(heightAdapterSection);
            }
        return rootView;
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

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
