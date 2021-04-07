package com.aars.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Logindoctor extends AppCompatActivity {
    private static Conexion con= new Conexion();
    Button btn_ingresar;
    EditText EdiT_ingresarCorreo;
    //ESTOS NO USO


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logindoctor);

        btn_ingresar = findViewById(R.id.btn_ingresar);
        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Inicio_sesion();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        //ESTE SI USO
        EdiT_ingresarCorreo = findViewById(R.id.EditT_ingresarCorreo);
    }
    public void Inicio_sesion() throws SQLException {
        try {
            Statement comando = con.conexionBD().createStatement();
            String sql = ("SELECT * FROM doctores WHERE Correo ='" + EdiT_ingresarCorreo.getText().toString() + "'");
            ResultSet resultado = comando.executeQuery(sql);

            if(resultado.next()) {
                Intent menu = new Intent(Logindoctor.this, MenuDoctor.class );
                startActivity(menu);
            }else {
                Toast.makeText(Logindoctor.this,"Usuario no encontrado", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception er) {
            Toast.makeText(getApplicationContext(),er.toString(), Toast.LENGTH_SHORT).show();
        }
        EdiT_ingresarCorreo.setText("");
    }
}