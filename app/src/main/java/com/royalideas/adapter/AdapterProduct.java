package com.royalideas.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.royalideas.R;
import com.royalideas.fragments.OneProductFragment;
import com.royalideas.helper.Utils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ahmed on 04/05/17.
 */

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.CutomViewHolder> {
    ArrayList<Product> MultiProductsList;
    FragmentActivity fragmentActivity;
    int layout;
    Bundle bundle;
    public AdapterProduct(ArrayList<Product> MultiProductsList, FragmentActivity fragmentActivity, int layout){
        this.MultiProductsList=MultiProductsList;
        this.fragmentActivity=fragmentActivity;
        this.layout=layout;
        bundle=new Bundle();
    }
    @Override
    public AdapterProduct.CutomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(layout,null);
        AdapterProduct.CutomViewHolder cutomViewHolder = new AdapterProduct.CutomViewHolder(view);
        return  cutomViewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterProduct.CutomViewHolder holder, int position) {
        final Product product=MultiProductsList.get(position);
        holder.nameproduct.setText(MultiProductsList.get(position).title);
        holder.codeproduct.setText(MultiProductsList.get(position).t2+"كود المنتج");
        if(MultiProductsList.get(position).status.equals("نعم"))
        holder.status.setText("متاح");
        if(MultiProductsList.get(position).t1.equals("حسب الطلب"))
            holder.qar.setText(MultiProductsList.get(position).t1);
        else
            holder.qar.setText("QAR - "+MultiProductsList.get(position).t1);
        if(layout==R.layout.product_item_height)
            Picasso.with(fragmentActivity).load(MultiProductsList.get(position).image.replace("http","https")).resize(1000,1000).placeholder(R.drawable.animation).into(holder.imageproduct);
        else
            Picasso.with(fragmentActivity).load(MultiProductsList.get(position).image.replace("http","https")).resize(350,600).placeholder(R.drawable.animation).into(holder.imageproduct);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putSerializable("product",product);
                Utils.goToFragment(fragmentActivity,new OneProductFragment(),"Back to Products",bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return MultiProductsList.size();
    }
    class CutomViewHolder extends RecyclerView.ViewHolder{
        TextView nameproduct,codeproduct,qar;
        ImageView imageproduct;
        Button status;
        CardView cardView;
        public CutomViewHolder(View view){
            super(view);
            this.nameproduct=(TextView)view.findViewById(R.id.nameproduct);
            this.codeproduct=(TextView)view.findViewById(R.id.codeproduct);
            this.imageproduct=(ImageView)view.findViewById(R.id.imageproduct);
            this.qar=(TextView)view.findViewById(R.id.qar);
            this.status=(Button)view.findViewById(R.id.status);
            this.cardView=(CardView)view.findViewById(R.id.card_view);
        }
    }
}
