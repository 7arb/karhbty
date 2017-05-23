/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.karhbty.controllers;
import app.karhbty.datasource.ServiceFactory;
import javafx.fxml.FXMLLoader;
import app.karhbty.entities.Utilisateur;
import app.karhbty.services.UserService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author amira
 */
public class InscriUserController implements Initializable {
    
    


    @FXML
    private AnchorPane anochorPane;

    @FXML
    private SplitPane splitPane;

    @FXML
    private Button inscri;

    @FXML
    private Pane pane1;

    @FXML
    private Label conPassLab;

    @FXML
    private PasswordField conPassField;

    @FXML
    private Pane pane2;

    @FXML
    private Label emailLab;

    @FXML
    private TextField emailField;

    @FXML
    private Pane pane3;

    @FXML
    private Label namLab;

    @FXML
    private TextField nomField;

    @FXML
    private Pane pane4;

    @FXML
    private Label passLab;

    @FXML
    private PasswordField passField;

    @FXML
    private Pane pane6;

    @FXML
    private Label prenomLab;

    @FXML
    private TextField prenomField;
    
    @FXML
    private Label errorLab;

    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        // create user objet 

    }    
    public static Utilisateur user;
    public static UserService userDAO= (UserService) ServiceFactory.getUser();
    @FXML
    private void onInscriptionClicked(ActionEvent event) throws IOException
    { 
        
        URL sceneToLoad;
        // add user data to user object in initialize
        String email = this.emailField.getText();
        String password = this.passField.getText();
        String conpass = this.conPassLab.getText();
        
        String prenom = this.prenomField.getText();
        String nom = this.nomField.getText();
        
        if ((prenom.isEmpty())||(nom.isEmpty())||(password.
                isEmpty())||(conpass.isEmpty())||(email.isEmpty())){
            
            errorLab.setText("Veulliez complter les champs!!");
        }
        else{
            
            
            //sceneToLoad="InfoUser.fxml";
            user=new Utilisateur(prenom,nom,password,email);
            
            System.out.println(user);
        
//            userDAO.ajouter(user);
        
        sceneToLoad = new File ("src/app/karhbty/views/InfoUser.fxml").toURL();
        FXMLLoader fxmlloader=new FXMLLoader(sceneToLoad);
        Parent root1=(Parent) fxmlloader.load();
        Node node =(Node)event.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        stage.setTitle("info");
        stage.setScene(new Scene(root1));
        
//        InfoUserController controller=fxmlloader.<InfoUserController>getController();
//        controller.setUser(user);
//        
        stage.show();
    }
    }
}
