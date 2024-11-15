/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author sergi
 */
public class Libro {
    private String isbn;
    private String titulo;
    private int numSerie;
    private float precio;
    private String estado;
    private String editorial;

    // constructor
    public Libro(String ISBN, String titulo, int numSerie, float precio, String estado, String editorial) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.numSerie = numSerie;
        this.precio = precio;
        this.estado = estado;
        this.editorial = editorial;
    }
    
    // getter y setter 

    public String getISBN() {
        return isbn;
    }

    public void setISBN(String ISBN) {
        this.isbn = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(int numSerie) {
        this.numSerie = numSerie;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    } 
}
