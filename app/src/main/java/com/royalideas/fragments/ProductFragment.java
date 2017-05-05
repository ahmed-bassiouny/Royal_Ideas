package com.royalideas.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
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
import android.widget.Toast;

import com.royalideas.Downloaded;
import com.royalideas.R;
import com.royalideas.adapter.Product;
import com.royalideas.adapter.ProductsCategories;
import com.royalideas.adapter.AdapterProduct;
import com.royalideas.helper.Utils;


import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductFragment extends Fragment implements Downloaded{


    ViewPager mViewPager;
    TabLayout tabLayout;
    SectionsPagerAdapter sectionsPagerAdapter;
    static ArrayList<Product> MultiProductsList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sections, container, false);
        mViewPager = (ViewPager) view.findViewById(R.id.container);
        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MultiProductsList=new ArrayList<>();
    }

    @Override
    public void onStart() {
        super.onStart();
        Utils.runProgressDialog(getActivity());
        Product products = new Product();
        products.getMultiProducts(getActivity(),this,getArguments().getString("ID"));
    }

    @Override
    public void ProductsCategories(ArrayList<ProductsCategories> ProductsCategoriesList) {

    }

    @Override
    public void MultiProducts(ArrayList<Product> MultiProductsList) {
        this.MultiProductsList=MultiProductsList;
        if(MultiProductsList.size()==0)
            Toast.makeText(getActivity(), "عفوا ﻻ يوجد منتجات", Toast.LENGTH_SHORT).show();
        sectionsPagerAdapter=new SectionsPagerAdapter(getFragmentManager());
        mViewPager.setAdapter(sectionsPagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);
        Utils.dismissProgressDialog();
    }

    public static class PlaceholderFragment extends Fragment{
        RecyclerView recyclerView;
        //HeightAdapterSection heightAdapterSection;
        //WidthAdapterSection widthAdapterSection;
        AdapterProduct widthAdapterProduct,heightAdapterProduct;
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


            if(getArguments().getInt("mynumber")==1) {
                widthAdapterProduct = new AdapterProduct(MultiProductsList,getContext(),R.layout.product_item_width);
                recyclerView.setAdapter(widthAdapterProduct);
            }else if(getArguments().getInt("mynumber")==2)
            {
                heightAdapterProduct = new AdapterProduct(MultiProductsList,getContext(),R.layout.product_item_height);
                recyclerView.setAdapter(heightAdapterProduct);

            }
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
