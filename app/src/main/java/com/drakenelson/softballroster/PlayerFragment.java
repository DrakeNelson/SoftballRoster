package com.drakenelson.softballroster;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.Date;
import java.util.UUID;

public class PlayerFragment extends Fragment {

    private static final String ARG_CRIME_ID = "crime_id";
    private static final String DIALOG_DATE = "DialogDate";

    private static final int REQUEST_DATE = 0;

    private Player mCrime;
    private EditText jersyNumberField,firstNameField,lastNameField;
    private Button mDateButton;
    private CheckBox isPitcherBox,isCatcherBox,isInfieldBox,isOutfieldBox;

    public static PlayerFragment newInstance(UUID crimeId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_CRIME_ID, crimeId);

        PlayerFragment fragment = new PlayerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID crimeId = (UUID) getArguments().getSerializable(ARG_CRIME_ID);
        mCrime = Roster.get(getActivity()).getCrime(crimeId);
    }
    @Override
    public void onPause() {
        super.onPause();

        Roster.get(getActivity())
                .updateCrime(mCrime);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime, container, false);


        jersyNumberField = (EditText) v.findViewById(R.id.jersy_Number);
        jersyNumberField.setText(mCrime.getNumber());
        jersyNumberField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setNumber(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        firstNameField = (EditText) v.findViewById(R.id.firstName);
        firstNameField.setText(mCrime.getFirstName());
        firstNameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setFirstName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        lastNameField = (EditText) v.findViewById(R.id.lastName);
        lastNameField.setText(mCrime.getLastName());
        lastNameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setLastName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mDateButton = (Button) v.findViewById(R.id.crime_date);
        updateDate();

        mDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                DatePickerFragment dialog = DatePickerFragment.newInstance(mCrime.getLastUpdate());
                dialog.setTargetFragment(PlayerFragment.this, REQUEST_DATE);
                dialog.show(manager, DIALOG_DATE);

            }
        });

        isPitcherBox = (CheckBox) v.findViewById(R.id.pitcher_check);
        isPitcherBox.setChecked(mCrime.isPitcher());
        isPitcherBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setPitcher(isChecked);
            }
        });
        isCatcherBox = (CheckBox) v.findViewById(R.id.catcher_check);
        isCatcherBox.setChecked(mCrime.isCatcher());
        isCatcherBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setCatcher(isChecked);
            }
        });
        isInfieldBox = (CheckBox) v.findViewById(R.id.infield_check);
        isInfieldBox.setChecked(mCrime.isInfield());
        isInfieldBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setInfield(isChecked);
            }
        });
        isOutfieldBox = (CheckBox) v.findViewById(R.id.outfield_check);
        isOutfieldBox.setChecked(mCrime.isOutfield());
        isOutfieldBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setOutField(isChecked);
            }
        });

        return v;
    }
    @Override
    public void onActivityResult(int requestCode,int resultCode, Intent data){
        if (resultCode != Activity.RESULT_OK) {

            return;
        }
        if (requestCode == REQUEST_DATE) {
            Date date = (Date) data.getSerializableExtra(DatePickerFragment.EXTRA_DATE);
            mCrime.setLastUpdate(date);
            updateDate();
        }
    }
    private void updateDate() {
        mDateButton.setText(mCrime.getLastUpdate().toString());
    }
}
