/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.karhbty.controllers;

import app.karhbty.datasource.ServiceFactory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


import com.jfoenix.controls.JFXButton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Saleh
 */
public class FXMLAdminHomeDocumentController implements Initializable {

    /**
     * Initializes the controller class.
     */

    @FXML
    private AnchorPane homeAdmin;

    @FXML
    private Pane backgroundPaneAdmin;

    @FXML
    private GridPane gridPadmin;

    @FXML
    private Pane Padmin;

    @FXML
    private JFXButton histoVoiture;

    @FXML
    private ImageView imgVoiture;

    @FXML
    private Pane Puser;

    @FXML
    private JFXButton histoUser;

    @FXML
    private ImageView imgUser;

    @FXML
    private Pane Pcommentaire;

    @FXML
    private JFXButton gererCommentaire;

    @FXML
    private ImageView imgCommentaire;

    @FXML
    private Pane Pstatis;

    @FXML
    private JFXButton btnStatis;

    @FXML
    private ImageView imgStatis;

    @FXML
    private Label lblKarhbty;
            



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
FadeTransition fadeout = new FadeTransition(Duration.seconds(2.5), backgroundPaneAdmin);
            fadeout.setFromValue(1);
            fadeout.setToValue(0);
            fadeout.play();
                
            fadeout.setOnFinished(event -> {
                    
                backgroundPaneAdmin.setStyle(" -fx-background-image: url(\"/app/karhbty/medias/image1.jpg\")");

                FadeTransition fadein = new FadeTransition(Duration.seconds(2.5), backgroundPaneAdmin);
                fadein.setFromValue(0);
                fadein.setToValue(0.6);
                fadein.play();

                fadein.setOnFinished(e -> {

                    backgroundPaneAdmin.setStyle(" -fx-background-image: url(\"/app/karhbty/medias/image2.jpg\");");
                    FadeTransition fadein2 = new FadeTransition(Duration.seconds(2.5), backgroundPaneAdmin);
                    fadein2.setFromValue(0);
                    fadein2.setToValue(1);
                    fadein2.play();

                    fadein2.setOnFinished(event2 -> {

                        backgroundPaneAdmin.setStyle(" -fx-background-image: url(\"/app/karhbty/medias/image3.jpg\");");

                        FadeTransition fadein3 = new FadeTransition(Duration.seconds(2.5), backgroundPaneAdmin);
                        fadein3.setFromValue(1);
                        fadein3.setToValue(0);
                        fadein3.play();

                        fadein3.setOnFinished(event3 -> {
                            backgroundPaneAdmin.setStyle(" -fx-background-image:url(\"/app/karhbty/medias/image4.jpg\");");

                            FadeTransition fadein4 = new FadeTransition(Duration.seconds(2.5), backgroundPaneAdmin);
                            fadein4.setFromValue(0);
                            fadein4.setToValue(1);
                            fadein4.play();

                            fadein4.setOnFinished(event4 -> {
                                backgroundPaneAdmin.setStyle(" -fx-background-image: url(\"/app/karhbty/medias/image5.jpg\");");

                                FadeTransition fadein5 = new FadeTransition(Duration.seconds(2.5), backgroundPaneAdmin);
                                fadein5.setFromValue(0);
                                fadein5.setToValue(1);
                                fadein5.play();
                                
                            fadein5.setOnFinished(event5 -> {
                                backgroundPaneAdmin.setStyle(" -fx-background-image: url(\"/app/karhbty/medias/image6.jpg\");");

                                FadeTransition fadein6 = new FadeTransition(Duration.seconds(2.5), backgroundPaneAdmin);
                                fadein6.setFromValue(0);
                                fadein6.setToValue(1);
                                fadein6.play();
                    
                            fadein6.setOnFinished(event6 -> {
                                backgroundPaneAdmin.setStyle(" -fx-background-image: url(\"/app/karhbty/medias/image7.jpg\");");

                                FadeTransition fadein7 = new FadeTransition(Duration.seconds(2.5), backgroundPaneAdmin);
                                fadein7.setFromValue(0);
                                fadein7.setToValue(1);
                                fadein7.play();
                        
                            fadein7.setOnFinished(event7 -> {
                                backgroundPaneAdmin.setStyle(" -fx-background-image: url(\"/app/karhbty/medias/image5.jpg\");");

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
    private void chartview(ActionEvent event) {
   
PieChart pieChart = new PieChart();
Connection c;
ObservableList data;
data = FXCollections.observableArrayList();
try {
    
    //SQL FOR SELECTING CUSTOMERS
    //String req = "select nom , count(V.id_utilisateur) ,U.id_utilisateur from utilisateur U , voiture V where U.id_utilisateur=V.id_utilisateur group by id_utilisateur";
    //String req = "select marque, count(V.id_voiture) from utilisateur U , voiture V where U.id_utilisateur=V.id_utilisateur group by id_voiture";
    String req = "select modele, count(V.id_voiture) from utilisateur U , voiture V where U.id_utilisateur=V.id_utilisateur group by id_voiture,marque";
    PreparedStatement ps = ServiceFactory.connect.prepareStatement(req);
    
    ResultSet rs = ps.executeQuery();
    
    while (rs.next()) {
        
        //adding data on piechart data
        data.add(new PieChart.Data(rs.getString(1), rs.getInt(2)));
        
    }
    
} catch (Exception e) {
    
    System.out.println("Error on DB connection");
    
    return;
    
}
pieChart.getData().addAll(data);
//Main Scene
Scene scene = new Scene(pieChart);
Stage stage = new Stage();
stage.setScene(scene);
stage.show();
//--
    }
//@FXML
//    private void onStatClicked(ActionEvent event) throws IOException
//    {   
//        
//        
//        URL sceneToLoad = new File ("src/app/karhbty/views/FXMLStatAdmin.fxml").toURL();
//        String title = null;
//        
//        Stage primaryStage = null;
//            
//
//        FXMLLoader fxmlLoader = new FXMLLoader(sceneToLoad);
//        Parent root1 = (Parent) fxmlLoader.load();
//        Node node = (Node) event.getSource();
//        Stage stage = (Stage) node.getScene().getWindow() ;
//        
//        stage.setTitle(title);
//        stage.setScene(new Scene(root1));
//        stage.show();
//            
//            
//    }
}
