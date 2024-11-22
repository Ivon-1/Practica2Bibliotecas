/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author sergi
 */
public class Usuario {
    private String id_sofa;
    private String desc_sofa;
    private int id_trabajador;
    private int tipo;

    public Usuario(String id_sofa, String desc_sofa, int tipo) {
        this.id_sofa = id_sofa;
        this.desc_sofa = desc_sofa;
        this.id_trabajador = id_trabajador;
        this.tipo = tipo;
    }

    public String getId_sofa() {
        return id_sofa;
    }

    public void setId_sofa(String id_sofa) {
        this.id_sofa = id_sofa;
    }

    public String getDesc_sofa() {
        return desc_sofa;
    }

    public void setDesc_sofa(String desc_sofa) {
        this.desc_sofa = desc_sofa;
    }

    public int getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(int id_trabajador) {
        this.id_trabajador = id_trabajador;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    
}
