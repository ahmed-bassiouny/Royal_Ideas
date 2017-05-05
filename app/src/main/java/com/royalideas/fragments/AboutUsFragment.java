package com.royalideas.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.royalideas.Downloaded;
import com.royalideas.R;
import com.royalideas.adapter.MySingleton;
import com.royalideas.adapter.Product;
import com.royalideas.helper.Information;
import com.royalideas.helper.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutUsFragment extends Fragment {
    @BindView(R.id.aboutcontent)
    TextView aboutcontent;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_about_us, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Utils.runProgressDialog(getContext());
        getcontent();
    }

    public void getcontent() {
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, Information.AboutUs, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            aboutcontent.setText(response.getJSONArray("result").getJSONObject(0).getString("content").toString());
                            Utils.dismissProgressDialog();
                        } catch (JSONException e) {
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
        MySingleton.getInstance(getActivity()).addToRequestQueue(jsObjRequest);
    }
}
