/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author sergi
 */
public class Trabajador {

    private int idTrabajador;
    private String nombre;
    private String apellido;
    private String correo;
    private int telefono;
    private int id_mobiliario;

    public Trabajador(int idTrabajador, String nombre, String apellido, String correo, int telefono, int id_mobiliario) {
        this.idTrabajador = idTrabajador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.id_mobiliario = id_mobiliario;
    }

    /**
     * Constructor 2
     *
     * @return
     */
    public Trabajador(String nombre, String apellido, String correo, int telefono, int id_mobiliario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.id_mobiliario = id_mobiliario;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajdor) {
        this.idTrabajador = idTrabajdor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getId_mobiliario() {
        return id_mobiliario;
    }

    public void setId_mobiliario(int id_mobiliario) {
        this.id_mobiliario = id_mobiliario;
    }

}
