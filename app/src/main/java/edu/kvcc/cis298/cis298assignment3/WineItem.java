package edu.kvcc.cis298.cis298assignment3;

/**
 * Created by ccunn on 29-Oct-16.
 */

public class WineItem {

    private int mId;
    private String mDescription;
    private String mPackSize;
    private String mCasePrice;
    private boolean mActive;


    public WineItem(int id, String description, String packSize, String casePrice, boolean active) {
        mId = id;
        mDescription = description;
        mPackSize = packSize;
        mCasePrice = casePrice;
        mActive = active;
    }


    public int getId() {
        return mId;
    }
    public void setId(int id) {
        mId = id;
    }

    public String getDescription() {
        return mDescription;
    }
    public void setDescription(String description) {
        mDescription = description;
    }

    public String getPackSize() {
        return mPackSize;
    }
    public void setPackSize(String packSize) {
        mPackSize = packSize;
    }

    public String getCasePrice() {
        return mCasePrice;
    }
    public void setCasePrice(String casePrice) {
        mCasePrice = casePrice;
    }

    public boolean isActive() {
        return mActive;
    }
    public void setActive(boolean active) {
        mActive = active;
    }
}
