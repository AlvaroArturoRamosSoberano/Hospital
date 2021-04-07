package com.aars.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InformacionPaciente extends AppCompatActivity {
    private static Conexion con = new Conexion();
    //Declarando variables
    TextView id;
    TextView nombreDato;
    TextView apellidosDato;
    TextView edadDato;
    TextView sexoDato;
    TextView telefonoDato;
    TextView fechaNDato;
    TextView estatus;
    TextView lugarN;
    EditText curp;

    Button consultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_paciente);

        id = findViewById(R.id.Txt_IdDatoPa);
        nombreDato = findViewById(R.id.Txt_NombrePaDato);
        apellidosDato = findViewById(R.id.Txt_ApellidosDato);
        edadDato = findViewById(R.id.Txt_EdadDato);
        sexoDato = findViewById(R.id.Txt_SexoDato);
        telefonoDato = findViewById(R.id.Txt_TelefonoPaDato);
        fechaNDato = findViewById(R.id.Txt_FechaNPaDato);
        estatus = findViewById(R.id.Txt_EstatusDato);
        lugarN = findViewById(R.id.Txt_LugarNDato);
        curp = findViewById(R.id.EditT_ingresarCurp);

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
                String sql = ("SELECT * FROM pacientes WHERE Curp ='" + curp.getText().toString() + "'");
                ResultSet resultado = comando.executeQuery(sql);

                if(resultado.next()) {
                    id.setText(resultado.getString(1));
                    nombreDato.setText(resultado.getString(2));
                    apellidosDato.setText(resultado.getString(3));
                    edadDato.setText(resultado.getString(5));
                    sexoDato.setText(resultado.getString(6));
                    telefonoDato.setText(resultado.getString(7));
                    fechaNDato.setText(resultado.getString(8));
                    estatus.setText(resultado.getString(9));
                    lugarN.setText(resultado.getString(10));
                }else {
                    Toast.makeText(InformacionPaciente.this,"Ingrese correctamente su curp", Toast.LENGTH_SHORT).show();
                }
            }catch (Exception er) {
                Toast.makeText(getApplicationContext(),er.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }
