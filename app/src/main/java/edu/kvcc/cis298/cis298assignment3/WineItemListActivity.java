package edu.kvcc.cis298.cis298assignment3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Created by ccunn on 29-Oct-16.
 */

public class WineItemListActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        // >Get the fragment manager.
        FragmentManager fm = getSupportFragmentManager();
        // >Get the fragment from the layout.
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        // >When the app starts, there is no fragment in the layout so it will be null.
        // >So we need to add it.
        if(fragment == null) {
            fragment = new WineItemListFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }


}
