package com.aars.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CitasDoctor extends AppCompatActivity {
    private static Conexion con= new Conexion();
    Button   buscar;
    EditText buscar_Doctor;
    TextView paciente;
    TextView nombrePaciente;
    TextView apellidos;
    TextView edad;
    TextView sexo;
    TextView consultorio;
    TextView id_Cita;
    TextView fecha_Cita;
    TextView especialidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas_doctor);

        paciente       = findViewById(R.id.Txt_Id_PacienteDato);
        nombrePaciente = findViewById(R.id.Txt_pacienteDato);
        apellidos      = findViewById(R.id.Txt_A_PacienteDato);
        edad           = findViewById(R.id.Txt_EdadDato);
        sexo           = findViewById(R.id.Txt_SexoDato);
        especialidad   = findViewById(R.id.ID_EspecialidadDatoC);
        consultorio    = findViewById(R.id.Txt_ConsultorioDato);
        id_Cita        = findViewById(R.id.Txt_ID_CitaDato);
        fecha_Cita     = findViewById(R.id.Txt_ID_FechaCitaDato);

        buscar_Doctor  = findViewById(R.id.EditT_Id_Buscar);
        buscar         = findViewById(R.id.btn_buscar);
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    buscar();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void buscar() throws SQLException {
        try {
            Statement comando = con.conexionBD().createStatement();
            String sql = ("SELECT * FROM VW_citas_por_doctor WHERE id_doctor ='" + buscar_Doctor.getText().toString() + "'");
            ResultSet resultado = comando.executeQuery(sql);

            if(resultado.next()) {
                paciente      .setText(resultado.getString(1));
                nombrePaciente.setText(resultado.getString(2));
                apellidos     .setText(resultado.getString(3));
                edad          .setText(resultado.getString(4));
                sexo          .setText(resultado.getString(5));
                especialidad  .setText(resultado.getString(7));
                consultorio   .setText(resultado.getString(8));
                id_Cita       .setText(resultado.getString(9));
                fecha_Cita    .setText(resultado.getString(10));
            }else {
                Toast.makeText(CitasDoctor.this,"No se encontraron citas", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception er) {
            Toast.makeText(getApplicationContext(),er.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}