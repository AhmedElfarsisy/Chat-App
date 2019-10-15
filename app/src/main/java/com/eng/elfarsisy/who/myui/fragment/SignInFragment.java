package com.eng.elfarsisy.who.myui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.eng.elfarsisy.who.R;
import com.eng.elfarsisy.who.myui.activity.MainActivity;
import com.eng.elfarsisy.who.myui.activity.Start;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends Fragment {


    EditText fsigninEmail;
    EditText fsigninPassword;
    Button fsigninButton;
    ProgressBar progressBar;
    TextView textViewt;
    TextView fsigninRegister;
    FirebaseAuth firebaseAuth;

    public SignInFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        firebaseAuth = FirebaseAuth.getInstance();

        fsigninRegister = view.findViewById(R.id.fsignin_register);
        fsigninButton = view.findViewById(R.id.fsignin_button);
        fsigninEmail = view.findViewById(R.id.fsignin_email);
        fsigninPassword = view.findViewById(R.id.fsignin_password);
        progressBar = view.findViewById(R.id.progressBar);


        fsigninRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().addToBackStack("SignInFragment").replace(R.id.containerF, new RegisterFragment()).commit();
            }
        });
        fsigninButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = fsigninEmail.getText().toString().trim();
                String Password = fsigninPassword.getText().toString().trim();

                if (!TextUtils.isEmpty(Email) && !TextUtils.isEmpty(Password)) {
                    fsigninButton.setVisibility(View.INVISIBLE);
                    progressBar.setVisibility(View.VISIBLE);
                    firebaseAuth.signInWithEmailAndPassword(Email, Password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {

                            startActivity(new Intent(getActivity(), MainActivity.class));
                            fsigninButton.setVisibility(View.VISIBLE);
                            progressBar.setVisibility(View.INVISIBLE);
                            Snackbar.make(view, "Thanks ", Snackbar.LENGTH_SHORT).show();

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            fsigninButton.setVisibility(View.VISIBLE);
                            progressBar.setVisibility(View.INVISIBLE);
                            Snackbar.make(view, e.getMessage(), Snackbar.LENGTH_SHORT).show();

                        }
                    });

                } else {
                    Snackbar.make(view, "verfiy all fields", Snackbar.LENGTH_SHORT).show();

                }

            }
        });

        return view;
    }


}
