package com.royalideas.adapter;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.textservice.TextInfo;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.royalideas.R;
import com.royalideas.fragments.ProductFragment;
import com.royalideas.helper.Utils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ahmed on 03/05/17.
 */

public class HeightAdapterSection extends RecyclerView.Adapter<HeightAdapterSection.CutomViewHolder> {
    ArrayList<ProductsCategories> myarraylist;
    FragmentActivity fragmentActivity;
    Bundle bundle;

    public HeightAdapterSection(ArrayList<ProductsCategories> myarraylist,FragmentActivity fragmentActivity){
        this.myarraylist=myarraylist;
        this.fragmentActivity=fragmentActivity;
    }
    @Override
    public HeightAdapterSection.CutomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.height,null);
        CutomViewHolder cutomViewHolder = new CutomViewHolder(view);
        return  cutomViewHolder;
    }

    @Override
    public void onBindViewHolder(HeightAdapterSection.CutomViewHolder holder, int position) {

        holder.nameproduct.setText(myarraylist.get(position).name);
        final String id=myarraylist.get(position).id+"";
        Picasso.with(fragmentActivity).load(myarraylist.get(position).image.replace("http","https")).fit().placeholder(R.drawable.header).into(holder.imageproduct);
        holder.frame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("ID",id);
                Utils.goToFragment(fragmentActivity,new ProductFragment(),"Back To Section",bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myarraylist.size();
    }
    class CutomViewHolder extends RecyclerView.ViewHolder{
        //inner class to link java with item in layout
        TextView nameproduct;
        ImageView imageproduct;
        FrameLayout frame;
        public CutomViewHolder(View view){
            super(view);
            this.imageproduct=(ImageView)view.findViewById(R.id.imageproduct);
            this.nameproduct=(TextView)view.findViewById(R.id.nameproduct);
            this.frame=(FrameLayout)view.findViewById(R.id.frame);
        }
    }
}