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

// cambio añadido para testear xd (desde github.com)
public class Compra {
    private String NombreArticulo ;
    private Date FechaPedida;
    private Date FechaRecibo;
    private int idProv;
    private String Usuario;
    private String Articulo;
    private int CostoUnitario;
    private int UnidadesAdquiridas;

    public Compra(String NombreArticulo, Date FechaPedida, Date FechaRecibo, int idProv, String Usuario, String Articulo, int CostoUnitario, int UnidadesAdquiridas) {
        this.NombreArticulo = NombreArticulo;
        this.FechaPedida = FechaPedida;
        this.FechaRecibo = FechaRecibo;
        this.idProv = idProv;
        this.Usuario = Usuario;
        this.Articulo = Articulo;
        this.CostoUnitario = CostoUnitario;
        this.UnidadesAdquiridas = UnidadesAdquiridas;
    }

    public String getNombreArticulo() {
        return NombreArticulo;
    }

    public void setNombreArticulo(String NombreArticulo) {
        this.NombreArticulo = NombreArticulo;
    }

    public Date getFechaPedida() {
        return FechaPedida;
    }

    public void setFechaPedida(Date FechaPedida) {
        this.FechaPedida = FechaPedida;
    }

    public Date getFechaRecibo() {
        return FechaRecibo;
    }

    public void setFechaRecibo(Date FechaRecibo) {
        this.FechaRecibo = FechaRecibo;
    }

    public int getIdProv() {
        return idProv;
    }

    public void setIdProv(int idProv) {
        this.idProv = idProv;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getArticulo() {
        return Articulo;
    }

    public void setArticulo(String Articulo) {
        this.Articulo = Articulo;
    }

    public int getCostoUnitario() {
        return CostoUnitario;
    }

    public void setCostoUnitario(int CostoUnitario) {
        this.CostoUnitario = CostoUnitario;
    }

    public int getUnidadesAdquiridas() {
        return UnidadesAdquiridas;
    }

    public void setUnidadesAdquiridas(int UnidadesAdquiridas) {
        this.UnidadesAdquiridas = UnidadesAdquiridas;
    }

    
    
}
