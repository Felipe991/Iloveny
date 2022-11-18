/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.Modelo;

/**
 *
 * @author Roberto
 */
public class Direccion {
    private String Rut;
    private String Comuna;
    private String Ciudad;
    private String Calle;
    private int NumeroDomicilio; 
    private int idRegion;

    public Direccion(String Rut, String Comuna, String Ciudad, String Calle, int NumeroDomicilio, int idRegion) {
        this.Rut = Rut;
        this.Comuna = Comuna;
        this.Ciudad = Ciudad;
        this.Calle = Calle;
        this.NumeroDomicilio = NumeroDomicilio;
        this.idRegion = idRegion;
    }

    public String getRut() {
        return Rut;
    }

    public void setRut(String Rut) {
        this.Rut = Rut;
    }

    public String getComuna() {
        return Comuna;
    }

    public void setComuna(String Comuna) {
        this.Comuna = Comuna;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getCalle() {
        return Calle;
    }

    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    public int getNumeroDomicilio() {
        return NumeroDomicilio;
    }

    public void setNumeroDomicilio(int NumeroDomicilio) {
        this.NumeroDomicilio = NumeroDomicilio;
    }

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }
    
    
}
