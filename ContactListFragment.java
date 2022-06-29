package android.bignerdranch.criminalintent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactListFragment extends Fragment {
    // We just added stuff...
    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(
            R.layout.fragment_crime_list, container, false);

        mCrimeRecyclerView = (RecyclerView)view.findViewById(
            R.id.crime_recycler_view);
        mCrimeRecyclerView.setLayoutManager(
            new LinearLayoutManager(getActivity()));

        updateUI(); // fixed now!

        return view;
    }

    public void updateUI() {
        ContactLab contactLab = ContactLab.get(getActivity());
        List<Contact> contacts = contactLab.getCrimes();
        mAdapter = new CrimeAdapter(contacts);
        mCrimeRecyclerView.setAdapter(mAdapter);
    }

    // defined as an inner class in class CrimeListFragment
    private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTitleTextView;
        private Contact mContact;

        public CrimeHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_crime, parent, false));
            mTitleTextView = (TextView)itemView.findViewById(R.id.crime_title);
            itemView.setOnClickListener(this);
        }

        public void bind(Contact contact) {
            mContact = contact;
            mTitleTextView.setText(mContact.getTitle());
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(), mContact.getTitle() + " clicked!",
                    Toast.LENGTH_SHORT).show();
        }
    }

    // the adapter, also an inner class in class CrimeListFragment,
    // requires 3 overrides
    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {
        private List<Contact> mContacts;

        public CrimeAdapter(List<Contact> contacts) {
            mContacts = contacts;
        }

        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new CrimeHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(CrimeHolder holder, int position) {
            // now it's used!
            Contact contact = mContacts.get(position);
            holder.bind(contact);
        }

        @Override
        public int getItemCount() {
            return mContacts.size();
        }
    }
}

