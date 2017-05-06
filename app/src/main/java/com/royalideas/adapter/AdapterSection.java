package com.royalideas.adapter;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.royalideas.R;
import com.royalideas.fragments.ProductFragment;
import com.royalideas.helper.Utils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ahmed on 03/05/17.
 */

public class AdapterSection extends RecyclerView.Adapter<AdapterSection.CutomViewHolder> {
    ArrayList<ProductsCategories> myarraylist;
    FragmentActivity fragmentActivity;
    Bundle bundle;
    int layout;
    public AdapterSection(ArrayList<ProductsCategories> myarraylist, FragmentActivity fragmentActivity, int layout){
        this.myarraylist=myarraylist;
        this.fragmentActivity=fragmentActivity;
        bundle=new Bundle();
        this.layout=layout;
    }
    @Override
    public AdapterSection.CutomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(layout,null);
        AdapterSection.CutomViewHolder cutomViewHolder = new AdapterSection.CutomViewHolder(view);
        return  cutomViewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterSection.CutomViewHolder holder, int position) {

        holder.nameproduct.setText(myarraylist.get(position).name);
        final String id =myarraylist.get(position).id+"";
        if(layout==R.layout.height)
        Picasso.with(fragmentActivity).load(myarraylist.get(position).image.replace("http","https")).resize(1000,1000).placeholder(R.drawable.animation).into(holder.imageproduct);
        holder.row.setOnClickListener(new View.OnClickListener() {
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
        TextView nameproduct;
        ImageView imageproduct;
        FrameLayout row;
        public CutomViewHolder(View view){
            super(view);
            this.nameproduct=(TextView)view.findViewById(R.id.nameproduct);
            this.row=(FrameLayout)view.findViewById(R.id.row);
            this.imageproduct=(ImageView)view.findViewById(R.id.imageproduct);
        }
    }
}