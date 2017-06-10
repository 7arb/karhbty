/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.karhbty.controllers;

import app.karhbty.datasource.Controller;
import static app.karhbty.datasource.ServiceFactory.connect;
import app.karhbty.datasource.Session;
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
import java.net.MalformedURLException;
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
public class FXMLAdminHistoVoitureController implements Initializable {

    @FXML
    private SplitPane sPane;

    @FXML
    private AnchorPane AnchorPaneDroit;

    @FXML
    private TableView<Voiture> TabView;

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
    private JFXTextField rech;

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
    private ImageView imgCancel;

    @FXML
    private ImageView imgUp;

    @FXML
    private JFXButton btnPdf;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnView;

    @FXML
    private JFXButton btnClean;

    @FXML
    private JFXButton btnRemove;

    @FXML
    private ImageView imgPdf;

    @FXML
    private ImageView imgUpdate;

    @FXML
    private ImageView imgRemove;

    @FXML
    private ImageView imgView;

    @FXML
    private ImageView imgClean;

    @FXML
    private JFXButton btnUp;

    @FXML
    private JFXButton btnCancel;
    
    private ObservableList<Voiture> datacar = FXCollections.observableArrayList();
    private ObservableList<Voiture> car = FXCollections.observableArrayList();
    VoitureService carDAO = new VoitureService(connect);
    Voiture voi = new Voiture();

    @FXML
    void deleteCar(ActionEvent event) {
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

    @FXML
    void getVoiByMarque(ActionEvent event) {
        
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
    void goBack(ActionEvent event) throws MalformedURLException, IOException {
        URL sceneToLoad = null;
        sceneToLoad = new File("src/app/karhbty/views/FXMLAdminHomeDocument.fxml").toURL();
   
        FXMLLoader fxmlLoader = new FXMLLoader(sceneToLoad);
        Parent root1 = (Parent) fxmlLoader.load();
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow() ;

        stage.setScene(new Scene(root1));
        stage.show();
        System.out.println("Vous etes dans l'acceuil");
    }

    @FXML
    void nettoyage(ActionEvent event) {
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

    @FXML
    void onAddClicked(ActionEvent event) throws MalformedURLException, IOException {
        String carburant=null;
        String marque = textMarque.getText();
        String modele = textModele.getText();
        String mat = textMatricule.getText();
        String couleur = textCouleur.getText();
        int puiss = Integer.parseInt(textPuissance.getText());
        int kilomet = Integer.parseInt(textKilometrage.getText());
        
        if (carb.getSelectedToggle()==radioDiesel){
            carburant="diesel";
        }else if (carb.getSelectedToggle()==radioEssence){
            carburant="essence";
        } 
       
        
        voi = new Voiture(mat,marque,modele,
                Controller.asDate(dateMecanique.getValue()),
                couleur,puiss,kilomet,carburant,
                Session.getInstance().getCurrent().getIdUtilisateur(),
                Controller.asDate(dateAssurance.getValue()),
                Controller.asDate(datePneu.getValue()),
                Controller.asDate(dateVisiTech.getValue()),
                Controller.asDate(dateCroix.getValue()),
                Controller.asDate(dateVidange.getValue()),
                Controller.asDate(dateVigniette.getValue()),
                "","","",Session.getInstance().getCurrent().getIdUtilisateur());
        
        carDAO.ajouterv2(voi);
        
         TrayNotification tray = new TrayNotification("Succes", " Voiture ajoutée avec succes",NotificationType.SUCCESS);
            tray.showAndDismiss(javafx.util.Duration.seconds(2));
            
            URL sceneToLoad = null;
        String title = null;
         sceneToLoad = new File("src/app/karhbty/views/FXMLAdminHistoVoiture.fxml").toURL();
   Stage primaryStage = null;
   
        FXMLLoader fxmlLoader = new FXMLLoader(sceneToLoad);
        Parent root1 = (Parent) fxmlLoader.load();
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow() ;

        stage.setScene(new Scene(root1));
        stage.show();
        System.out.println("Vous etes dans profil voiture");
    }

    @FXML
    void onAffichClicked(ActionEvent event) {
        if (TabView.getSelectionModel().getSelectedIndices().size() > 0) {
            textMarque.setText(TabView.getSelectionModel().getSelectedItem().getMarque());
            textModele.setText(TabView.getSelectionModel().getSelectedItem().getModele());
            textCouleur.setText(TabView.getSelectionModel().getSelectedItem().getCouleur());
            textMatricule.setText(TabView.getSelectionModel().getSelectedItem().getMatricule());
            String kilo= Integer.toString(TabView.getSelectionModel().getSelectedItem().getKilometrage());
            textKilometrage.setText(kilo);
            String nbrch = Integer.toString(TabView.getSelectionModel().getSelectedItem().getNbr_cheveaux());
            textPuissance.setText(nbrch);
            textPhoto1.setText(TabView.getSelectionModel().getSelectedItem().getPhoto1());
            textPhoto2.setText(TabView.getSelectionModel().getSelectedItem().getPhoto2());
            textPhoto3.setText(TabView.getSelectionModel().getSelectedItem().getPhoto3());
            //dateMecanique.setValue(TabView.getSelectionModel().getSelectedItem().getDate_mec());
            if ("diesel".equals(TabView.getSelectionModel().getSelectedItem().getEnergie())){
                carb.selectToggle(radioDiesel);
            }else {
                carb.selectToggle(radioEssence);
            }
        }
    }

    @FXML
    void onUpdateClicked(ActionEvent event) throws IOException {
    
        if (TabView.getSelectionModel().getSelectedIndices().size() > 0) {
            textMarque.setText(TabView.getSelectionModel().getSelectedItem().getMarque());
            textModele.setText(TabView.getSelectionModel().getSelectedItem().getModele());
            textCouleur.setText(TabView.getSelectionModel().getSelectedItem().getCouleur());
            textMatricule.setText(TabView.getSelectionModel().getSelectedItem().getMatricule());
            String kilo= Integer.toString(TabView.getSelectionModel().getSelectedItem().getKilometrage());
            textKilometrage.setText(kilo);
            String nbrch = Integer.toString(TabView.getSelectionModel().getSelectedItem().getNbr_cheveaux());
            textPuissance.setText(nbrch);
            textPhoto1.setText(TabView.getSelectionModel().getSelectedItem().getPhoto1());
            textPhoto2.setText(TabView.getSelectionModel().getSelectedItem().getPhoto2());
            textPhoto3.setText(TabView.getSelectionModel().getSelectedItem().getPhoto3());
            btnCancel.setVisible(true);
            btnUp.setVisible(true);
            imgCancel.setVisible(true);
            imgUp.setVisible(true);
            btnUpdate.setVisible(false);
            btnPdf.setVisible(false);
            btnClean.setVisible(false);
            btnRemove.setVisible(false);
            btnView.setVisible(false);
            imgPdf.setVisible(false);
            imgClean.setVisible(false);
            imgRemove.setVisible(false);
            imgUpdate.setVisible(false);
            imgView.setVisible(false);
            
            if (btnUp.isPressed()==true && btnCancel.isPressed()==false){
                
                String carburant=null;
        String marque = textMarque.getText();
        String modele = textModele.getText();
        String mat = textMatricule.getText();
        String couleur = textCouleur.getText();
        int puiss = Integer.parseInt(textPuissance.getText());
        int kilomet = Integer.parseInt(textKilometrage.getText());
        
        if (carb.getSelectedToggle()==radioDiesel){
            carburant="diesel";
        }else if (carb.getSelectedToggle()==radioEssence){
            carburant="essence";
        } 
       
        
        voi = new Voiture(mat,marque,modele,
                Controller.asDate(dateMecanique.getValue()),
                couleur,puiss,kilomet,carburant,
                Session.getInstance().getCurrent().getIdUtilisateur(),
                Controller.asDate(dateAssurance.getValue()),
                Controller.asDate(datePneu.getValue()),
                Controller.asDate(dateVisiTech.getValue()),
                Controller.asDate(dateCroix.getValue()),
                Controller.asDate(dateVidange.getValue()),
                Controller.asDate(dateVigniette.getValue()),
                "","","",Session.getInstance().getCurrent().getIdUtilisateur());
        
        carDAO.update(voi);
                
                URL sceneToLoad = null;
        String title = null;
         sceneToLoad = new File("src/app/karhbty/views/FXMLAdminHistoVoiture.fxml").toURL();
   Stage primaryStage = null;
   
        FXMLLoader fxmlLoader = new FXMLLoader(sceneToLoad);
        Parent root1 = (Parent) fxmlLoader.load();
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow() ;

        stage.setScene(new Scene(root1));
        stage.show();
        System.out.println("Vous etes dans profil voiture");
         
            }else if (btnCancel.isPressed()==true && btnUp.isPressed()==false){
                URL sceneToLoad = null;
        
         sceneToLoad = new File("src/app/karhbty/views/FXMLAdminHistoVoiture.fxml").toURL();
        FXMLLoader fxmlLoader = new FXMLLoader(sceneToLoad);
        Parent root1 = (Parent) fxmlLoader.load();
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow() ;

        stage.setScene(new Scene(root1));
        stage.show();
        System.out.println("Vous etes dans profil voiture");
            }
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        datacar = FXCollections.observableArrayList(carDAO.displayAllVoi());
        
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
        carPuissCol.setPrefWidth(57);
        carPuissCol.setCellValueFactory(new PropertyValueFactory<>("nbr_cheveaux"));
        
        TableColumn carKiloCol = new TableColumn("Kilometrage");
        carKiloCol.setPrefWidth(90);
        carKiloCol.setCellValueFactory(new PropertyValueFactory<>("kilometrage"));
        
        TableColumn carIdUser = new TableColumn("Utilisateur");
        carIdUser.setPrefWidth(91);
        carIdUser.setCellValueFactory(new PropertyValueFactory<>("id_utilisateur"));
        
        TabView.getColumns().addAll(colId, carImmCol, carMarqCol, carModCol, carCouCol, carPuissCol, carKiloCol, carIdUser);
        TabView.setItems(datacar);
        
        btnUp.setVisible(false);
        btnCancel.setVisible(false);
        imgCancel.setVisible(false);
        imgUp.setVisible(false);
    }
    
} 
    

