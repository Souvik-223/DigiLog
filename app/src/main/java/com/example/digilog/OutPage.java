package com.example.digilog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class OutPage extends AppCompatActivity {
    EditText outtime_var;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_out_page);

        outtime_var = findViewById(R.id.editTextTime3);
    }

    public void openBuild(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void imoutbuttonclick(View view) {

        String outtime_ = outtime_var.getEditableText().toString();

        if (!outtime_.isEmpty()){
            outtime_var.setError(null);
            outtime_var.setEnabled(false);

            firebaseDatabase = FirebaseDatabase.getInstance();
            reference = firebaseDatabase.getReference("labdata");

            String outtime_s = outtime_var.getEditableText().toString();

            storingoutdata storingoutdatass = new storingoutdata(outtime_s);

            reference.child(outtime_s).setValue(storingoutdatass);
            Toast.makeText(this, "Data received", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();

        }else{
            outtime_var.setError("Please enter the out time ");
        }
    }
}