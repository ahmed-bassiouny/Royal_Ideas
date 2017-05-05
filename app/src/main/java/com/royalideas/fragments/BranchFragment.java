package com.royalideas.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.royalideas.R;
import com.royalideas.adapter.AdapterBranch;
import com.royalideas.adapter.Branch;
import com.royalideas.adapter.MySingleton;
import com.royalideas.helper.Information;
import com.royalideas.helper.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class BranchFragment extends Fragment {
    @BindView(R.id.list)
    RecyclerView list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_branch, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        list.setHasFixedSize(true);
    }

    @Override
    public void onStart() {
        super.onStart();
        Utils.runProgressDialog(getActivity());
        getBranches();
    }

    private void getBranches(){
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, Information.Branch, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Gson gson = new Gson();
                        try {
                            ArrayList<Branch> branches =gson.fromJson(response.getJSONObject("info").getJSONArray("b1").toString(),new TypeToken<List<Branch>>(){}.getType());
                            AdapterBranch adapterBranch = new AdapterBranch(branches,getActivity());
                            list.setAdapter(adapterBranch);
                            Utils.dismissProgressDialog();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("a**a*a", error.getLocalizedMessage());
                    }
                });
        MySingleton.getInstance(getActivity()).addToRequestQueue(jsObjRequest);
    }

}
