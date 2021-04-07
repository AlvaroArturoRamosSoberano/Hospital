package com.aars.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Loginpaciente extends AppCompatActivity {
    private static Conexion con = new Conexion();
    EditText curp;
    Button ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpaciente);

        curp = findViewById(R.id.EditT_ingresarCurp);
        ingresar = findViewById(R.id.btn_ingresarPa);
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Inicio_sesionPa();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void Inicio_sesionPa() throws SQLException {
        try {
            Statement comando = con.conexionBD().createStatement();
            String sql = ("SELECT * FROM pacientes WHERE Curp ='" + curp.getText().toString() + "'");
            ResultSet resultado = comando.executeQuery(sql);

            if(resultado.next()) {
                Intent menuPa = new Intent(Loginpaciente.this, MenuPaciente.class );
                Loginpaciente.this.startActivity(menuPa);
            }else {
                Toast.makeText(Loginpaciente.this,"Usuario no encontrado", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception er) {
            Toast.makeText(getApplicationContext(),er.toString(), Toast.LENGTH_SHORT).show();
        }
        curp.setText("");
    }
}