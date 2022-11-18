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
public class Usuario {
    private String NombreUsuario;
    private String Apellido;
    private String Rut;
    private String Email;
    private String Telefono;

    public Usuario(String NombreUsuario, String Apellido, String Rut, String Email, String Telefono) {
        this.NombreUsuario = NombreUsuario;
        this.Apellido = Apellido;
        this.Rut = Rut;
        this.Email = Email;
        this.Telefono = Telefono;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getRut() {
        return Rut;
    }

    public void setRut(String Rut) {
        this.Rut = Rut;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    
    
        
}
