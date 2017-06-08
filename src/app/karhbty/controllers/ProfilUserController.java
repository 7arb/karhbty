package app.karhbty.controllers;

import static app.karhbty.datasource.ServiceFactory.connect;
import app.karhbty.datasource.Session;
import app.karhbty.entities.Utilisateur;
import app.karhbty.services.UserService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.net.URL;
import java.io.IOException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amira
 */
public class ProfilUserController implements Initializable {
    
    
    
     @FXML
    private AnchorPane AnchorPane;

    @FXML
    private SplitPane sPane;

    @FXML
    private AnchorPane AnchorPaneDroit;

    @FXML
    private Pane Pane11;

    @FXML
    private ImageView imgSearch;

    @FXML
    private JFXButton BtnRetour;

    @FXML
    private ImageView imgRetour;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private Label nomlab;

    @FXML
    private Label prenomlab;

    @FXML
    private Label cinlab;

    @FXML
    private Label emaillab;

    @FXML
    private Label tellab;

    @FXML
    private Label adresselab;

    @FXML
    private Label ResponsbleAElab;

    @FXML
    private Label responsableSMSlab;

    @FXML
    private Label responsableBoutlab;

    @FXML
    private AnchorPane AnchorPaneGauche;

    @FXML
    private Pane Pane21;

    @FXML
    private JFXTextField textTel;

    @FXML
    private JFXTextField textAdresse;

    @FXML
    private Pane Pane22;

    @FXML
    private JFXPasswordField TextAncienmdp;

    @FXML
    private JFXPasswordField Textnouvmdp;

    @FXML
    private JFXPasswordField Textconfirmmdp;

    @FXML
    private Pane Pane23;

    @FXML
    private JFXTextField textPhoto;

    @FXML
    private JFXButton btnOpen3;

    @FXML
    private Pane Pane24;

    @FXML
    private ImageView profilimg;

    @FXML
    private JFXButton Cleanbtn;

    @FXML
    private ImageView cleanimg;

    @FXML
    private JFXButton deletebtn;

    @FXML
    private ImageView deleteimg;

    @FXML
    private JFXButton modifybtn;

    @FXML
    private ImageView modifyimg;

    @FXML
    private JFXButton profilbtn;
       @FXML
    private JFXButton logoutbtn;
       @FXML
    private JFXButton btnnotif;
       
    @FXML
    private JFXListView<Utilisateur> listV;  
    
  UserService userDAO= new UserService(connect);

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
       nomlab.setText(Session.getInstance().getCurrent().getNom());
      prenomlab.setText(Session.getInstance().getCurrent().getPrenom());
      cinlab.setText(""+Session.getInstance().getCurrent().getCin());
      emaillab.setText(Session.getInstance().getCurrent().getEmail());
      tellab.setText(""+Session.getInstance().getCurrent().getTelephone());
      adresselab.setText(Session.getInstance().getCurrent().getAdresse());    
    } 

    
   
    
    @FXML
  public void Desactivate(ActionEvent event) throws IOException
  {
      
      userDAO.supprimer(Session.getInstance().getCurrent().getIdUtilisateur());
      logout(event);
      TrayNotification tray = new TrayNotification("Succes", " Profil supprimée avec succes",NotificationType.WARNING);
            tray.showAndDismiss(javafx.util.Duration.seconds(2));
      
  }
  
  @FXML
  public void CleanPerson(){
      TextAncienmdp.clear();
      Textconfirmmdp.clear();
      Textnouvmdp.clear();
      textAdresse.clear();
      textPhoto.clear();
      textTel.clear();
  }
  @FXML
  public void ModifyPerson(ActionEvent e)throws IOException{
      if((TextAncienmdp.getText().isEmpty())&&(Textconfirmmdp.getText().isEmpty())&&(Textnouvmdp.getText().isEmpty()))
              {
                  TrayNotification tray = new TrayNotification("Erreur", " Veuillez remplir les champs mot de passe",NotificationType.WARNING);
            tray.showAndDismiss(javafx.util.Duration.seconds(2)); 
           }  
  
      else if(!(TextAncienmdp.getText().equals(Session.getInstance().getCurrent().getPassword()))||(!(Textconfirmmdp.getText().equals(Textnouvmdp.getText())))){
        TrayNotification tray = new TrayNotification("Erreur", "mot de passe invalide",NotificationType.WARNING);
            tray.showAndDismiss(javafx.util.Duration.seconds(2)); 
      }      
     
      else{
         
    int tel=Integer.parseInt(textTel.getText());
    String adresse=textAdresse.getText();
    String mdp=Textconfirmmdp.getText();
    Utilisateur user2=new Utilisateur(tel,adresse,mdp,"");
    userDAO.modifier(user2,Session.getInstance().getCurrent().getIdUtilisateur());
    URL sceneToLoad = null;
         sceneToLoad = new File("src/app/karhbty/views/FXMLhomeDocument.fxml").toURL();
         Stage primaryStage = null;
   
        FXMLLoader fxmlLoader = new FXMLLoader(sceneToLoad);
        Parent root1 = (Parent) fxmlLoader.load();
        Node node = (Node) e.getSource();
        Stage stage = (Stage) node.getScene().getWindow() ;

        stage.setScene(new Scene(root1));
        stage.show();
        System.out.println("modification réussite"); 
      }
  }
  @FXML
  public void logout(ActionEvent e)throws IOException
  {  
     URL sceneToLoad = null;
        
        Session.logOut();
         sceneToLoad = new File("src/app/karhbty/views/LoginInterface.fxml").toURL();
         Stage primaryStage = null;
   
        FXMLLoader fxmlLoader = new FXMLLoader(sceneToLoad);
        Parent root1 = (Parent) fxmlLoader.load();
        Node node = (Node) e.getSource();
        Stage stage = (Stage) node.getScene().getWindow() ;

        stage.setScene(new Scene(root1));
        stage.show();
        System.out.println("Merci pour votre visite"); 
  }
        
    @FXML
    public void goBack(ActionEvent event) throws IOException {
            
        
        URL sceneToLoad = null;
        
         sceneToLoad = new File("src/app/karhbty/views/FXMLhomeDocument.fxml").toURL();
        Stage primaryStage = null;
   
        FXMLLoader fxmlLoader = new FXMLLoader(sceneToLoad);
        Parent root1 = (Parent) fxmlLoader.load();
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow() ;

        stage.setScene(new Scene(root1));
        stage.show();
        System.out.println("Vous etes dans l'acceuil");
    }
    @FXML
    public void goNotif(ActionEvent e)throws IOException{
         URL sceneToLoad = null;
        
        sceneToLoad = new File("src/app/karhbty/views/FXMLNotifUser.fxml").toURL();
        Stage primaryStage = null;
   
        FXMLLoader fxmlLoader = new FXMLLoader(sceneToLoad);
        Parent root1 = (Parent) fxmlLoader.load();
        Node node = (Node) e.getSource();
        Stage stage = (Stage) node.getScene().getWindow() ;

        stage.setScene(new Scene(root1));
        stage.show();
        System.out.println("Hello from Notif");
    }
}
  
