package edu.kvcc.cis298.cis298assignment3;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/**
 * Created by ccunn on 01-Nov-16.
 */

public class WineItemCollection {

    private static WineItemCollection sWineItemCollection;
    private List<WineItem> mWineItems;
    private Context mContext;

    public static WineItemCollection get(Context context) {
        // >Create a new instance if there is not one already.
        if (sWineItemCollection == null) {
            sWineItemCollection = new WineItemCollection(context);
        }

        return sWineItemCollection;
    }

    private WineItemCollection(Context context) {
        mWineItems = new ArrayList<>();

        mContext = context;

        // >Get the list from the csv.
        loadWineList();
    }

    public List<WineItem> getWineItems() {
        return mWineItems;
    }

    public WineItem getWineItem(String id) {
        for (WineItem item : mWineItems) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        // >Return null if the item was not found.
        return null;
    }

    private void loadWineList() {
        Scanner scanner = null;
        try {
            // >Set the scanner to use the csv file.
            scanner = new Scanner(mContext.getResources().openRawResource(R.raw.beverage_list));

            String line = "";// >Will hold each individual line of the csv.
            // >Look at every line in the csv.
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();

                // >Make an array to hold each part of the line.
                String parts[] = line.split(",");

                // >Turn the parts into the data types needed.
                Boolean active = (parts[4].equals("True"));

                // >Add new item to the list.
                mWineItems.add(new WineItem(parts[0], parts[1], parts[2], parts[3], active));
            }
        } catch (Exception e) {
            Log.e("Error reading csv", e.toString());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
