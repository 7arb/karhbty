/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.karhbty.controllers;

import static app.karhbty.datasource.ServiceFactory.connect;
import app.karhbty.entities.Commentaire;
import app.karhbty.services.CommentaireService;
import app.karhbty.services.VoitureService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author Saleh
 */
public class FXMLCommentaireController implements Initializable {

    @FXML
    private AnchorPane AnPane;

    @FXML
    private TabPane TabPane;

    @FXML
    private Tab TPAnn;

    @FXML
    private AnchorPane APAnn;

    @FXML
    private TableView<Commentaire> TVAnn;

    @FXML
    private Tab TPPieRech;

    @FXML
    private AnchorPane APPieRech;

    @FXML
    private TableView<Commentaire> TVPieRech;

    @FXML
    private Tab TPBout;

    @FXML
    private AnchorPane APBout;

    @FXML
    private TableView<Commentaire> TVBout;

    @FXML
    private Tab TPTestB;

    @FXML
    private AnchorPane APTestB;

    @FXML
    private TableView<Commentaire> TVTestB;

    @FXML
    private Tab TPCode;

    @FXML
    private AnchorPane APCode;

    @FXML
    private TableView<Commentaire> TVCode;

    @FXML
    private Tab TPCond;

    @FXML
    private AnchorPane APCond;

    @FXML
    private TableView<Commentaire> TVCond;

    @FXML
    private Tab TPRevVid;

    @FXML
    private AnchorPane APRevVid;

    @FXML
    private TableView<Commentaire> TVRevVid;

    @FXML
    private Tab TPClim;

    @FXML
    private AnchorPane APClim;

    @FXML
    private TableView<Commentaire> TVClim;

    @FXML
    private Tab TPElec;

    @FXML
    private AnchorPane APElec;

    @FXML
    private TableView<Commentaire> TVElec;

    @FXML
    private Tab TPMec;

    @FXML
    private AnchorPane APMec;

    @FXML
    private TableView<Commentaire> TVMec;

    @FXML
    private Label labSuj;

    private ObservableList<Commentaire> dataCommAnn = FXCollections.observableArrayList();
    private ObservableList<Commentaire> dataCommPieRech = FXCollections.observableArrayList();
    CommentaireService commDAO = new CommentaireService(connect);

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dataCommAnn = FXCollections.observableArrayList(commDAO.displayCommAnn());
        
        //Commentaire by Annonce
        
        TableColumn colIdann = new TableColumn("ID");
        colIdann.setPrefWidth(10);
        colIdann.setCellValueFactory(new PropertyValueFactory<>("id_commentaire"));
        
        TableColumn colDateann = new TableColumn("Date");
        colDateann.setPrefWidth(200);
        colDateann.setCellValueFactory(new PropertyValueFactory<>("date_commentaire"));
        
        TableColumn colDescann = new TableColumn("Description");
        colDescann.setPrefWidth(400);
        colDescann.setCellValueFactory(new PropertyValueFactory<>("description_commentaire"));
        
        TableColumn colIdUserann = new TableColumn("ID Utilisateur");
        colIdUserann.setPrefWidth(200);
        colIdUserann.setCellValueFactory(new PropertyValueFactory<>("id_utilisateur"));
        
        TVAnn.getColumns().addAll(colIdann, colDateann,colDescann,colIdUserann);
        TVAnn.setItems(dataCommAnn);
        
    }    
    @FXML
    public void onPieRechClicked (ActionEvent event){
        dataCommPieRech = FXCollections.observableArrayList(commDAO.displayCommPiece());
        
        //Commentaire by Piece de rechange
        
        
        TableColumn colIdpr = new TableColumn("ID");
        colIdpr.setPrefWidth(10);
        colIdpr.setCellValueFactory(new PropertyValueFactory<>("id_commentaire"));
        
        TableColumn colDatepr = new TableColumn("Date");
        colDatepr.setPrefWidth(200);
        colDatepr.setCellValueFactory(new PropertyValueFactory<>("date_commentaire"));
        
        TableColumn colDescpr = new TableColumn("Description");
        colDescpr.setPrefWidth(400);
        colDescpr.setCellValueFactory(new PropertyValueFactory<>("description_commentaire"));
        
        TableColumn colIdUserpr = new TableColumn("ID Utilisateur");
        colIdUserpr.setPrefWidth(200);
        colIdUserpr.setCellValueFactory(new PropertyValueFactory<>("id_utilisateur"));
        
        TVPieRech.getColumns().addAll(colIdpr, colDatepr,colDescpr,colIdUserpr);
        TVPieRech.setItems(dataCommPieRech);
    }
}
