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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ahmed on 04/05/17.
 */

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.CutomViewHolder> {
    ArrayList<Product> MultiProductsList;
    Context context;
    int layout;
    public AdapterProduct(ArrayList<Product> MultiProductsList, Context context, int layout){
        this.MultiProductsList=MultiProductsList;
        this.context=context;
        this.layout=layout;
    }
    @Override
    public AdapterProduct.CutomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(layout,null);
        AdapterProduct.CutomViewHolder cutomViewHolder = new AdapterProduct.CutomViewHolder(view);
        return  cutomViewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterProduct.CutomViewHolder holder, int position) {

        holder.nameproduct.setText(MultiProductsList.get(position).title);
        holder.codeproduct.setText(MultiProductsList.get(position).t2+"كود المنتج");
        if(MultiProductsList.get(position).status.equals("نعم"))
        holder.status.setText("متاح");
        holder.qar.setText("QAR - "+MultiProductsList.get(position).t1);
        Picasso.with(context).load(MultiProductsList.get(position).image.replace("http","https")).fit().placeholder(R.drawable.header).into(holder.imageproduct);

    }

    @Override
    public int getItemCount() {
        return MultiProductsList.size();
    }
    class CutomViewHolder extends RecyclerView.ViewHolder{
        TextView nameproduct,codeproduct,qar;
        ImageView imageproduct;
        Button status;
        public CutomViewHolder(View view){
            super(view);
            this.nameproduct=(TextView)view.findViewById(R.id.nameproduct);
            this.codeproduct=(TextView)view.findViewById(R.id.codeproduct);
            this.imageproduct=(ImageView)view.findViewById(R.id.imageproduct);
            this.qar=(TextView)view.findViewById(R.id.qar);
            this.status=(Button)view.findViewById(R.id.status);
        }
    }
}
