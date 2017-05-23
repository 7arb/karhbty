/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.karhbty.controllers;

import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Saleh
 */
public class AcceuilController implements Initializable {

        @FXML
    private AnchorPane home;

    @FXML
    private Pane backgroundPane;

    @FXML
    private Pane ss;

    @FXML
    private JFXButton gereVoiture;

    @FXML
    private JFXButton ventAchatVoiture;

    @FXML
    private JFXButton sms;

    @FXML
    private JFXButton autoEcole;

    @FXML
    private JFXButton ventAchatPiece;

    @FXML
    private JFXButton profile;

    @FXML
    private JFXButton histo;

public static AnchorPane p ;
    public  static StackPane m ;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            
            FadeTransition fadeout = new FadeTransition(Duration.seconds(2.5), backgroundPane);
            fadeout.setFromValue(1);
            fadeout.setToValue(0);
            fadeout.play();
                
            fadeout.setOnFinished(event -> {
                    
                backgroundPane.setStyle(" -fx-background-image: url(\"/app/karhbty/medias/image1.jpg\")");

                FadeTransition fadein = new FadeTransition(Duration.seconds(2.5), backgroundPane);
                fadein.setFromValue(0);
                fadein.setToValue(0.6);
                fadein.play();

                fadein.setOnFinished(e -> {

                    backgroundPane.setStyle(" -fx-background-image: url(\"/app/karhbty/medias/image2.jpg\");");
                    FadeTransition fadein2 = new FadeTransition(Duration.seconds(2.5), backgroundPane);
                    fadein2.setFromValue(0);
                    fadein2.setToValue(1);
                    fadein2.play();

                    fadein2.setOnFinished(event2 -> {

                        backgroundPane.setStyle(" -fx-background-image: url(\"/app/karhbty/medias/image3.jpg\");");

                        FadeTransition fadein3 = new FadeTransition(Duration.seconds(2.5), backgroundPane);
                        fadein3.setFromValue(1);
                        fadein3.setToValue(0);
                        fadein3.play();

                        fadein3.setOnFinished(event3 -> {
                            backgroundPane.setStyle(" -fx-background-image:url(\"/app/karhbty/medias/image4.jpg\");");

                            FadeTransition fadein4 = new FadeTransition(Duration.seconds(2.5), backgroundPane);
                            fadein4.setFromValue(0);
                            fadein4.setToValue(1);
                            fadein4.play();

                            fadein4.setOnFinished(event4 -> {
                                backgroundPane.setStyle(" -fx-background-image: url(\"/app/karhbty/medias/image5.jpg\");");

                                FadeTransition fadein5 = new FadeTransition(Duration.seconds(2.5), backgroundPane);
                                fadein5.setFromValue(0);
                                fadein5.setToValue(1);
                                fadein5.play();
                                
                            fadein5.setOnFinished(event5 -> {
                                backgroundPane.setStyle(" -fx-background-image: url(\"/app/karhbty/medias/image6.jpg\");");

                                FadeTransition fadein6 = new FadeTransition(Duration.seconds(2.5), backgroundPane);
                                fadein6.setFromValue(0);
                                fadein6.setToValue(1);
                                fadein6.play();
                    
                            fadein6.setOnFinished(event6 -> {
                                backgroundPane.setStyle(" -fx-background-image: url(\"/app/karhbty/medias/image7.jpg\");");

                                FadeTransition fadein7 = new FadeTransition(Duration.seconds(2.5), backgroundPane);
                                fadein7.setFromValue(0);
                                fadein7.setToValue(1);
                                fadein7.play();
                        
                            fadein7.setOnFinished(event7 -> {
                                backgroundPane.setStyle(" -fx-background-image: url(\"/app/karhbty/medias/image5.jpg\");");

                            });

                        });
                    });

                });

            });
        });
    });            
                    
                    });
            
                }
                    

    

    @FXML
    private void goProfile(ActionEvent event) throws IOException {
        URL sceneToLoad = null;
        
         sceneToLoad = new File("src/app/karhbty/views/ProfilUser.fxml").toURL();
   Stage primaryStage = null;
   
        FXMLLoader fxmlLoader = new FXMLLoader(sceneToLoad);
        Parent root1 = (Parent) fxmlLoader.load();
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow() ;
        
        stage.setScene(new Scene(root1));
        stage.show();
        System.out.println("Vous etes dans votre profil");    
    }

       
   
     @FXML
    void GoSms(ActionEvent event) {

    }

    @FXML
    void GoVentAchatVoiture(ActionEvent event) {

    }

    @FXML
    void goAchatVentPiece(ActionEvent event) {

    }

    @FXML
    void goAutoEcole(ActionEvent event) {

    }

    @FXML
    void goHisto(ActionEvent event) {

    }

    

    @FXML
    void goProfileVoiture(ActionEvent event) throws IOException {
            
        
        URL sceneToLoad = null;
        String title = null;
         sceneToLoad = new File("src/app/karhbty/views/FXMLVoiture.fxml").toURL();
   Stage primaryStage = null;
   
        FXMLLoader fxmlLoader = new FXMLLoader(sceneToLoad);
        Parent root1 = (Parent) fxmlLoader.load();
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow() ;

        stage.setScene(new Scene(root1));
        stage.show();
        System.out.println("Vous etes dans profil voiture");
    }

}
        // TODO
      
    

