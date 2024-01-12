/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cantante;

/**
 *
 * @author juanf
 */
public class CantanteFamoso {
    private String nombre;
    private String discoconmasVentas;
    private int reproducciones; // Nuevo campo para las reproducciones

    public CantanteFamoso(String nombre, String discoconmasVentas, int reproducciones) {
        this.nombre = nombre;
        this.discoconmasVentas = discoconmasVentas;
        this.reproducciones = reproducciones;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDiscoconmasVentas() {
        return discoconmasVentas;
    }
    public int getReproducciones() {
        return reproducciones;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDiscoconmasVentas(String discoconmasVentas) {
        this.discoconmasVentas = discoconmasVentas;
    }
    public void setReproducciones(int reproducciones) {
        this.reproducciones = reproducciones;
    }
}


