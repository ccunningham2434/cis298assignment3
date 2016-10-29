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

        FragmentManager fm = getSupportFragmentManager();

        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if(fragment == null) {
            fragment = new WineItemListFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }


}
