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
import java.util.List;

/**
 * Created by ahmed on 04/05/17.
 */

public class Product {
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("image")
    @Expose
    public String image;
    @SerializedName("t1")
    @Expose
    public String t1;
    @SerializedName("t2")
    @Expose
    public String t2;
    @SerializedName("video")
    @Expose
    public Object video;
    @SerializedName("status")
    @Expose
    public String status;

    public void getMultiProducts(Context context, Fragment fragment) {
        //final Downloaded downloaded = (Downloaded)fragment;
        //listType = new TypeToken<List<ProductsCategories>>() {}.getType();
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, Information.MultiProducts, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Gson gson = new Gson();

                        try {
                            ArrayList<Product> MultiProductsList = gson.fromJson(response.getJSONObject("result").getJSONArray("data").toString(), new TypeToken<ArrayList<Product>>(){}.getType());
                            Log.i("ahmed", MultiProductsList.get(0).id+"");
                        } catch (JSONException e) {
                            Log.i("error log", e.getMessage());
                        }
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
