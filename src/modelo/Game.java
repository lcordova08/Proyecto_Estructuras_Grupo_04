/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;

/**
 *
 * @author gabri
 */
public class Game {
    private int apuesta;
    private int numElementos;
    private int numCirculos;
    private StackPane root;
    private Circulo c1;
    private Circulo c2;
    
    public Game(int radio, int centroW, int centroH, int numElementos){
        this.root = createCircles(radio, centroW, centroH, numElementos);
    }
    
    public StackPane createCircles(int radio, int centroW, int centroH, int numElementos) {
        StackPane rut = new StackPane();
        
        setC1(new Circulo(radio, centroW, centroH, numElementos));
        setC2(new Circulo(radio / 2, centroW, centroH, numElementos));
        rut.getChildren().addAll(getC1().getView(), getC2().getView());
        rut.setAlignment(Pos.CENTER);
        return rut;
    }

    public int getApuesta() {
        return apuesta;
    }

    public void setApuesta(int apuesta) {
        this.apuesta = apuesta;
    }

    public int getNumElementos() {
        return numElementos;
    }

    public void setNumElementos(int numElementos) {
        this.numElementos = numElementos;
    }

    public StackPane getRoot() {
        return root;
    }

    public void setRoot(StackPane root) {
        this.root = root;
    }

    public Circulo getC1() {
        return c1;
    }

    public void setC1(Circulo c1) {
        this.c1 = c1;
    }

    public Circulo getC2() {
        return c2;
    }

    public void setC2(Circulo c2) {
        this.c2 = c2;
    }
        
    
}