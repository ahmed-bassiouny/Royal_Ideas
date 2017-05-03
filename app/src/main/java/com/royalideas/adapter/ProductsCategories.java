package com.royalideas.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.royalideas.Downloaded;
import com.royalideas.helper.Information;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ahmed on 03/05/17.
 */

public class ProductsCategories {
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("image")
    @Expose
    public String image;

    //10private Exm exm = new Exm();
    //private Type listType;
    public void getProductsCategories(Context context, Fragment fragment) {
        final Downloaded downloaded = (Downloaded)fragment;
        //listType = new TypeToken<List<ProductsCategories>>() {}.getType();
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, Information.products_categories, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        //       mTxtDisplay.setText("Response: " + response.toString());
                        Gson gson = new Gson();

                        try {
                            ArrayList<ProductsCategories> ProductsCategoriesList = gson.fromJson(response.getJSONArray("result").toString(), new TypeToken<List<ProductsCategories>>(){}.getType());
                            downloaded.ProductsCategories(ProductsCategoriesList);
                        } catch (JSONException e) {
                        }

                        //productsCategories=gson.fromJson(response.toString(),ProductsCategories[].class);
                       /* String[] b=new String[arr.length];
                        for(int i=0;i<arr.length;i++){
                            b[i]=arr[i].name;
                        }
                        callbackin.callbackCall(b);*/
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        Log.i("****", error.getLocalizedMessage());

                    }
                });
        MySingleton.getInstance(context).addToRequestQueue(jsObjRequest);
    }
}
