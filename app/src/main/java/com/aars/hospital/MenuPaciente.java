package com.aars.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MenuPaciente extends AppCompatActivity {
    ImageButton citasPaciente;
    ImageButton datosPaciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_paciente);

        citasPaciente = findViewById(R.id.img_btn_CitasPaciente);
        datosPaciente = findViewById(R.id.img_btn_DatosPaciente);

        citasPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDoc = new Intent(MenuPaciente.this, CitasPaciente.class);
                MenuPaciente.this.startActivity(intentDoc);
            }
        });

        datosPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDoc = new Intent(MenuPaciente.this, InformacionPaciente.class);
                MenuPaciente.this.startActivity(intentDoc);
            }
        });

    }
}
