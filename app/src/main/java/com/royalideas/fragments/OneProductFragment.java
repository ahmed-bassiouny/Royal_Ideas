package com.royalideas.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.royalideas.R;
import com.royalideas.adapter.Product;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class OneProductFragment extends Fragment {

    @BindViews({ R.id.status, R.id.qar, R.id.nameproduct, R.id.codeproduct })
    TextView[] textViews;
    @BindView(R.id.imageproduct)
    ImageView imageproduct;
    Product product=new Product();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_one_product, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        product= (Product) getArguments().getSerializable("product");
    }

    @Override
    public void onStart() {
        super.onStart();
        textViews[0].setText(product.status);
        textViews[1].setText(product.t1);
        textViews[2].setText(product.title);
        textViews[3].setText(product.t2);
        Picasso.with(getActivity()).load(product.image.replace("http","https")).fit().placeholder(R.drawable.animation).into(imageproduct);

    }
}
