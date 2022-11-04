package com.mamcet.staffiin.ui.home;


import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mamcet.staffiin.R;


public class Nav_header extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference db;
        db = FirebaseDatabase.getInstance("https://staff-in-default-rtdb.firebaseio.com/").getReference("Staff").child(uid);
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name = (String) dataSnapshot.child("name").getValue();
                final TextView textViewToChange = (TextView) findViewById(R.id.user_name);
                textViewToChange.setText(name);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





    }
}
