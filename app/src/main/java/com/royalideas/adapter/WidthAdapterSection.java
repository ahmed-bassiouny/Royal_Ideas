package com.royalideas.adapter;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.royalideas.R;
import com.royalideas.fragments.ProductFragment;
import com.royalideas.helper.Utils;

import java.util.ArrayList;

/**
 * Created by ahmed on 03/05/17.
 */

public class WidthAdapterSection extends RecyclerView.Adapter<WidthAdapterSection.CutomViewHolder> {
    ArrayList<ProductsCategories> myarraylist;
    FragmentActivity fragmentActivity;
    Bundle bundle;
    public WidthAdapterSection(ArrayList<ProductsCategories> myarraylist,FragmentActivity fragmentActivity){
        this.myarraylist=myarraylist;
        this.fragmentActivity=fragmentActivity;
        bundle=new Bundle();
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
        final String id =myarraylist.get(position).id+"";
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
        //inner class to link java with item in layout
        TextView nameproduct;
        RelativeLayout row;
        public CutomViewHolder(View view){
            super(view);
            this.nameproduct=(TextView)view.findViewById(R.id.nameproduct);
            this.row=(RelativeLayout)view.findViewById(R.id.row);
        }
    }
}