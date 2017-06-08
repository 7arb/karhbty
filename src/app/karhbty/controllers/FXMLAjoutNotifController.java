/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.karhbty.controllers;

import app.karhbty.datasource.Controller;
import static app.karhbty.datasource.ServiceFactory.connect;
import app.karhbty.datasource.Session;
import app.karhbty.entities.Notification;
import app.karhbty.entities.Voiture;
import app.karhbty.services.NotificationService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author amira
 */
public class FXMLAjoutNotifController implements Initializable {

    @FXML
    private JFXTextField nomtf;

    @FXML
    private JFXRadioButton assurancebtn;

    @FXML
    private JFXRadioButton Pneubtn;

    @FXML
    private JFXRadioButton VTbtn;

    @FXML
    private JFXRadioButton Vignettebtn;

    @FXML
    private JFXRadioButton Vidangebtn;

    @FXML
    private JFXRadioButton Croixbtn;

    @FXML
    private JFXDatePicker dateReminder;
    @FXML
    private JFXButton okAjoutbtn;
    @FXML
    private ToggleGroup objetNotif;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
    } 
    public String radiobuttonvalue(){
        if (objetNotif.getSelectedToggle()==assurancebtn){
            System.out.println("assurance");
            return "assurance";
        }
        if (objetNotif.getSelectedToggle()==Croixbtn){
            return "croix";
        }
        if (objetNotif.getSelectedToggle()==Pneubtn){
            return "pneu";
        }
        if (objetNotif.getSelectedToggle()==VTbtn){
            return "Visite technique";
        }
        if (objetNotif.getSelectedToggle()==Vidangebtn){
            return "vidange";
        }if (objetNotif.getSelectedToggle()==Vignettebtn){
            return "vignette";
        }
        
     return null;   
    } 
    

    


    @FXML
    public void OkAjoutNotif(ActionEvent e)throws IOException{
        if(("".equals(nomtf.getText()))||((TextField)dateReminder.getEditor()==null)||(objetNotif.getSelectedToggle()==null))
        {
           TrayNotification tray = new TrayNotification("Erreur", "champs vide",NotificationType.WARNING);
            tray.showAndDismiss(javafx.util.Duration.seconds(2)); 
            
        }
        else
        {
       NotificationService ns=new NotificationService(connect);
       Notification n =new Notification(nomtf.getText(),Controller.convertFromJAVADateToSQLDate(Controller.asDate(dateReminder.getValue())),radiobuttonvalue(),1);
       ns.ajouter(n);
       //sendMailConfirmation s=new sendMailConfirmation("amirabm0601@gmail.com","ajout notif avec succes");
        TrayNotification tray = new TrayNotification("Succes", "Notification ajoutée avec succès",NotificationType.WARNING);
        tray.showAndDismiss(javafx.util.Duration.seconds(2));
        
    }
    }
//    public void goback(ActionEvent e)throws IOException{
//       URL sceneToLoad = new File("src/app/karhbty/views/NotifUserController.fxml").toURL();
//         Stage primaryStage = null;
//   
//        FXMLLoader fxmlLoader = new FXMLLoader(sceneToLoad);
//        Parent root1 = (Parent) fxmlLoader.load();
//        Node node = (Node) e.getSource();
//        Stage stage = (Stage) node.getScene().getWindow() ;
//
//        stage.setScene(new Scene(root1));
//        stage.show();
//        System.out.println("thanx for visit");
//    }
// 
    
}
