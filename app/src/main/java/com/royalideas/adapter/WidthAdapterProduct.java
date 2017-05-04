package com.royalideas.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.royalideas.R;

import java.util.ArrayList;

/**
 * Created by ahmed on 04/05/17.
 */

public class WidthAdapterProduct extends RecyclerView.Adapter<WidthAdapterProduct.CutomViewHolder> {
    ArrayList<String> myarraylist;
    Context context;

    public WidthAdapterProduct(ArrayList<String> myarraylist,Context context){
        this.myarraylist=myarraylist;
        this.context=context;
    }
    @Override
    public WidthAdapterProduct.CutomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item_width,null);
        WidthAdapterProduct.CutomViewHolder cutomViewHolder = new WidthAdapterProduct.CutomViewHolder(view);
        return  cutomViewHolder;
    }

    @Override
    public void onBindViewHolder(WidthAdapterProduct.CutomViewHolder holder, int position) {

        holder.nameproduct.setText(myarraylist.get(position));
        holder.codeproduct.setText(myarraylist.get(position));
        holder.status.setText(myarraylist.get(position));
        holder.qar.setText(myarraylist.get(position));
    }

    @Override
    public int getItemCount() {
        return myarraylist.size();
    }
    class CutomViewHolder extends RecyclerView.ViewHolder{
        TextView nameproduct,codeproduct;
        ImageView imageproduct;
        Button qar,status;
        public CutomViewHolder(View view){
            super(view);
            this.nameproduct=(TextView)view.findViewById(R.id.nameproduct);
            this.codeproduct=(TextView)view.findViewById(R.id.codeproduct);
            this.imageproduct=(ImageView)view.findViewById(R.id.imageproduct);
            this.qar=(Button)view.findViewById(R.id.qar);
            this.status=(Button)view.findViewById(R.id.status);
        }
    }
}
