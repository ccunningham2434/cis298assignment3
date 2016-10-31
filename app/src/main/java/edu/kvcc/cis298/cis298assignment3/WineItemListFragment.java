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

/**
 * Created by ccunn on 29-Oct-16.
 */

public class WineItemListFragment extends Fragment {

    private RecyclerView mWineRecyclerView;
    private WineItemAdapter mWineItemAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // >Inflate the list view into a new view object.
        View view = inflater.inflate(R.layout.fragment_wine_list, container, false);

        mWineRecyclerView = (RecyclerView) view.findViewById(R.id.wine_recycler_view);

        // >Set the recycler view to use a new linear layout manager.
        mWineRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // >Update the list before rendering it.
        updateUI();

        return view;
    }


    private class WineItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
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

            mId.setText(mWineItem.getId());
            mDescription.setText(mWineItem.getDescription());
            mCasePrice.setText(mWineItem.getCasePrice());
        }

        @Override
        public void onClick(View v) {
            Intent intent = WinePagerActivity.newIntent(getActivity(), mWineItem.getId());
            startActivity(intent);
        }
    }







}
