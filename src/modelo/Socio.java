/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author sergi
 */
public class Socio {

    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String dni;
    private String telefono;
    private String direccion;
    private boolean pago;

    /**
     * CONSTRUCTORES
     * @param id
     * @param nombre
     * @param apellido
     * @param correo
     * @param dni
     * @param telefono
     * @param direccion
     * @param pago 
     */
    public Socio(int id, String nombre, String apellido, String correo, String dni, String telefono, String direccion, boolean pago) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
        this.pago = pago;
    } 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
    
    /**
     * GETTERS Y SETTERS
     */
    
    
}
