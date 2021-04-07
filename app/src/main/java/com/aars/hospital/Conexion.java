package com.aars.hospital;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    Connection conexion = null;

    //FUNCION PARA CONCECTARNOS
    public Connection conexionBD() {
            // Registramos el driver de PostgresSQL
            try {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

                StrictMode.setThreadPolicy(policy);
                Class.forName("org.postgresql.Driver");
                conexion = DriverManager.getConnection(
                        "jdbc:postgresql://ec2-34-230-149-169.compute-1.amazonaws.com:5432/dmpbvt6hc7ouc?sslmode=require",
                        "neruhvyhbhgjpk", "72069fa8503c312865f8a81bb05b76f0a3d6b4ca83243134d50ab1dd5c2f7494");
            }catch (Exception er) {
            System.err.println(er.getMessage());
        }
        return conexion;
    }
    //FUNCION PARA CERRAR CONEXION
    protected void cerrar_funcion(Connection con) throws Exception {
        con.close();
    }
}
