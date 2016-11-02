package edu.kvcc.cis298.cis298assignment3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.UUID;

/**
 * Created by ccunn on 01-Nov-16.
 */

public class WineItemFragment extends Fragment {

    // >Used to store and get the wine item id used by this fragment.
    private static final String ARG_WINE_ITEM_ID = "wine_item_id";

    private WineItem mWineItem;// >The item that this fragment uses.
    // >Widgets for the wine item's data.
    private EditText mDescriptionField;
    private EditText mIdField;
    private EditText mPackField;
    private EditText mPriceField;
    private CheckBox mActiveCheckbox;


    // >Make a WineItemFragment that uses the passed in id.
    public static WineItemFragment newInstance(String wineItemId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_WINE_ITEM_ID, wineItemId);

        WineItemFragment fragment = new WineItemFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // >Get this fragment's wine item id from the fragment's arguments.
        String wineItemId = (String) getArguments().getSerializable(ARG_WINE_ITEM_ID);
        // >Get a WineItem from the collection using the id from the fragment's arguments.
        mWineItem = WineItemCollection.get(getActivity()).getWineItem(wineItemId);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // >Inflate the layout file for this fragment.
        View v = inflater.inflate(R.layout.fragment_wine_item, container, false);

        // >Bind the layout controls to the widget objects and set them to the wine item.
        mDescriptionField = (EditText) v.findViewById(R.id.wine_item_description);
        mDescriptionField.setText(mWineItem.getDescription());
        mIdField = (EditText) v.findViewById(R.id.wine_item_id);
        mIdField.setText(mWineItem.getId());
        mPackField = (EditText) v.findViewById(R.id.wine_item_pack_size);
        mPackField.setText(mWineItem.getPackSize());
        mPriceField = (EditText) v.findViewById(R.id.wine_item_case_price);
        mPriceField.setText(mWineItem.getCasePrice());
        mActiveCheckbox = (CheckBox) v.findViewById(R.id.wine_item_active);
        mActiveCheckbox.setChecked(mWineItem.isActive());

        return v;
    }
}
