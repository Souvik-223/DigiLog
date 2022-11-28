package com.example.digilog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    Button signupbutton,loginbutton;
    EditText username_var,password_var;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        signupbutton = findViewById(R.id.button6);
        loginbutton = findViewById(R.id.button4);

        username_var = findViewById(R.id.editTextTextEmailAddress);
        password_var = findViewById(R.id.editTextTextPassword);

        loginbutton.setOnClickListener(view -> {
            String username_ = username_var.getEditableText().toString();
            String password_ = password_var.getEditableText().toString();

            if(!username_.isEmpty()){
                username_var.setError(null);
                username_var.setEnabled(false);
                if(!password_.isEmpty()) {
                    password_var.setError(null);
                    password_var.setEnabled(false);

                    final String username_data = username_var.getEditableText().toString();
                    final String password_data = password_var.getEditableText().toString();

                    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                    DatabaseReference databaseReference = firebaseDatabase.getReference("datauser");

                    Query check_username = databaseReference.orderByChild("fullname").equalTo(username_data);

                    check_username.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            if(snapshot.exists()){
                                username_var.setError(null);
                                username_var.setEnabled(false);
                                String passwordcheck = snapshot.child(username_data).child("password").getValue(String.class);
                                assert passwordcheck != null;
                                if(passwordcheck.equals(password_data)){
                                   password_var.setError(null);
                                   password_var.setEnabled(false);
                                    Toast.makeText(MainActivity.this, "Login sucessfully", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(),BuildingSelection.class);
                                    startActivity(intent);
                                    finish();
                                }else{
                                    password_var.setError("Wrong password");
                                }

                            }else{
                                username_var.setError("User doesn't exist");
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                else{
                    password_var.setError("Please enter the password");
                }
            }
            else{
                username_var.setError("Please enter the username");
            }
        });
    }


    public void openReg(View view) {
        startActivity(new Intent(this, regestration.class));
    }

    public void openBuild(View view) {
        startActivity(new Intent(this, BuildingSelection.class));
    }
}