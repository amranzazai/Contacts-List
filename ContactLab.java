package android.bignerdranch.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactLab {
    private static ContactLab sContactLab;
    private List<Contact> mContacts;

    public static ContactLab get(Context context) {
        if(sContactLab == null)
            sContactLab = new ContactLab(context);
        return sContactLab;
    }

    private ContactLab(Context context) {
        mContacts = new ArrayList<>();
        Contact contact1 = new Contact();
        contact1.setTitle("John " + "555-123-4567");
        contact1.setSolved(true);
        mContacts.add(contact1);

        Contact contact2 = new Contact();
        contact2.setTitle("Mary " + "555-123-5555");
        contact2.setSolved(false);
        mContacts.add(contact2);

        Contact contact3 = new Contact();
        contact3.setTitle("Jenny " + "925-867-5309");
        contact3.setSolved(true);
        mContacts.add(contact3);

        Contact contact4 = new Contact();
        contact4.setTitle("Rick " + "555-123-1234");
        contact4.setSolved(false);
        mContacts.add(contact4);

        Contact contact5 = new Contact();
        contact5.setTitle("Tony " + "555-123-4567");
        contact5.setSolved(true);
        mContacts.add(contact5);

        Contact contact6 = new Contact();
        contact6.setTitle("Sam " + "555-123-4567");
        contact6.setSolved(false);
        mContacts.add(contact6);

        Contact contact7 = new Contact();
        contact7.setTitle("Bob " + "555-123-4567");
        contact7.setSolved(true);
        mContacts.add(contact7);

        Contact contact8 = new Contact();
        contact8.setTitle("Misha " + "555-123-4567");
        contact8.setSolved(false);
        mContacts.add(contact8);
        /*for(int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0);    // every other
            mCrimes.add(crime);
        }*/
    }

    public List<Contact> getCrimes() {
        return mContacts;
    }

    public Contact getCrime(UUID id) {
        for(Contact contact : mContacts)
            if(contact.getID().equals(id))
                return contact;

        return null;
    }
}
