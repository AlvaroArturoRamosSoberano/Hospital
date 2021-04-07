package com.aars.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MenuDoctor extends AppCompatActivity {

    ImageButton datos;
    ImageButton citas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_doctor);

        citas = findViewById(R.id.img_btn_Citas);
        datos = findViewById(R.id.img_btn_Datos);

        citas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDoc = new Intent(MenuDoctor.this, CitasDoctor.class);
                MenuDoctor.this.startActivity(intentDoc);
            }
        });

        datos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDoc = new Intent(MenuDoctor.this, InformacionDoctor.class);
                MenuDoctor.this.startActivity(intentDoc);
            }
        });

    }
}
