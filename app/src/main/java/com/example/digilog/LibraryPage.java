package com.example.digilog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LibraryPage extends AppCompatActivity {
    EditText entrytime_var;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_library_page);
        entrytime_var = findViewById(R.id.editTextTime);
    }

    public void iminbuttonclick2(View view) {
    String entrytime_ = entrytime_var.getEditableText().toString();

    if (!entrytime_.isEmpty()){
        entrytime_var.setError(null);
        entrytime_var.setEnabled(false);

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("libdata");

        String entrytime_s = entrytime_var.getEditableText().toString();

        storinglibdata storinglibdatass = new storinglibdata(entrytime_s);

        reference.child(entrytime_s).setValue(storinglibdatass);
        Toast.makeText(this, "Time received", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getApplicationContext(),OutPage.class);
        startActivity(intent);
        finish();


    }else{
        entrytime_var.setError("Please enter entry time");
    }
    }
}