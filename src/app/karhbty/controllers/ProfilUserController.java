package app.karhbty.controllers;

import static app.karhbty.controllers.InfoUserController.u;
import app.karhbty.datasource.ServiceFactory;
import app.karhbty.datasource.Session;
import app.karhbty.entities.Utilisateur;
import app.karhbty.services.UserService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
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
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amira
 */
public class ProfilUserController /*implements Initializable*/ {
    
    
    
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
     
   
 /*@Override*/
    public void initialize(/*URL url, ResourceBundle rb*/) {
        UserService userDao= (UserService) ServiceFactory.getUser();
        Utilisateur ux = new Utilisateur();
//        ux = userDao.afficher(Session.getInstance().getCurrent().getIdUtilisateur());
      nomlab.setText(ux.getNom());
      prenomlab.setText(ux.getPrenom());
      cinlab.setText(""+ux.getCin());
      emaillab.setText(ux.getEmail());
      tellab.setText(""+ux.getTelephone());
      adresselab.setText(ux.getAdresse());
        
//        ShowPersonDetails();
//nomtf.setText(user.getNom());
//nomtf.setText(user.getNom());
    } 
  public void ShowPersonDetails()
  {
      
      nomlab.setText(u.getNom());
      prenomlab.setText(u.getPrenom());
      cinlab.setText(""+u.getCin());
      emaillab.setText(u.getEmail());
      tellab.setText(""+u.getTelephone());
      adresselab.setText(u.getAdresse());
      
   }
  public void Desactivate()
  {
//      UserService us =new UserService();
//      us.delete(user.getIdUtilisateur());
//      System.out.println(user.getIdUtilisateur());
//      
  }
  public void CleanPerson(){
      TextAncienmdp.clear();
      Textconfirmmdp.clear();
      Textnouvmdp.clear();
      textAdresse.clear();
      textPhoto.clear();
      textTel.clear();
  }
  public void ModifyPerson(){
//      Utilisateur u=new Utilisateur(user.getIdUtilisateur(),textTel.getText(),textAdresse.getText(),Textconfirmmdp.getText(),textPhoto.getText());
//      UtilisateurService us=new UtilisateurService();
//      us.modifier(u,user.getIdUtilisateur());
  }
        
    @FXML
    void goBack(ActionEvent event) throws IOException {
            
        
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
}
  
