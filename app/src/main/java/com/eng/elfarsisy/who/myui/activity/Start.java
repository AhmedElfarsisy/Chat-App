package com.eng.elfarsisy.who.myui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.eng.elfarsisy.who.R;
import com.eng.elfarsisy.who.myui.fragment.SignInFragment;
import com.eng.elfarsisy.who.myui.fragment.SliderFragment;
import com.eng.elfarsisy.who.myui.fragment.SplashFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Start extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    FirebaseUser currentUser;
    int userbefor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        firebaseAuth = FirebaseAuth.getInstance();
        currentUser = firebaseAuth.getCurrentUser();

        getSupportFragmentManager().beginTransaction().replace(R.id.containerF, new SplashFragment()).commit();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (currentUser != null) {
                    startActivity(new Intent(Start.this, MainActivity.class));
                    userbefor++;
                    finish();


                } else if (userbefor > 0) {

                    getSupportFragmentManager().beginTransaction().replace(R.id.containerF, new SignInFragment()).commit();

                } else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.containerF, new SliderFragment()).commit();
                }
            }
        }, 2000);

    }

}
