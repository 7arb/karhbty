/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.karhbty.controllers;

import static app.karhbty.datasource.ServiceFactory.connect;
import app.karhbty.entities.Voiture;
import app.karhbty.services.VoitureService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;


/**
 * FXML Controller class
 *
 * @author Saleh
 */

public class VoitureController implements Initializable {

    
    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private SplitPane sPane;

    @FXML
    private AnchorPane AnchorPaneDroit;

    @FXML
    private TableView<Voiture> TabView;


    @FXML
    private Pane Pane11;

    @FXML
    private JFXButton BtnRetour;

    @FXML
    private ImageView imgRetour;

    @FXML
    private AnchorPane AnchorPaneGauche;

    @FXML
    private Pane Pane21;

    @FXML
    private JFXTextField textCouleur;

    @FXML
    private JFXTextField textPuissance;

    @FXML
    private JFXTextField textKilometrage;

    @FXML
    private JFXTextField textMarque;

    @FXML
    private JFXTextField textModele;

    @FXML
    private JFXTextField textMatricule;

    @FXML
    private Label labCarburant;

    @FXML
    private JFXRadioButton radioDiesel;

    @FXML
    private ToggleGroup carb;

    @FXML
    private JFXRadioButton radioEssence;

    @FXML
    private Pane Pane22;

    @FXML
    private JFXDatePicker dateAssurance;

    @FXML
    private JFXDatePicker dateMecanique;

    @FXML
    private JFXDatePicker dateCroix;

    @FXML
    private JFXDatePicker dateVidange;

    @FXML
    private JFXDatePicker datePneu;

    @FXML
    private JFXDatePicker dateVigniette;

    @FXML
    private JFXDatePicker dateVisiTech;

    @FXML
    private Pane Pane23;

    @FXML
    private JFXTextField textPhoto1;

    @FXML
    private JFXTextField textPhoto2;

    @FXML
    private JFXTextField textPhoto3;

    @FXML
    private JFXButton btnOpen1;

    @FXML
    private JFXButton btnOpen2;

    @FXML
    private JFXButton btnOpen3;

    @FXML
    private Pane Pane24;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnView;

    @FXML
    private JFXButton btnClean;

    @FXML
    private JFXButton btnRemove;

    @FXML
    private ImageView imgAdd;

    @FXML
    private ImageView imgUpdate;

    @FXML
    private ImageView imgRemove;

    @FXML
    private ImageView imgView;

    @FXML
    private ImageView imgClean;
    
    @FXML
    private JFXTextField rech;
    
    private ObservableList<Voiture> datacar = FXCollections.observableArrayList();
    private ObservableList<Voiture> car = FXCollections.observableArrayList();
    VoitureService carDAO = new VoitureService(connect);

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        datacar = FXCollections.observableArrayList(carDAO.displayUserVoi());
        
        //Voiture
        
        TableColumn colId = new TableColumn("ID");
        colId.setPrefWidth(10);
        colId.setCellValueFactory(new PropertyValueFactory<>("id_voiture"));
        
        TableColumn carImmCol = new TableColumn("Immatriculation");
        carImmCol.setPrefWidth(100);
        carImmCol.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        
       
        TableColumn carMarqCol = new TableColumn("Marque");
        carMarqCol.setPrefWidth(85);
        carMarqCol.setCellValueFactory(new PropertyValueFactory<>("marque"));

        TableColumn carModCol = new TableColumn("Modele");
        carModCol.setPrefWidth(82);
        carModCol.setCellValueFactory(new PropertyValueFactory<>("modele"));

        TableColumn carCouCol = new TableColumn("Couleur");
        carCouCol.setPrefWidth(75);
        carCouCol.setCellValueFactory(new PropertyValueFactory<>("couleur"));
        
        TableColumn carPuissCol = new TableColumn("Puissance Fiscal");
        carPuissCol.setPrefWidth(114);
        carPuissCol.setCellValueFactory(new PropertyValueFactory<>("nbr_cheveaux"));
        
        TableColumn carKiloCol = new TableColumn("Kilometrage");
        carKiloCol.setPrefWidth(124);
        carKiloCol.setCellValueFactory(new PropertyValueFactory<>("kilometrage"));
        
        TabView.getColumns().addAll(colId, carImmCol, carMarqCol, carModCol, carCouCol, carPuissCol, carKiloCol);
        TabView.setItems(datacar);
    }    
    
    @FXML
    void getVoiByMarque(ActionEvent event) throws IOException {
        
        
            
        
            car = FXCollections.observableArrayList(carDAO.rechercheVoiture(rech.getText()));
            System.out.println(car);
        //Voiture
        
        TableColumn colId = new TableColumn("ID");
        colId.setPrefWidth(10);
        colId.setCellValueFactory(new PropertyValueFactory<>("id_voiture"));
        
        TableColumn carImmCol = new TableColumn("Immatriculation");
        carImmCol.setPrefWidth(100);
        carImmCol.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        
       
        TableColumn carMarqCol = new TableColumn("Marque");
        carMarqCol.setPrefWidth(85);
        carMarqCol.setCellValueFactory(new PropertyValueFactory<>("marque"));

        TableColumn carModCol = new TableColumn("Modele");
        carModCol.setPrefWidth(82);
        carModCol.setCellValueFactory(new PropertyValueFactory<>("modele"));

        TableColumn carCouCol = new TableColumn("Couleur");
        carCouCol.setPrefWidth(75);
        carCouCol.setCellValueFactory(new PropertyValueFactory<>("couleur"));
        
        TableColumn carPuissCol = new TableColumn("Puissance Fiscal");
        carPuissCol.setPrefWidth(114);
        carPuissCol.setCellValueFactory(new PropertyValueFactory<>("nbr_cheveaux"));
        
        TableColumn carKiloCol = new TableColumn("Kilometrage");
        carKiloCol.setPrefWidth(124);
        carKiloCol.setCellValueFactory(new PropertyValueFactory<>("kilometrage"));
        
        TabView.getColumns().addAll(colId, carImmCol, carMarqCol, carModCol, carCouCol, carPuissCol, carKiloCol);
        
        TabView.setItems(car);
        
        TrayNotification tray = new TrayNotification("Succes", " Voiture trouvée",NotificationType.SUCCESS);
            tray.showAndDismiss(javafx.util.Duration.seconds(2));
        
        
    }
 
    
    
    
    
    @FXML
    void goBack(ActionEvent event) throws IOException {
            
        
        URL sceneToLoad = null;
        String title = null;
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

//        @FXML
//    void onAddClicked2(ActionEvent event) throws IOException {
//        Voiture v = new Voiture (
//        textMarque.getText(),
//        textModele.getText(),
//        textMatricule.getText(),
//        textCouleur.getText(),
//        Integer.parseInt(textPuissance.getText()),
//        Integer.parseInt(textKilometrage.getText()),
//        carb.getSelectedToggle().getUserData().toString(),
//        dateMecanique.getValue(),
//        dateCroix.getValue(),
//        dateVidange.getValue(),
//        dateAssurance.getValue(),
//        dateVisiTech.getValue(),
//        dateVigniette.getValue(),
//        datePneu.get
//        
//        );
//        
//        
//        VoitureService vdao = new VoitureService(connect);
//    }
    
    @FXML
    void onAddClicked(ActionEvent event) throws IOException {
//        
//        UserService userDAO = (UserService) ServiceFactory.getUser();
//        VoitureService carDAO = new VoitureService(connect);
//        URL sceneToLoad = null;
//        String title = null;
//        
//        String marque = textMarque.getText();
//        String modele = textModele.getText();
//        String mat = textMatricule.getText();
//        String couleur = textCouleur.getText();
//        int puiss = Integer.parseInt(textPuissance.getText());
//        int kilomet = Integer.parseInt(textKilometrage.getText());
//        String carburant = carb.getSelectedToggle().getUserData().toString();
////        //Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
////        //Date mec = Date.from(LocalDate.atStartOfDay(dateMecnique.systemDefault()).toInstant());
////        //Date mec = java.util.Date.from(dateMecanique);
////        //LocalDate mec = dateMecanique.getValue();
//////        LocalDate croix = dateCroix.getValue();
//////        LocalDate vid = dateVidange.getValue();
//////        LocalDate assu = dateAssurance.getValue();
//////        LocalDate visitech = dateVisiTech.getValue();
//////        LocalDate vigni = dateVigniette.getValue();
//////        LocalDate pneu = datePneu.getValue();
//////        
////        
        //LocalDate mecdate =dateMecanique.getValue();
//Instant instant1 = Instant.from(mecdate.atStartOfDay(ZoneId.of("GMT")));
//Date mec = Date.from(instant1);
//        LocalDate croidate =dateCroix.getValue();
//Instant instant2 = Instant.from(croidate.atStartOfDay(ZoneId.of("GMT")));
//Date croix = Date.from(instant2);
//LocalDate vidate =dateVidange.getValue();
//Instant instant3 = Instant.from(vidate.atStartOfDay(ZoneId.of("GMT")));
//Date vid = Date.from(instant3);
//LocalDate assudate =dateAssurance.getValue();
//Instant instant4 = Instant.from(assudate.atStartOfDay(ZoneId.of("GMT")));
//Date assu = Date.from(instant4);
//LocalDate visdate =dateVisiTech.getValue();
//Instant instant5 = Instant.from(visdate.atStartOfDay(ZoneId.of("GMT")));
//Date visitech = Date.from(instant5);
//LocalDate vigdate =dateVigniette.getValue();
//Instant instant6 = Instant.from(vigdate.atStartOfDay(ZoneId.of("GMT")));
//Date vigni = Date.from(instant6);
//LocalDate pdate =datePneu.getValue();
//Instant instant7 = Instant.from(pdate.atStartOfDay(ZoneId.of("GMT")));
//Date pneu = Date.from(instant7);
//        //Voiture car = new Voiture(mat,marque,modele,mec,couleur,puiss,kilomet,carburant,Session.getInstance().getCurrent().getIdUtilisateur(),assu,pneu,visitech,croix,vid,vigni,"","","",Session.getInstance().getCurrent().getIdUtilisateur());
//        carDAO.ajouterv3(mat,marque,modele,mec,couleur,puiss,kilomet,carburant,Session.getInstance().getCurrent().getIdUtilisateur(),assu,pneu,visitech,croix,vid,vigni,"","","",Session.getInstance().getCurrent().getIdUtilisateur());
//        
//         TrayNotification tray = new TrayNotification("Succes", " Voiture ajoutée avec succes",NotificationType.SUCCESS);
//            tray.showAndDismiss(javafx.util.Duration.seconds(2));
    }
    
    @FXML
    private void deleteCar(ActionEvent event) {
        if (TabView.getSelectionModel().getSelectedIndices().size() > 0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Verifier votre choix");
            System.out.println(TabView.getSelectionModel().getSelectedItem());
            alert.setContentText("Etes-vous sûre de vouloir supprimer?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                carDAO.delete(TabView.getSelectionModel().getSelectedItem());

                List<Voiture> list = carDAO.displayUserVoi();
                datacar = FXCollections.observableArrayList(list);
                TabView.setItems(datacar);
                

                alert.setTitle("Succes");
                alert.setHeaderText(null);
                alert.setContentText("voiture supprimer avec succés");
                alert.showAndWait();

                TrayNotification tray = new TrayNotification("Succes", " Voiture supprimée avec succes",NotificationType.SUCCESS);
            tray.showAndDismiss(javafx.util.Duration.seconds(2));
            } else {
                // ... user chose CANCEL or closed the dialog
            }

        }
    }
    
    @FXML private void nettoyage (ActionEvent event) {
        
        textMarque.clear();
        textModele.clear();
        textModele.clear();
        textCouleur.clear();
        textMatricule.clear();
        textKilometrage.clear();
        textPhoto1.clear();
        textPhoto2.clear();
        textPhoto3.clear();
        textPuissance.clear();
        dateAssurance.setValue(null);
        dateCroix.setValue(null);
        dateMecanique.setValue(null);
        datePneu.setValue(null);
        dateVidange.setValue(null);
        dateVigniette.setValue(null);
        dateVisiTech.setValue(null);
        carb.selectToggle(null);
    }
    
}
