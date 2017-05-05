package com.royalideas;

import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.widget.TextView;

import com.royalideas.fragments.SectionsFragment;
import com.royalideas.helper.Utils;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawlayoutmain;
    NavigationView navigationView;
    public static TextView titleToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init custom toolbar
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        // add custom toolbar
        setSupportActionBar(toolbar);
        // init navagitionDrawer
        drawlayoutmain=(DrawerLayout)findViewById(R.id.drawlayoutmain);
        navigationView= (NavigationView) findViewById(R.id.navigation);
        titleToolbar=(TextView)toolbar.findViewById(R.id.title);
        navigationView.setItemIconTintList(null);
        ButterKnife.bind(this);
        Utils.goToFragment(this,new SectionsFragment(),null,null);
    }

    @OnClick(R.id.menu)
    public void menu(){
        drawlayoutmain.openDrawer(Gravity.START);
    }
}
