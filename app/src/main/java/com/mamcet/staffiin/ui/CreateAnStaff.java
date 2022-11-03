package com.mamcet.staffiin.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mamcet.staffiin.R;
import com.mamcet.staffiin.ui.task.staffDetails;

public class CreateAnStaff extends AppCompatActivity {

    EditText staff_email, staff_password, staff_id, staff_dob, staff_phone_number, staff_qualification, staff_name, staff_role, staff_address;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_an_staff);
         staff_email = findViewById(R.id.staff_email);
         staff_password = findViewById(R.id.staff_password);
         staff_id = findViewById(R.id.staff_id);
         staff_phone_number = findViewById(R.id.staff_phone_number);
         staff_dob = findViewById(R.id.staff_dob);
         staff_qualification = findViewById(R.id.staff_qualification);
         staff_address = findViewById(R.id.staff_address);
         staff_name = findViewById(R.id.staff_name);
         staff_role = findViewById(R.id.staff_role);


        Button create_an_staff_btn2 = (Button) findViewById(R.id.create_a_staff_btn);

        create_an_staff_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                createStaff();
            }
            });
        }

        public void createStaff(){
            FirebaseAuth mAuth;


            String id = staff_id.getText().toString();
            String phone_number = staff_phone_number.getText().toString();
            String dob = staff_dob.getText().toString();
            String qualification = staff_qualification.getText().toString();
            String address = staff_address.getText().toString();
            String name = staff_name.getText().toString();
            String role = staff_role.getText().toString();
            String email = staff_email.getText().toString();
            String password = staff_password.getText().toString();

            mAuth = FirebaseAuth.getInstance();
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){

                                String userId = task.getResult().getUser().getUid();
                                DatabaseReference db;

                                staffDetails staff = new staffDetails(id, phone_number, dob, qualification, address, role, email, name);

                                 db = FirebaseDatabase.getInstance("https://staff-in-default-rtdb.firebaseio.com/").getReference("Staff/"+userId);

                                db.setValue(staff);

                                Toast.makeText(CreateAnStaff.this, "Added", Toast.LENGTH_LONG).show();
                            }
                            else {

                                Toast.makeText(CreateAnStaff.this, "Access Denied", Toast.LENGTH_LONG).show();
                            }
                        }

                    });
        }
    }
