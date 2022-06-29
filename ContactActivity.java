package android.bignerdranch.criminalintent;

import androidx.fragment.app.Fragment;

public class ContactActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new ContactFragment();
    }
}



