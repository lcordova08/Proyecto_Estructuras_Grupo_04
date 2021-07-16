/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import TDAs.CircularLinkedList;
import javafx.scene.shape.Circle;

/**
 *
 * @author gabri
 */
public class Circulo {
    private CircularLinkedList<Integer> elementos;
    private Circle view;


    public Circulo() {
    }
    
    public Circle createCircle(int radio, int centroW, int centroH){
        Circle c1 = new Circle(radio, centroW, centroH);
        return c1;
        
    }

    public CircularLinkedList<Integer> getElementos() {
        return elementos;
    }

    public void setElementos(CircularLinkedList<Integer> elementos) {
        this.elementos = elementos;
    }

    public Circle getView() {
        return view;
    }

    public void setView(Circle view) {
        this.view = view;
    }
    
    
}
