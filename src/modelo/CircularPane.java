/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import static java.lang.Math.cos;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 *
 * @author gabri
 */
public class CircularPane extends Pane {
    @Override
    protected void layoutChildren() {
        int radio = 200;
        double separacion = 360 / getChildren().size();
        double angulos = 0;
        for(Node node : getChildren()) {
            double x = radio * Math.cos(Math.toRadians(angulos)) + getWidth() /2;
            double y = radio * Math.sin(Math.toRadians(angulos)) + getHeight() /2;
            layoutInArea(node, x - node.getBoundsInLocal().getWidth()/2, y - node.getBoundsInLocal().getHeight()/2, getHeight(), getWidth(),0.0 , HPos.CENTER, VPos.CENTER);
            angulos+=separacion;
        }
        
        
    }
    
}
