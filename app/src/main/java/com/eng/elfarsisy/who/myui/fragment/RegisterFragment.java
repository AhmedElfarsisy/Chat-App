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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.eng.elfarsisy.who.R;
import com.eng.elfarsisy.who.model.User;
import com.eng.elfarsisy.who.myui.activity.MainActivity;
import com.eng.elfarsisy.who.myui.activity.Start;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
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
    StorageReference storageReference;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        firebaseAuth = FirebaseAuth.getInstance();


        View view = inflater.inflate(R.layout.fragment_register, container, false);

        RegisterEmail = view.findViewById(R.id.Register_email);
        RegisterName = view.findViewById(R.id.Register_name);
        RegisterPassword = view.findViewById(R.id.Register_password);
        RegisterPassword2 = view.findViewById(R.id.Register_password2);
        RegisterPhone = view.findViewById(R.id.Register_phone);
        RegisterprogressBar = view.findViewById(R.id.RegisterprogressBar);
        registerTex = view.findViewById(R.id.registerTex);

        RegisterButton = view.findViewById(R.id.Register_button);

        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplication(), "clicked", Toast.LENGTH_SHORT).show();
                String regName = RegisterName.getText().toString();
                String regEmail = RegisterEmail.getText().toString();
                String regPasssword = RegisterPassword.getText().toString();
                String regPasssword2 = RegisterPassword2.getText().toString();
                String regPhone = RegisterPhone.getText().toString();
                Toast.makeText(getActivity().getApplication(), "intial", Toast.LENGTH_SHORT).show();
//   && regPasssword == regPasssword2
                if (!TextUtils.isEmpty(regEmail)&& !TextUtils.isEmpty(regName)&& !TextUtils.isEmpty(regPhone)&& !TextUtils.isEmpty(regPasssword)&&TextUtils.equals(regPasssword,regPasssword2)) {

                    RegisterButton.setVisibility(View.INVISIBLE);
                    RegisterprogressBar.setVisibility(View.VISIBLE);
                    firebaseAuth.createUserWithEmailAndPassword(regEmail, regPasssword).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Toast.makeText(getActivity().getApplication(), "created", Toast.LENGTH_SHORT).show();

                            RegisterButton.setVisibility(View.VISIBLE);
                            RegisterprogressBar.setVisibility(View.INVISIBLE);
                            Snackbar.make(getView(), "welcome with us", Snackbar.LENGTH_SHORT).show();
                            User user = new User(regName, regEmail, regPhone);
                            storageReference = FirebaseStorage.getInstance().getReference().child("Users_photos");

                            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                            DatabaseReference databaseReference = firebaseDatabase.getReference("Users").push();
                            String Key = databaseReference.getKey();
                            user.setUserKey(Key);
                            databaseReference.setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(getActivity().getApplication(), "finished", Toast.LENGTH_SHORT).show();

                                    RegisterButton.setVisibility(View.VISIBLE);
                                    RegisterprogressBar.setVisibility(View.INVISIBLE);
                                    Snackbar.make(getView(), "thanks for your patience", Snackbar.LENGTH_SHORT);
                                    startActivity(new Intent(getActivity(), MainActivity.class));

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getActivity().getApplication(), "faild", Toast.LENGTH_SHORT).show();

                                    RegisterButton.setVisibility(View.VISIBLE);
                                    RegisterprogressBar.setVisibility(View.INVISIBLE);
                                    Snackbar.make(getView(), e.getMessage(), Snackbar.LENGTH_SHORT);
                                }
                            });


                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            RegisterButton.setVisibility(View.VISIBLE);
                            RegisterprogressBar.setVisibility(View.INVISIBLE);
                            Snackbar.make(getView(), e.getMessage(), Snackbar.LENGTH_SHORT).show();
                        }
                    });
                }
                else {
                    Toast.makeText(getActivity().getApplication(), "haha", Toast.LENGTH_SHORT).show();


                }
            }
        });
        return view;
    }


}
