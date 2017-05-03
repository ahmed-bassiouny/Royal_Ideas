package com.royalideas;

import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawlayoutmain;
    NavigationView navigationView;
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
        navigationView.setItemIconTintList(null);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.menu)
    public void menu(){
        drawlayoutmain.openDrawer(View.TEXT_ALIGNMENT_VIEW_START);
    }
}
