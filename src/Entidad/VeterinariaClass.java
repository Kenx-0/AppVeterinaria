/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

import java.util.Date;

/**
 *
 * @author JOSTIN
 */
public class VeterinariaClass {
    String nombre;
    String propi;
    String raza;
    Date fecha;
    String sexo;
    String especie;

    public VeterinariaClass(String nombre, String propi, String raza, Date fecha, String sexo, String especie) {
        this.nombre = nombre;
        this.propi = propi;
        this.raza = raza;
        this.fecha = fecha;
        this.sexo = sexo;
        this.especie = especie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPropi() {
        return propi;
    }

    public void setPropi(String propi) {
        this.propi = propi;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
    
    
    
}
