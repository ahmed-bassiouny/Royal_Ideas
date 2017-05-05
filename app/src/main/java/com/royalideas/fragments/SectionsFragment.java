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

import com.royalideas.Downloaded;
import com.royalideas.MainActivity;
import com.royalideas.R;
import com.royalideas.adapter.Product;
import com.royalideas.adapter.ProductsCategories;
import com.royalideas.adapter.AdapterSection;
import com.royalideas.adapter.SectionsPagerAdapter;
import com.royalideas.helper.Utils;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SectionsFragment extends Fragment implements Downloaded {

    ViewPager mViewPager;
    TabLayout tabLayout;
    SectionsPagerAdapter sectionsPagerAdapter;

    static ArrayList<ProductsCategories> ProductsCategoriesList=new ArrayList<>();
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
    public void onStart() {
        super.onStart();
        Utils.runProgressDialog(getActivity());
        ProductsCategories productsCategories = new ProductsCategories();
        productsCategories.getProductsCategories(getActivity(),this);
        MainActivity.titleToolbar.setText(getResources().getString(R.string.Main));
    }

    @Override
    public void ProductsCategories(ArrayList<ProductsCategories> ProductsCategoriesList) {
        this.ProductsCategoriesList=ProductsCategoriesList;
        sectionsPagerAdapter=new SectionsPagerAdapter(getChildFragmentManager(),getContext(),true);
        mViewPager.setAdapter(sectionsPagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);
        Utils.dismissProgressDialog();

    }

    @Override
    public void MultiProducts(ArrayList<Product> MultiProductsList) {

    }


    public static class PlaceholderFragment extends Fragment{
        RecyclerView recyclerView;
        AdapterSection widthAdapterSection,heightAdapterSection;
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
            if(getArguments().getInt("mynumber")==1)
            {
                widthAdapterSection = new AdapterSection(ProductsCategoriesList,getActivity(),R.layout.width);
                recyclerView.setAdapter(widthAdapterSection);
            }else if(getArguments().getInt("mynumber")==2) {
                heightAdapterSection = new AdapterSection(ProductsCategoriesList,getActivity(),R.layout.height);
                recyclerView.setAdapter(heightAdapterSection);
            }
        return rootView;
        }

    }

}
