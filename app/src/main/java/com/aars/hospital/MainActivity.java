package com.aars.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
ImageButton paciente ;
ImageButton doctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paciente = findViewById(R.id.imgbtn_paciente);
        doctor = findViewById(R.id.imgbtn_doctor);

        paciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPac = new Intent(MainActivity.this, Loginpaciente.class);
                MainActivity.this.startActivity(intentPac);
           }
        });

        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDoc = new Intent(MainActivity.this, Logindoctor.class);
                MainActivity.this.startActivity(intentDoc);
            }
        });

    }
}
