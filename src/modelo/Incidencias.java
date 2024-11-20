/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jguti
 */
public class Incidencias {
    private int id_incidencia;
    private String estado_incidencia;
    private String tipo_incidencia;
    private int idSocio;

    public Incidencias(int id_incidencia, String estado_incidencia, String tipo_incidencia, int idSocio) {
        this.id_incidencia = id_incidencia;
        this.estado_incidencia = estado_incidencia;
        this.tipo_incidencia = tipo_incidencia;
        this.idSocio = idSocio;
    }

    public int getId_incidencia() {
        return id_incidencia;
    }

    public void setId_incidencia(int id_incidencia) {
        this.id_incidencia = id_incidencia;
    }

    public String getEstado_incidencia() {
        return estado_incidencia;
    }

    public void setEstado_incidencia(String estado_incidencia) {
        this.estado_incidencia = estado_incidencia;
    }

    public String getTipo_incidencia() {
        return tipo_incidencia;
    }

    public void setTipo_incidencia(String tipo_incidencia) {
        this.tipo_incidencia = tipo_incidencia;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }
}
