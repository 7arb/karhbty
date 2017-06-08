/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.karhbty.controllers;

import static app.karhbty.datasource.ServiceFactory.connect;
import app.karhbty.entities.Notification;
import app.karhbty.entities.Voiture;
import app.karhbty.services.NotificationService;
import app.karhbty.services.VoitureService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author amira
 */
public class FXMLNotifUserController implements Initializable {

    /**
     * Initializes the controller class.
     */
    

    @FXML
    private JFXButton newbtn;

    @FXML
    private JFXButton updatebtn;

    @FXML
    private JFXButton deletebtn;
     @FXML
    private TableView<Voiture> tabview;
     @FXML
    private TableView <Notification> tabNotifView;
    
    private ObservableList<Voiture> datacar = FXCollections.observableArrayList();
    private ObservableList<Notification> datanotif= FXCollections.observableArrayList();
    VoitureService carDAO = new VoitureService(connect);
    NotificationService ns=new NotificationService(connect);
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        datacar = FXCollections.observableArrayList(carDAO.afficherVoitureNotif());
        datanotif=FXCollections.observableArrayList();
        //tableview de voiture
        TableColumn colId = new TableColumn("ID");
        colId.setPrefWidth(10);
        colId.setCellValueFactory(new PropertyValueFactory<>("id_voiture"));
        
        
        TableColumn colMatr = new TableColumn("Voiture");
        colMatr.setPrefWidth(200);
        colMatr.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        tabview.getColumns().addAll(colId,colMatr);
        tabview.setItems(datacar);
        
        //tablenotifview de notif
        TableColumn ColIdNotif=new TableColumn("Id");
        ColIdNotif.setPrefWidth(23);
        ColIdNotif.setCellValueFactory(new PropertyValueFactory<>("id_notification"));
        
        TableColumn ColLibNotif=new TableColumn("Libelle");
        ColLibNotif.setPrefWidth(170);
        ColLibNotif.setCellValueFactory(new PropertyValueFactory<>("libelle_notification"));
           
        TableColumn ColDateNotif=new TableColumn("Date");
        ColDateNotif.setPrefWidth(170);
        ColDateNotif.setCellValueFactory(new PropertyValueFactory("date_notification"));
        
        TableColumn ColObjNotif=new TableColumn("Objet");
        ColObjNotif.setPrefWidth(290);
        ColObjNotif.setCellValueFactory(new PropertyValueFactory<>("objet_notification"));
                
//        TableColumn ColIdVoiture=new TableColumn("id_voiture");
//        ColObjNotif.setPrefWidth(10);
//        ColObjNotif.setCellValueFactory(new PropertyValueFactory<>("id_voiture"));
        tabNotifView.getColumns().addAll(ColIdNotif,ColLibNotif,ColDateNotif,ColObjNotif);
        
        tabview.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                List<Notification> list =ns.displayAllNotifbyVoiture(newSelection);
                datanotif = FXCollections.observableArrayList(list);
                tabNotifView.setItems(datanotif);
            }
        });
    }
    @FXML
    public void AjoutNotif(ActionEvent e) throws IOException
    {
       
       URL sceneToLoad=null;
       sceneToLoad = new File ("src/app/karhbty/views/FXMLAjoutNotif.fxml").toURL();
       FXMLLoader fxmlloader=new FXMLLoader(sceneToLoad);
       Parent root1=(Parent) fxmlloader.load();
       Node node =(Node)e.getSource();
       Stage stage=(Stage) node.getScene().getWindow();
       stage.setTitle("New Reminder");
       stage.setScene(new Scene(root1));
       System.out.println("salut");
    
    }
   
   
       

        
    
    @FXML
    public void SuppNotif(ActionEvent e)throws IOException{
         if (tabNotifView.getSelectionModel().getSelectedIndices().size() > 0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Verifier votre choix");
            alert.setContentText("Etes-vous sûre de vouloir supprimer?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                ns.supprimer(tabNotifView.getSelectionModel().getSelectedItem());

                List<Notification> list = ns.displayAllNotifbyVoiture(tabview.getSelectionModel().getSelectedItem());
                datanotif = FXCollections.observableArrayList(list);
                tabNotifView.setItems(datanotif);

                alert.setTitle("Succes");
                alert.setHeaderText(null);
                alert.setContentText("Notification supprimée avec succés");
                alert.showAndWait();

            } else {
                // ... user chose CANCEL or closed the dialog
            }
    }
    }
    @FXML
    public void ModifNotif(ActionEvent e)throws IOException{
        URL sceneToLoad=null;
       sceneToLoad = new File ("src/app/karhbty/views/FXMLModifNotif.fxml").toURL();
       FXMLLoader fxmlloader=new FXMLLoader(sceneToLoad);
       Parent root1=(Parent) fxmlloader.load();
       Node node =(Node)e.getSource();
       Stage stage=(Stage) node.getScene().getWindow();
       stage.setTitle("New Reminder");
       stage.setScene(new Scene(root1));
       System.out.println("salut");
    }
    
}
