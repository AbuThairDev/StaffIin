package com.mamcet.staffiin.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
import com.mamcet.staffiin.ui.signin.LoginActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Button logOut_btn = (Button) findViewById(R.id.logout_btn);
        logOut_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                FirebaseAuth.getInstance().signOut();
                Intent redirect= new Intent(ProfileActivity.this, LoginActivity.class);
                startActivity(redirect);
            }
        });

        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference db;
        db = FirebaseDatabase.getInstance("https://staff-in-default-rtdb.firebaseio.com/").getReference("Staff").child(uid);
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name = (String) dataSnapshot.child("name").getValue();
                String role = (String) dataSnapshot.child("role").getValue();
                String email = (String) dataSnapshot.child("email").getValue();
                String id = (String) dataSnapshot.child("id").getValue();
                String dob = (String) dataSnapshot.child("dob").getValue();
                String phone_number = (String) dataSnapshot.child("phone_number").getValue();
                String qualification = (String) dataSnapshot.child("qualification").getValue();
                String address = (String) dataSnapshot.child("address").getValue();

                final TextView textViewToChangeName = (TextView) findViewById(R.id.user_name);
                final TextView textViewToChangeRole = (TextView) findViewById(R.id.role_text);
                final TextView textViewToChangeStaffID = (TextView) findViewById(R.id.staff_id_text);
                final TextView textViewToChangeEmail = (TextView) findViewById(R.id.email_text);
                final TextView textViewToChangePhoneNumber = (TextView) findViewById(R.id.staff_phone_number_text);
                final TextView textViewToChangeDob = (TextView) findViewById(R.id.staff_dob_text);
                final TextView textViewToChangeQualification = (TextView) findViewById(R.id.staff_qualification_text);
                final TextView textViewToChangeAddress = (TextView) findViewById(R.id.staff_address_text);

                textViewToChangeName.setText(name);
                textViewToChangeRole.setText(role);
                textViewToChangeStaffID.setText(id);
                textViewToChangePhoneNumber.setText(phone_number);
                textViewToChangeEmail.setText(email);
                textViewToChangeDob.setText(dob);
                textViewToChangeQualification.setText(qualification);
                textViewToChangeAddress.setText(address);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}