package com.royalideas.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.royalideas.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ahmed on 03/05/17.
 */

public class WidthAdapterSection extends RecyclerView.Adapter<WidthAdapterSection.CutomViewHolder> {
    ArrayList<ProductsCategories> myarraylist;
    Context context;
    // constructor to send data and set it global
    public WidthAdapterSection(ArrayList<ProductsCategories> myarraylist,Context context){
        this.myarraylist=myarraylist;
        this.context=context;
    }
    @Override
    public WidthAdapterSection.CutomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.width,null);
        WidthAdapterSection.CutomViewHolder cutomViewHolder = new WidthAdapterSection.CutomViewHolder(view);
        return  cutomViewHolder;
    }

    @Override
    public void onBindViewHolder(WidthAdapterSection.CutomViewHolder holder, int position) {

        holder.nameproduct.setText(myarraylist.get(position).name);
    }

    @Override
    public int getItemCount() {
        return myarraylist.size();
    }
    class CutomViewHolder extends RecyclerView.ViewHolder{
        //inner class to link java with item in layout
        TextView nameproduct;
        public CutomViewHolder(View view){
            super(view);
            this.nameproduct=(TextView)view.findViewById(R.id.nameproduct);
        }
    }
}