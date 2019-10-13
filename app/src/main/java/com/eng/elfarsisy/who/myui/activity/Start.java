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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        firebaseAuth = FirebaseAuth.getInstance();
        currentUser = firebaseAuth.getCurrentUser();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new SplashFragment()).commit();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (currentUser != null) {
                    startActivity(new Intent(Start.this, MainActivity.class));
                    finish();

                } else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new SliderFragment()).commit();
                }
            }
        }, 2000);

    }
    public void moveToSignInFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new SignInFragment()).commit();

    }
}
