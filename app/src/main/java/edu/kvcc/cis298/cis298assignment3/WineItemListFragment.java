package edu.kvcc.cis298.cis298assignment3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ccunn on 29-Oct-16.
 */

public class WineItemListFragment extends Fragment {

    private RecyclerView mWineRecyclerView;
    private WineAdapter mWineAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // >Inflate the list view into a new view object.
        View view = inflater.inflate(R.layout.fragment_wine_list, container, false);
        // >Get the recycler view.
        mWineRecyclerView = (RecyclerView) view.findViewById(R.id.wine_recycler_view);
        // >Set the recycler view to use a new linear layout manager.
        mWineRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // >Update the list before rendering it.
        updateUI();

        return view;
    }


    private class WineItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // >Widget's to display the wine item's data.
        private TextView mId;
        private TextView mDescription;
        private TextView mPackSize;
        private TextView mCasePrice;
        private CheckBox mActiveCheckbox;

        private WineItem mWineItem;// >The wine item to display.

        // >Constructor
        public WineItemHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            // >Assign the view controls to their widget objects.
            mId = (TextView) itemView.findViewById(R.id.list_item_wine_id);
            mDescription = (TextView) itemView.findViewById(R.id.list_item_wine_description);
            mCasePrice = (TextView) itemView.findViewById(R.id.list_item_wine_price);
        }

        // >Setup this class to use a wine item.
        public void bindWineItem(WineItem wineItem) {
            mWineItem = wineItem;

            mId.setText(mWineItem.getId().toString());
            mDescription.setText(mWineItem.getDescription());
            mCasePrice.setText(mWineItem.getCasePrice());
        }

        @Override
        public void onClick(View v) {
            Intent intent = WineItemPagerActivity.newIntent(getActivity(), mWineItem.getId());
            startActivity(intent);
        }
    }


    private class WineAdapter extends RecyclerView.Adapter<WineItemHolder> {
        private List<WineItem> mWineItems;// >Holds the wine items.


        // >Constructor
        public WineAdapter(List<WineItem> wineItems) {
            mWineItems = wineItems;
        }

        @Override
        public WineItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // >Get a reference to the layout inflater.
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            // >Inflate the view.
            View view = layoutInflater.inflate(R.layout.list_item_wine_item, parent, false);

            return new WineItemHolder(view);
        }

        @Override
        public void onBindViewHolder(WineItemHolder holder, int position) {
            // >Get an item from the list and bind it to the holder.
            WineItem wineItem = mWineItems.get(position);
            holder.bindWineItem(wineItem);
        }

        @Override
        public int getItemCount() {
            return mWineItems.size();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        // >Update the UI when returning from a detail view.
        updateUI();
    }

    // >
    private void updateUI() {
        // >Get the singleton collection.
        WineItemCollection wineItemCollection = WineItemCollection.get(getActivity());
        // >Set the local list to the singleton list.
        List<WineItem> wineItems = wineItemCollection.getWineItems();

        if (mWineAdapter == null) {
            // >Create a new adapter using the list of wine items.
            mWineAdapter = new WineAdapter(wineItems);
            // >Set the recycler's adapter.
            mWineRecyclerView.setAdapter(mWineAdapter);
        } else {
            // >Notify the adapter that is should reload the data.
            mWineAdapter.notifyDataSetChanged();
        }
    }


}
