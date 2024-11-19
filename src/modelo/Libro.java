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
    private int idAutor;
    private String editorial;
    private int idBiblioteca;

    /**
     * constructor principal
     * @param isbn
     * @param titulo
     * @param numSerie
     * @param precio
     * @param estado
     * @param idAutor
     * @param editorial
     * @param idBiblioteca 
     */
    public Libro(String isbn, String titulo, int numSerie, float precio, String estado, int idAutor, String editorial, int idBiblioteca) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.numSerie = numSerie;
        this.precio = precio;
        this.estado = estado;
        this.idAutor = idAutor;
        this.editorial = editorial;
        this.idBiblioteca = idBiblioteca;
    }

    /**
     * constructor dos para que no haya errores al insertar
     * @param isbn
     * @param titulo
     * @param numSerie
     * @param precio
     * @param estado
     * @param editorial 
     */
    public Libro(String isbn, String titulo, int numSerie, float precio, String estado, String editorial) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.precio = precio;
        this.estado = estado;
        this.editorial = editorial;
    }

    /**
     * getter y setter
     * @return 
     */
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public int getIdBiblioteca() {
        return idBiblioteca;
    }

    public void setIdBiblioteca(int idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

}
