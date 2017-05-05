package com.royalideas;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.TextView;

import com.royalideas.fragments.AboutUsFragment;
import com.royalideas.fragments.BranchFragment;
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
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.main:
                        Utils.goToFragment(MainActivity.this,new SectionsFragment(),null,null);
                        break;
                    case R.id.about:
                        Utils.goToFragment(MainActivity.this,new AboutUsFragment(),"Back To Sections",null);
                        break;
                    case R.id.branch:
                        Utils.goToFragment(MainActivity.this,new BranchFragment(),"Back To Sections",null);
                        break;
                }
                item.setCheckable(true);
                drawlayoutmain.closeDrawers();
                return true;
            }
        });
    }

    @OnClick(R.id.menu)
    public void menu(){
        drawlayoutmain.openDrawer(Gravity.START);
    }
}
