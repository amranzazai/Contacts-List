package android.bignerdranch.criminalintent;

import java.util.Date;
import java.util.UUID;

public class Contact {
    private UUID mId;       // holds the crime id
    private String mTitle;  // the title of the crime

    private boolean mSolved;// is the crime solved?

    public Contact() {
        mId = UUID.randomUUID();
    }

    public UUID getID() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }
}

