/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javafx.scene.layout.StackPane;

/**
 *
 * @author gabri
 */
public class Game {
    private int apuesta;
    private int numElementos;
    private StackPane circulos;
    private Circulo c1;
    private Circulo c2;
    
    public Game(){
        
    }
    
    public StackPane createCircles(int numElementos) {
        StackPane rut = new StackPane();
        
        
        
        return rut;
    }

    public int getApuesta() {
        return apuesta;
    }

    public void setApuesta(int apuesta) {
        this.apuesta = apuesta;
    }
        
}