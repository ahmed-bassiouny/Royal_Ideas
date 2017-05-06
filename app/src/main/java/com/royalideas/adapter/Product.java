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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ahmed on 04/05/17.
 */

public class Product implements Serializable {
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

    public void getMultiProducts(Context context, Fragment fragment,String id) {
        final Downloaded downloaded = (Downloaded) fragment;
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, Information.MultiProducts+id, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Gson gson = new Gson();
                        ArrayList<Product> MultiProductsList=new ArrayList<>();
                        try {
                             MultiProductsList = gson.fromJson(response.getJSONObject("result").getJSONArray("data").toString(), new TypeToken<ArrayList<Product>>() {
                            }.getType());
                        } catch (JSONException e) {
                            Log.i("error log", e.getMessage());
                        }
                        downloaded.MultiProducts(MultiProductsList);
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
