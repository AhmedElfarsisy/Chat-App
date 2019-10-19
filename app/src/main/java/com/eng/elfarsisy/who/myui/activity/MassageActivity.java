package com.eng.elfarsisy.who.myui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eng.elfarsisy.who.R;
import com.eng.elfarsisy.who.adapter.MassageAdapter;
import com.eng.elfarsisy.who.model.Massage;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MassageActivity extends AppCompatActivity {

    @BindView(R.id.massageText)
    EditText massageText;
    @BindView(R.id.sendbtn)
    Button sendbtn;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    FirebaseUser currentUser;
    List<Massage> massageList;
    @BindView(R.id.massage_Recycler)
    RecyclerView massageRecycler;
    String FriendKey;
    MassageAdapter massageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_massage);
        ButterKnife.bind(this);
        firebaseAuth = FirebaseAuth.getInstance();
        currentUser = firebaseAuth.getCurrentUser();
        firebaseDatabase=FirebaseDatabase.getInstance();

        FriendKey = getIntent().getExtras().getString("FriendKey");
        initMassage();


    }

    private void initMassage() {
        massageRecycler.setLayoutManager(new LinearLayoutManager(this));
        DatabaseReference massageReferance=firebaseDatabase.getReference("Massage").child(FriendKey).push();
//        DatabaseReference massageRefrance = firebaseDatabase.getReference("Massage").child("FriendKey");
        massageReferance.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                massageList = new ArrayList<>();

                for (DataSnapshot snap : dataSnapshot.getChildren()) {
                    Massage massage = snap.getValue(Massage.class);
                    massageList.add(massage);

                }
                massageAdapter = new MassageAdapter(MassageActivity.this, massageList);
                massageRecycler.setAdapter(massageAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @OnClick(R.id.sendbtn)
    public void onViewClicked() {
        String massagetxt = massageText.getText().toString();
//        String senderImage=currentUser.getPhotoUrl().toString();
        String Name=currentUser.getDisplayName();
        String uId=currentUser.getUid();
        Massage massage=new Massage(massagetxt,uId,null,Name);
        firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference massageRef = firebaseDatabase.getReference("Massage").child("FriendKey").push();
        massageRef.setValue(massage).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
            massageText.setText("");

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MassageActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



    }
}
