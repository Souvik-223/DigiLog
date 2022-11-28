package com.example.digilog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LabPage extends AppCompatActivity {
    TextView roomno_var, pcno_var, entrytime_var,laptoppc_var,regno_var;


    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_lab_page);

        roomno_var = findViewById(R.id.editTextPhone4);
        laptoppc_var = findViewById(R.id.laptoppc);
        pcno_var = findViewById(R.id.editTextTextPersonName4);
        entrytime_var = findViewById(R.id.editTextTime2);
        regno_var = findViewById(R.id.editTextNumber);
    }


    public void iminbuttonclick(View view) {
        String roomno_ = roomno_var.getEditableText().toString();
        String laptoppc_ = laptoppc_var.getEditableText().toString();
        String pcno_ = pcno_var.getEditableText().toString();
        String entrytime_ = entrytime_var.getEditableText().toString();
        String regno_ = regno_var.getEditableText().toString();


        if (!roomno_.isEmpty()) {
            roomno_var.setError(null);
            roomno_var.setEnabled(false);
            if (!laptoppc_.isEmpty()) {
                laptoppc_var.setError(null);
                laptoppc_var.setEnabled(false);
                if (!pcno_.isEmpty()) {
                    pcno_var.setError(null);
                    pcno_var.setEnabled(false);
                    if (!entrytime_.isEmpty()) {
                        entrytime_var.setError(null);
                        entrytime_var.setEnabled(false);
                        if (!regno_.isEmpty()) {
                            regno_var.setError(null);
                            regno_var.setEnabled(false);
                            if (entrytime_.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]")) {


                                firebaseDatabase = FirebaseDatabase.getInstance();
                                reference = firebaseDatabase.getReference("labdata");

                                String roomno_s = roomno_var.getEditableText().toString();
                                String laptoppc_s = laptoppc_var.getEditableText().toString();
                                String pcno_s = pcno_var.getEditableText().toString();
                                String entrytime_s = entrytime_var.getEditableText().toString();
                                String regno_s = regno_var.getEditableText().toString();

                                storinglabdata storinglabdatass = new storinglabdata(roomno_s, laptoppc_s, pcno_s, entrytime_s, regno_s);

                                reference.child(pcno_s).setValue(storinglabdatass);
                                Toast.makeText(this, "Data received", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(getApplicationContext(), OutPage.class);
                                startActivity(intent);
                                finish();
                            }else{
                                entrytime_var.setError("Invalid time format");
                            }

                    } else {
                        regno_var.setError("Please enter reg no");
                    }
                } else {
                    entrytime_var.setError("Please enter entry time");
                }

            } else {
                pcno_var.setError("Please enter PC no / Laptop");
            }

        } else {
            laptoppc_var.setError("Please enter Laptop or PC");
        }

    }else{
            roomno_var.setError("Please enter the room no");
        }
    }
    }



