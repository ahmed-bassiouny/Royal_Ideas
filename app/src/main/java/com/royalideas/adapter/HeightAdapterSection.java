package com.royalideas.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.textservice.TextInfo;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.royalideas.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ahmed on 03/05/17.
 */

public class HeightAdapterSection extends RecyclerView.Adapter<HeightAdapterSection.CutomViewHolder> {
    ArrayList<ProductsCategories> myarraylist;
    Context context;
    // constructor to send data and set it global
    public HeightAdapterSection(ArrayList<ProductsCategories> myarraylist,Context context){
        this.myarraylist=myarraylist;
        this.context=context;
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
        Picasso.with(context).load(myarraylist.get(position).image.replace("http","https")).fit().placeholder(R.drawable.header).into(holder.imageproduct);
    }

    @Override
    public int getItemCount() {
        return myarraylist.size();
    }
    class CutomViewHolder extends RecyclerView.ViewHolder{
        //inner class to link java with item in layout
        TextView nameproduct;
        ImageView imageproduct;
        public CutomViewHolder(View view){
            super(view);
            this.imageproduct=(ImageView)view.findViewById(R.id.imageproduct);
            this.nameproduct=(TextView)view.findViewById(R.id.nameproduct);
        }
    }
}