package com.aars.hospital;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InformacionDoctor extends AppCompatActivity {
    private static Conexion con = new Conexion();
    //Declarando variables
    TextView nombreDato;
    TextView fechaNDato;
    TextView especialidadDato;
    TextView cargoDato;
    TextView consultorioDato;
    EditText correo;
    TextView telefonoDato;
    TextView id;
    Button consultar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_doctor);
        //ESTE NO USO
        // EdiT_ingresarCorreo=findViewById(R.id.EditT_ingresarCorreo);

        //ESTOS SI USO
        id= findViewById(R.id.Txt_IdDato);
        nombreDato = findViewById(R.id.Txt_NombreDato);
        fechaNDato = findViewById(R.id.Txt_FechaNDato);
        especialidadDato = findViewById(R.id.Txt_EspecialidadDato);
        cargoDato = findViewById(R.id.Txt_CargoDato);
        consultorioDato = findViewById(R.id.Txt_ConsultorioDato);
        correo = findViewById(R.id.EditT_ingresarCorreo);
        telefonoDato = findViewById(R.id.Txt_TelefonoDato);
        consultar = findViewById(R.id.btn_consultar);
        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    consultar();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void consultar() throws SQLException {
        try {
            Statement comando = con.conexionBD().createStatement();
            String sql = ("SELECT * FROM doctores WHERE Correo ='" + correo.getText().toString() + "'");
            ResultSet resultado = comando.executeQuery(sql);

            if(resultado.next()) {
                id.setText(resultado.getString(1));
                nombreDato.setText(resultado.getString(2));
                fechaNDato.setText(resultado.getString(3));
                especialidadDato.setText(resultado.getString(4));
                cargoDato.setText(resultado.getString(5));
                consultorioDato.setText(resultado.getString(6));
                telefonoDato.setText(resultado.getString(8));

            }else {
                Toast.makeText(InformacionDoctor.this,"Ingrese correctamente su correo", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception er) {
            Toast.makeText(getApplicationContext(),er.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
