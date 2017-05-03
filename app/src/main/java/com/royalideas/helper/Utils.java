package com.royalideas.helper;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.royalideas.R;

/**
 * Created by ahmed on 03/05/17.
 */

public class Utils {

    public static void goToFragment(FragmentActivity fragmentActivity, Fragment fragment, @Nullable String tag, @Nullable Bundle bundle){
        FragmentManager fragmentManager = fragmentActivity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_framlayout,fragment);
        if (bundle !=null) {
            //Bundle args = new Bundle();
            //args.putString("KEY", value);
            fragment.setArguments(bundle);
        }
        if(tag !=null)
            fragmentTransaction.addToBackStack(tag);
        fragmentTransaction.commit();
    }
}
