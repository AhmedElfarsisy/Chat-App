package com.eng.elfarsisy.who.myui.fragment;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.eng.elfarsisy.who.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends Fragment {


    @BindView(R.id.fsignin_email)
    EditText fsigninEmail;
    @BindView(R.id.fsignin_password)
    EditText fsigninPassword;
    @BindView(R.id.fsignin_button)
    Button fsigninButton;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.textViewt)
    TextView textViewt;
    @BindView(R.id.fsignin_register)
    TextView fsigninRegister;
    FirebaseAuth firebaseAuth;

    public SignInFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        firebaseAuth = FirebaseAuth.getInstance();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }

    @OnClick({R.id.fsignin_button, R.id.fsignin_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fsignin_button:
                String signInEmail = fsigninEmail.getText().toString();
                String signInPassword = fsigninPassword.getText().toString();
                if (!TextUtils.isEmpty(signInEmail) && !TextUtils.isEmpty(signInPassword)) {
                    firebaseAuth.signInWithEmailAndPassword(signInEmail,signInPassword);
                }
                else {
                    Snackbar.make(view,"verfiy inputs",Snackbar.LENGTH_SHORT).show();
                }
                break;
            case R.id.fsignin_register:

                break;
        }
    }
}
