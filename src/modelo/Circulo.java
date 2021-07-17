/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import TDAs.CircularDoublyLinkedList;
import java.util.Random;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author gabri
 */
public class Circulo {
    private CircularDoublyLinkedList<Integer> elementos;
    private Pane view;
    private final int radio;
    private final int centroW;
    private final int centroH;


    public Circulo(int radio, int centroW, int centroH, int cantidadElem) {
        this.view = new Pane(createCircle(radio, centroW, centroH));
        this.radio = radio;
        this.centroH = centroH;
        this.centroW = centroW;
        this.elementos = generateValues(cantidadElem);
        this.view.getChildren().add(addElemsView(cantidadElem, elementos));

    }
    
    public Circle createCircle(int radio, int centroW, int centroH){
        Circle c1 = new Circle(centroW, centroH, radio);
        c1.setStroke(Color.web("blue", 0.5));
        c1.setFill(Color.rgb(0, 0, 0, 0));
        return c1;
        
    }
    
    public CircularDoublyLinkedList<Integer> generateValues(int cantidadElem) {
        Random rand = new Random();
        CircularDoublyLinkedList<Integer> elem = new CircularDoublyLinkedList<>();
        for(int i = 0; i < cantidadElem; i++) {
            int num = rand.nextInt(10);
            elem.addLast(num);
        }
        elem.toString();
        return elem;
    }
    
    public Pane addElemsView(int cantidadElem, CircularDoublyLinkedList<Integer> elementos){
        Pane pane = new Pane();
        for(int i = 0; i < cantidadElem; i++) {
            double angulo = 2 * i * Math.PI / cantidadElem;
            double xDist = radio * Math.cos(angulo);
            double yDist = radio * Math.sin(angulo);
            double x = centroW + xDist;
            double y = centroH + yDist;
            String elem = Integer.toString(elementos.get(i));
            Button xd = new Button(elem);
            pane.getChildren().add(xd);
            
        }
        return pane;
    }

    public CircularDoublyLinkedList<Integer> getElementos() {
        return elementos;
    }

    public void setElementos(CircularDoublyLinkedList<Integer> elementos) {
        this.elementos = elementos;
    }

    public Pane getView() {
        return view;
    }

    public void setView(Pane view) {
        this.view = view;
    }
    
    
}
