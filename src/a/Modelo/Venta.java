/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.Modelo;

import java.util.Date;

/**
 *
 * @author Roberto
 */
public class Venta {
    private Date Fecha;
    private String NombreArticulo;
    private String Rut;
    private int CantidadVendida;

    public Venta(Date Fecha, String NombreArticulo, String Rut, int CantidadVendida) {
        this.Fecha = Fecha;
        this.NombreArticulo = NombreArticulo;
        this.Rut = Rut;
        this.CantidadVendida = CantidadVendida;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getNombreArticulo() {
        return NombreArticulo;
    }

    public void setNombreArticulo(String NombreArticulo) {
        this.NombreArticulo = NombreArticulo;
    }

    public String getRut() {
        return Rut;
    }

    public void setRut(String Rut) {
        this.Rut = Rut;
    }

    public int getCantidadVendida() {
        return CantidadVendida;
    }

    public void setCantidadVendida(int CantidadVendida) {
        this.CantidadVendida = CantidadVendida;
    }

    
}
