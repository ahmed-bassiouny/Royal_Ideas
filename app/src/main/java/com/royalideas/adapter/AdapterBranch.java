package com.royalideas.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
 * Created by ahmed on 05/05/17.
 */

public class AdapterBranch extends RecyclerView.Adapter<AdapterBranch.CutomViewHolder> {
    ArrayList<Branch> branches;
    Context context;

    public AdapterBranch(ArrayList<Branch> branches, Context context){
        this.branches=branches;
        this.context=context;
    }
    @Override
    public AdapterBranch.CutomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.branch_item,null);
        AdapterBranch.CutomViewHolder cutomViewHolder = new AdapterBranch.CutomViewHolder(view);
        return  cutomViewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterBranch.CutomViewHolder holder, final int position) {
        holder.namebranch.setText(branches.get(position).b11);
        holder.mapbranch.setText(branches.get(position).b12);
        holder.phonebranch.setText(branches.get(position).b13);
        holder.emailbranch.setText(branches.get(position).b14);
        final String uri=branches.get(position).b15;
        holder.bigmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return branches.size();
    }
    class CutomViewHolder extends RecyclerView.ViewHolder{
        TextView namebranch,mapbranch,phonebranch,emailbranch;
        ImageView bigmap;

        public CutomViewHolder(View view){
            super(view);
            this.namebranch=(TextView)view.findViewById(R.id.namebranch);
            this.mapbranch=(TextView)view.findViewById(R.id.mapbranch);
            this.phonebranch=(TextView)view.findViewById(R.id.phonebranch);
            this.emailbranch=(TextView)view.findViewById(R.id.emailbranch);
            this.bigmap=(ImageView)view.findViewById(R.id.bigmap);

        }
    }
}
