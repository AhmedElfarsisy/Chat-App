package com.eng.elfarsisy.who.myui.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.eng.elfarsisy.who.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {


    EditText RegisterName;
    EditText RegisterEmail;
    EditText RegisterPassword;
    EditText RegisterPassword2;
    EditText RegisterPhone;
    Button RegisterButton;
    ProgressBar RegisterprogressBar;
    TextView registerTex;

    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    StorageReference storageReference;
    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);


        return view;
    }

}
