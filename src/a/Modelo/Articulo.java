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

// cambio añadido para testear xd (desde github.com)
public class Articulo {
    private int idTipoObj;
    private int idMarca;
    private String NombreArticulo;
    private int Stock;
    private String RutaImg;
    private int PrecioUnitario;

    public Articulo(int idTipoObj, int idMarca, String NombreArticulo, int Stock, String RutaImg, int PrecioUnitario) {
        this.idTipoObj = idTipoObj;
        this.idMarca = idMarca;
        this.NombreArticulo = NombreArticulo;
        this.Stock = Stock;
        this.RutaImg = RutaImg;
        this.PrecioUnitario = PrecioUnitario;
    }

    public int getIdTipoObj() {
        return idTipoObj;
    }

    public void setIdTipoObj(int idTipoObj) {
        this.idTipoObj = idTipoObj;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombreArticulo() {
        return NombreArticulo;
    }

    public void setNombreArticulo(String NombreArticulo) {
        this.NombreArticulo = NombreArticulo;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public String getRutaImg() {
        return RutaImg;
    }

    public void setRutaImg(String RutaImg) {
        this.RutaImg = RutaImg;
    }

    public int getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(int PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }
    
}