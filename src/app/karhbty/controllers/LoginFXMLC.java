/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.karhbty.controllers;


import app.karhbty.datasource.ServiceFactory;
import app.karhbty.datasource.Session;
import app.karhbty.entities.Administrateur;
import app.karhbty.entities.Utilisateur;
import app.karhbty.services.UserService;


import java.io.File;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 *
 * @author Saleh
 */
public class LoginFXMLC implements Initializable  {
    
    @FXML
    private MediaView loginMediaView;
    //
    MediaPlayer mediaplayer = new MediaPlayer(new Media(getClass().getResource("Login.flv").toString()));
    @FXML
    private CheckBox desactiverAnimation;
    @FXML
    private CheckBox desactiverMusique;
    @FXML
    private TextField username;
    @FXML
    private TextField userpassword;
    @FXML
    private Label erreuroutput;
     @FXML
    private JFXButton connexion;

    @FXML
    private Hyperlink mdpoubliee;

    @FXML
    private Hyperlink inscrivous;
@FXML
    private JFXButton btnnotif;
  
    @FXML
    private void DesactiverAnimationClicked()
    {
        Status status = mediaplayer.getStatus();
        if (status == Status.UNKNOWN  || status == Status.HALTED)
        { }
        if( status == Status.PLAYING || status == Status.PAUSED || status == Status.READY || status == Status.STOPPED) {
            if(desactiverAnimation.isSelected())
                mediaplayer.pause();
            else
                mediaplayer.play();
        }
        
    }
    
    @FXML
    private void desactiverMusiqueClicked()
    {
        if(desactiverMusique.isSelected()){
            mediaplayer.setMute(true);
        }
            
        else {
                mediaplayer.setMute(false);
        }
            
    }
    
    @FXML
    public  void onConnexionClicked(ActionEvent event) throws IOException
    {   
        
        UserService userDAO = (UserService) ServiceFactory.getUser();
        URL sceneToLoad = null;
        String title = null;
        String name = this.username.getText();
        String password = this.userpassword.getText();
        
        Utilisateur userCo =userDAO.findByEmail(name, password);
        
        System.out.println(userCo);
        if(userCo!=(null))
        {
            if(userCo instanceof Administrateur){
                sceneToLoad = new File("src/app/karhbty/views/FXMLAdminHomeDocument.fxml").toURL();
               
                title=userCo.getPrenom()+" Interface";
                System.out.println("Welcome");
            }
            else if(userCo instanceof Utilisateur){
                sceneToLoad = new File("src/app/karhbty/views/FXMLhomeDocument.fxml").toURL();
               
                title=userCo.getPrenom()+" Interface";
                System.out.println("Welcome");
            }
            
            Session.connect(userCo);
            
        Stage primaryStage = null;
        mediaplayer.stop();
            

        FXMLLoader fxmlLoader = new FXMLLoader(sceneToLoad);
        Parent root1 = (Parent) fxmlLoader.load();
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow() ;
        
        stage.setTitle(title);
        stage.setScene(new Scene(root1));
        stage.show();
            
            System.out.println("connected");
            System.out.println("Vous etes dans l'acceuil");
        }
        else
            erreuroutput.setText("Le nom d'utilisateur ou la mot de passe sont incorrect");
    }
    
    public void inscriverVous(ActionEvent event) throws IOException 
    {   
        System.out.println("inscriver vous");
       
  mediaplayer.stop();
     URL sceneToLoad = null;
        String title = null;
         sceneToLoad = new File("src/app/karhbty/views/InscriUser.fxml").toURL();
   Stage primaryStage = null;
   
        FXMLLoader fxmlLoader = new FXMLLoader(sceneToLoad);
        Parent root1 = (Parent) fxmlLoader.load();
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow() ;

        stage.setScene(new Scene(root1));
        stage.show();
        System.out.println("Vous etes dans la page inscription");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //checkbox
        //
        loginMediaView.setLayoutX(0);
        loginMediaView.setLayoutY(0);
        loginMediaView.setFitHeight(600);
        loginMediaView.setFitWidth(846);
        //set
        mediaplayer.setAutoPlay(true);
        //mediaplayer.setCycleCount(MediaPlayer.INDEFINITE);
        //setplayer
        loginMediaView.setMediaPlayer(mediaplayer);
        
        
    } 
}