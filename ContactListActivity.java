package android.bignerdranch.criminalintent;

import androidx.fragment.app.Fragment;

public class ContactListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new ContactListFragment();
    }
}

