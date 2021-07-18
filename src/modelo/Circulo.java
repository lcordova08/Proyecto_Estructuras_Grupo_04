/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import TDAs.CircularDoublyLinkedList;
import java.util.Random;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author grupo_4
 */
public class Circulo {
    private CircularDoublyLinkedList<Integer> elementos;
    private Pane view;
    private Circle circulo;
    private Pane botones;
    private static int radio;
    private static int centroX;
    private static int centroY;
    private int cantidadElem;


    public Circulo(int radio, int centroX, int centroY, int cantidadElem) {
        this.circulo = createCircle(radio, centroX, centroY);
        this.view = new Pane();
        this.view.getChildren().add(this.circulo);
        this.radio = radio;
        this.centroX = centroX;
        this.centroY = centroY;
        this.elementos = generateValues(cantidadElem);
        this.botones = addElemsView(cantidadElem, elementos);
        this.cantidadElem = cantidadElem;
        view.getChildren().add(botones);

    }
    
    public Circle createCircle(int radio, int centroX, int centroY){
        Circle c1 = new Circle(centroX, centroY, radio);
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
        Pane botones = new Pane();
        for(int i = 0; i < cantidadElem; i++){
            double angulo = 2 * i * Math.PI / cantidadElem;
            double xOffset = radio * Math.cos(angulo);
            double yOffset = radio * Math.sin(angulo);
            double x = centroX + xOffset;
            double y = centroY + yOffset;
            Button label = new Button(Integer.toString(elementos.get(i)));
            label.setLayoutX(x);
            label.setLayoutY(y);
            botones.getChildren().add(label);
        }
        return botones;
    }
    
    public void rotateLeft() {
        botones.getChildren().clear();
        int primero = elementos.getFirst();
        CircularDoublyLinkedList<Integer> nueva = new CircularDoublyLinkedList<>();
        for(int i = 1; i <=  nueva.size(); i++){
            nueva.addLast(elementos.get(i) - 1);
        }
        nueva.addLast(primero - 1);
        elementos = nueva;
        botones.getChildren().add(addElemsView(cantidadElem, elementos));
    }
    
    public void rotateRight() {

        int ultimo = elementos.getLast();
        CircularDoublyLinkedList<Integer> nueva = new CircularDoublyLinkedList<>();
        nueva.addLast(ultimo + 1);
        for(int i = 0; i <=  nueva.size() - 2; i++){
            nueva.addLast(elementos.get(i) + 1);
        }
        elementos = nueva;
        System.out.println(nueva);
        botones.getChildren().add(addElemsView(cantidadElem, elementos));
    }
    
    public void deleteRow(Circulo xd){
        
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
