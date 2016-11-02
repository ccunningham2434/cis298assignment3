package edu.kvcc.cis298.cis298assignment3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;
import java.util.UUID;

/**
 * Created by ccunn on 01-Nov-16.
 */

public class WineItemPagerActivity extends FragmentActivity {

    private static final String EXTRA_WINE_ID = "edu.kvcc.cis298.cis298assignment3.wine_id";

    public static Intent newIntent(Context packageContext, String wineItemId) {
        Intent intent = new Intent(packageContext, WineItemPagerActivity.class);
        intent.putExtra(EXTRA_WINE_ID, wineItemId);
        return intent;
    }

    private ViewPager mViewPager;
    private List<WineItem> mWineItems;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine_pager);

        String wineItemId = (String) getIntent().getSerializableExtra(EXTRA_WINE_ID);

        mViewPager = (ViewPager) findViewById(R.id.activity_wine_item_pager_view_pager);
        // >Get the items from the singleton collection.
        mWineItems = WineItemCollection.get(this).getWineItems();
        // >Get the fragment manager.
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                // >Get the wine item to be displayed.
                WineItem wineItem = mWineItems.get(position);
                return WineItemFragment.newInstance(wineItem.getId());
            }

            @Override
            public int getCount() {
                return mWineItems.size();
            }
        });

        // >Set the pager's current item.
        for (int i = 0; i < mWineItems.size(); i++) {
            if (mWineItems.get(i).getId().equals(wineItemId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
