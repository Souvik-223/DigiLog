package com.example.digilog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class regestration extends AppCompatActivity {

    TextView fullname_var, email_var, mobilenumber_var, department_var, year_var, password_var;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_regestration);

        fullname_var = findViewById(R.id.editTextTextPersonName);
        email_var = findViewById(R.id.editTextTextEmailAddress2);
        mobilenumber_var = findViewById(R.id.editTextPhone);
        department_var = findViewById(R.id.editTextTextPersonName2);
        year_var = findViewById(R.id.editTextTextPersonName3);
        password_var = findViewById(R.id.editTextTextPassword2);


    }

    public void openLogin(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void registerbuttonclick(View view) {
        String fullname_ = fullname_var.getEditableText().toString();
        String email_ = email_var.getEditableText().toString();
        String mobilenumber_ = mobilenumber_var.getEditableText().toString();
        String department_ = department_var.getEditableText().toString();
        String year_ = year_var.getEditableText().toString();
        String password_ = password_var.getEditableText().toString();

        if (!fullname_.isEmpty()) {
            fullname_var.setError(null);
            fullname_var.setEnabled(false);
            if (!email_.isEmpty()) {
                email_var.setError(null);
                email_var.setEnabled(false);
                if (!mobilenumber_.isEmpty()) {
                    mobilenumber_var.setError(null);
                    mobilenumber_var.setEnabled(false);
                    if (!department_.isEmpty()) {
                        department_var.setError(null);
                        department_var.setEnabled(false);
                        if (!year_.isEmpty()) {
                            year_var.setError(null);
                            year_var.setEnabled(false);
                            if (!password_.isEmpty()) {
                                password_var.setError(null);
                                password_var.setEnabled(false);

                                if(email_.matches("^(.+)@(.+)$")){

                                    firebaseDatabase = FirebaseDatabase.getInstance();
                                    reference = firebaseDatabase.getReference("datauser");

                                    String fullname_s = fullname_var.getEditableText().toString();
                                    String email_s = email_var.getEditableText().toString();
                                    String mobilenumber_s = mobilenumber_var.getEditableText().toString();
                                    String department_s = department_var.getEditableText().toString();
                                    String year_s = year_var.getEditableText().toString();
                                    String password_s = password_var.getEditableText().toString();

                                    storingdata storingdatass = new storingdata(fullname_s,email_s,mobilenumber_s,department_s,year_s,password_s);

                                    reference .child(fullname_s).setValue(storingdatass);
                                    Toast.makeText(this, "Register successfully", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                    startActivity(intent);
                                    finish();



                                }else{
                                    email_var.setError("Invalid email");
                                }

                            } else {
                                password_var.setError("Please enter the password");
                            }

                        } else {
                            year_var.setError("Please enter the year");
                        }

                    } else {
                        department_var.setError("Please enter the department name");
                    }

                } else {
                    mobilenumber_var.setError("Please enter the mobile number");
                }

            } else {
                email_var.setError("Please enter the email");
            }

        } else {
            fullname_var.setError("Please enter the full name");
        }
    }
}