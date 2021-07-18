/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author grupo_4
 */
public class View extends Application {
    private static int width = 1000;
    private static int heigth = 1000;
    private static int centroW = width / 2;
    private static int centroH = heigth / 2;
    private static int radio = 200;
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        Game game = new Game(radio,centroW, centroH, 5);
        
        Label c1 = new Label("Circulo externo");
        Button rotateLeft = new Button("<----");
        Button rotateRight = new Button("---->");
        HBox girar = new HBox();
        girar.setAlignment(Pos.CENTER);
        girar.getChildren().addAll(c1,rotateLeft, rotateRight);
        
        rotateLeft.setOnAction((e) -> {
            game.getC1().rotateLeft();
        });
        rotateRight.setOnAction((e) -> {
            game.getC1().rotateRight();
        });
        
        
        Label c2 = new Label("Circulo interno");
        Button rotateLeftIn = new Button("<----");
        Button rotateRightIn = new Button("---->");
        HBox girarc2 = new HBox();
        girarc2.setAlignment(Pos.CENTER);
        girarc2.getChildren().addAll(c2, rotateLeftIn,rotateRightIn);
        
        
        VBox botones = new VBox();
        botones.getChildren().addAll(girar, girarc2);
        
        BorderPane root = new BorderPane();
        root.setCenter(game.getRoot());
        root.setTop(botones);
        
        Scene scene = new Scene(root, width, heigth);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
