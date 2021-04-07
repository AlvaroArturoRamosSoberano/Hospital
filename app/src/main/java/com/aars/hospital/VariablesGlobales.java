package com.aars.hospital;

import java.util.Date;

public class VariablesGlobales {
    private static VariablesGlobales instance;
    private static String Nombre_doctor ="";
    private static Date Fecha_nacimiento= new Date();
    private static String Especialidad="";
    private static String Cargo="";
    private static String Consultorio="";
    private static String Telefono="";
    private static String Correo="";

    public   String getNombre_doctor() {
        return Nombre_doctor;
    }
    public   void setNombre_doctor(String Nombre_doctor) {
        VariablesGlobales.Nombre_doctor = Nombre_doctor;
    }
    public   Date getFecha_nacimiento() {
        return Fecha_nacimiento;
    }
    public   void setFecha_nacimiento(Date Fecha_nacimiento) {
        VariablesGlobales.Fecha_nacimiento = Fecha_nacimiento;
    }
    public   String getEspecialidad() {
        return Especialidad;
    }
    public   void setEspecialidad(String Especialidad) {
        VariablesGlobales.Especialidad = Especialidad;
    }
    public   String getCargo() {
        return Cargo;
    }
    public   void setCargo(String Cargo) {
        VariablesGlobales.Cargo = Cargo;
    }
    public   String getConsultorio() {
        return Consultorio;
    }
    public   void setConsultorio(String Consultorio) {
        VariablesGlobales.Consultorio = Consultorio;
    }
    public String getCorreo() {
        return Correo;
    }
    public   void setCorreo(String Correo) {
        VariablesGlobales.Correo = Correo;
    }
    public   String getTelefono() {
        return Telefono;
    }
    public   void setTelefono(String Telefono) {
        VariablesGlobales.Telefono = Telefono;
    }
    public  static synchronized VariablesGlobales getInstance() {
        if (instance == null) {
            instance = new VariablesGlobales();
        }
        return instance;
    }
}
