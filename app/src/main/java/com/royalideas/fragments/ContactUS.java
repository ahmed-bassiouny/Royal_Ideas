package com.royalideas.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.royalideas.MainActivity;
import com.royalideas.R;
import com.royalideas.adapter.MySingleton;
import com.royalideas.helper.Information;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactUS extends Fragment {

    @BindViews({R.id.name,R.id.email,R.id.subject,R.id.message})
    EditText[] editTexts;
    boolean success=true;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_contact_u, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        MainActivity.titleToolbar.setText(getResources().getString(R.string.contactus));
    }
    @OnClick(R.id.send)
    public void send(){
        for(EditText item : editTexts){
            if(item.getText().toString().trim().isEmpty())
                item.setError("برجاء إدخال البيانات");
            else
                sendData();
        }
    }

    private void sendData(){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Information.ContactUs, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.toString().equals("success")&&success){
                    Toast.makeText(getActivity(), " Thanks ", Toast.LENGTH_SHORT).show();
                    success=false;
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("*a*a*a", error.getLocalizedMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hashMap= new HashMap<String,String>();
                hashMap.put("name",editTexts[0].getText().toString());
                hashMap.put("email",editTexts[1].getText().toString());
                hashMap.put("subject",editTexts[2].getText().toString());
                hashMap.put("message",editTexts[3].getText().toString());
                return hashMap;
            }
        };
        MySingleton.getInstance(getActivity()).addToRequestQueue(stringRequest);
    }

}
