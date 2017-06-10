/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.karhbty.controllers;

import app.karhbty.datasource.ServiceFactory;
import static app.karhbty.datasource.ServiceFactory.connect;
import app.karhbty.entities.Commentaire;
import app.karhbty.services.CommentaireService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.mail.MessagingException;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;


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
    
     @FXML
    private JFXButton BtnRetour;

    @FXML
    private ImageView imgRetour;
    
    @FXML
    private JFXButton btnUpdate;

    @FXML
    private ImageView imgUpdate;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private ImageView imgDelete;

    @FXML
    private JFXButton btnDownload;

    @FXML
    private ImageView imgDownload;

    @FXML
    private JFXTextField txtDesc;


    @FXML
    private JFXButton btnStats;

    @FXML
    private ImageView imgStats;


    private ObservableList<Commentaire> dataCommAnn = FXCollections.observableArrayList();
    private ObservableList<Commentaire> dataCommPieRech = FXCollections.observableArrayList();
    private ObservableList<Commentaire> dataCommBoutique = FXCollections.observableArrayList();
    private ObservableList<Commentaire> dataCommTestB = FXCollections.observableArrayList();
    private ObservableList<Commentaire> dataCommCode = FXCollections.observableArrayList();
    private ObservableList<Commentaire> dataCommConduite = FXCollections.observableArrayList();
    private ObservableList<Commentaire> dataCommRevisVidan = FXCollections.observableArrayList();
    private ObservableList<Commentaire> dataCommClim = FXCollections.observableArrayList();
    private ObservableList<Commentaire> dataCommElec = FXCollections.observableArrayList();
    private ObservableList<Commentaire> dataCommMeca = FXCollections.observableArrayList();
    
    ObjectProperty<EventHandler<Event>> onSelectionChangedProperty;
    CommentaireService commDAO = new CommentaireService(connect);

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         //Commentaire by Annonce
        dataCommAnn = FXCollections.observableArrayList(commDAO.displayCommAnn());
        
        TableColumn colIdann = new TableColumn("ID");
        colIdann.setPrefWidth(60);
        colIdann.setCellValueFactory(new PropertyValueFactory<>("id_commentaire"));
        
        TableColumn colDateann = new TableColumn("Date");
        colDateann.setPrefWidth(200);
        colDateann.setCellValueFactory(new PropertyValueFactory<>("date_commentaire"));
        
        TableColumn colDescann = new TableColumn("Description");
        colDescann.setPrefWidth(400);
        colDescann.setCellValueFactory(new PropertyValueFactory<>("description_commentaire"));
        
        TableColumn colIdUserann = new TableColumn("ID Utilisateur");
        colIdUserann.setPrefWidth(150);
        colIdUserann.setCellValueFactory(new PropertyValueFactory<>("id_utilisateur"));
        
        TVAnn.getColumns().addAll(colIdann, colDateann,colDescann,colIdUserann);
        TVAnn.setItems(dataCommAnn);
        
        //Commentaire by Piece de rechange
        
        
        onSelectionChangedProperty = TPPieRech.onSelectionChangedProperty();
        dataCommPieRech = FXCollections.observableArrayList(commDAO.displayCommPiece());
        
        TableColumn colIdpr = new TableColumn("ID");
        colIdpr.setPrefWidth(60);
        colIdpr.setCellValueFactory(new PropertyValueFactory<>("id_commentaire"));
        
        TableColumn colDatepr = new TableColumn("Date");
        colDatepr.setPrefWidth(200);
        colDatepr.setCellValueFactory(new PropertyValueFactory<>("date_commentaire"));
        
        TableColumn colDescpr = new TableColumn("Description");
        colDescpr.setPrefWidth(400);
        colDescpr.setCellValueFactory(new PropertyValueFactory<>("description_commentaire"));
        
        TableColumn colIdUserpr = new TableColumn("ID Utilisateur");
        colIdUserpr.setPrefWidth(150);
        colIdUserpr.setCellValueFactory(new PropertyValueFactory<>("id_utilisateur"));
        
        TVPieRech.getColumns().addAll(colIdpr, colDatepr,colDescpr,colIdUserpr);
        TVPieRech.setItems(dataCommPieRech);
        
        //Commentaire by Boutique
        
        onSelectionChangedProperty = TPBout.onSelectionChangedProperty();
        dataCommBoutique = FXCollections.observableArrayList(commDAO.displayCommBoutique());
        
        TableColumn colIdbout = new TableColumn("ID");
        colIdbout.setPrefWidth(60);
        colIdbout.setCellValueFactory(new PropertyValueFactory<>("id_commentaire"));
        
        TableColumn colDatebout = new TableColumn("Date");
        colDatebout.setPrefWidth(200);
        colDatebout.setCellValueFactory(new PropertyValueFactory<>("date_commentaire"));
        
        TableColumn colDescbout = new TableColumn("Description");
        colDescbout.setPrefWidth(400);
        colDescbout.setCellValueFactory(new PropertyValueFactory<>("description_commentaire"));
        
        TableColumn colIdUserbout = new TableColumn("ID Utilisateur");
        colIdUserbout.setPrefWidth(150);
        colIdUserbout.setCellValueFactory(new PropertyValueFactory<>("id_utilisateur"));
        
        TVBout.getColumns().addAll(colIdbout, colDatebout,colDescbout,colIdUserbout);
        TVBout.setItems(dataCommBoutique);
        
        //Commentaire by Test Blanc
        
        onSelectionChangedProperty = TPTestB.onSelectionChangedProperty();
        dataCommTestB = FXCollections.observableArrayList(commDAO.displayCommTestBlanc());
        
        TableColumn colIdTb = new TableColumn("ID");
        colIdTb.setPrefWidth(60);
        colIdTb.setCellValueFactory(new PropertyValueFactory<>("id_commentaire"));
        
        TableColumn colDateTb = new TableColumn("Date");
        colDateTb.setPrefWidth(200);
        colDateTb.setCellValueFactory(new PropertyValueFactory<>("date_commentaire"));
        
        TableColumn colDescTb = new TableColumn("Description");
        colDescTb.setPrefWidth(400);
        colDescTb.setCellValueFactory(new PropertyValueFactory<>("description_commentaire"));
        
        TableColumn colIdUserTb = new TableColumn("ID Utilisateur");
        colIdUserTb.setPrefWidth(150);
        colIdUserTb.setCellValueFactory(new PropertyValueFactory<>("id_utilisateur"));
        
        TVTestB.getColumns().addAll(colIdTb, colDateTb,colDescTb,colIdUserTb);
        TVTestB.setItems(dataCommTestB);
        
        //Commentaire by Code Routiere
        
        onSelectionChangedProperty = TPCode.onSelectionChangedProperty();
        dataCommCode = FXCollections.observableArrayList(commDAO.displayCommCode());
        
        TableColumn colIdCode = new TableColumn("ID");
        colIdCode.setPrefWidth(60);
        colIdCode.setCellValueFactory(new PropertyValueFactory<>("id_commentaire"));
        
        TableColumn colDateCode = new TableColumn("Date");
        colDateCode.setPrefWidth(200);
        colDateCode.setCellValueFactory(new PropertyValueFactory<>("date_commentaire"));
        
        TableColumn colDescCode = new TableColumn("Description");
        colDescCode.setPrefWidth(400);
        colDescCode.setCellValueFactory(new PropertyValueFactory<>("description_commentaire"));
        
        TableColumn colIdUserCode = new TableColumn("ID Utilisateur");
        colIdUserCode.setPrefWidth(150);
        colIdUserCode.setCellValueFactory(new PropertyValueFactory<>("id_utilisateur"));
        
        TVCode.getColumns().addAll(colIdCode, colDateCode,colDescCode,colIdUserCode);
        TVCode.setItems(dataCommCode);
        
        //Commentaire by Conduite
        
        onSelectionChangedProperty = TPCond.onSelectionChangedProperty();
        dataCommConduite = FXCollections.observableArrayList(commDAO.displayCommConduite());
        
        TableColumn colIdCond = new TableColumn("ID");
        colIdCond.setPrefWidth(60);
        colIdCond.setCellValueFactory(new PropertyValueFactory<>("id_commentaire"));
        
        TableColumn colDateCond = new TableColumn("Date");
        colDateCond.setPrefWidth(200);
        colDateCond.setCellValueFactory(new PropertyValueFactory<>("date_commentaire"));
        
        TableColumn colDescCond = new TableColumn("Description");
        colDescCond.setPrefWidth(400);
        colDescCond.setCellValueFactory(new PropertyValueFactory<>("description_commentaire"));
        
        TableColumn colIdUserCond = new TableColumn("ID Utilisateur");
        colIdUserCond.setPrefWidth(150);
        colIdUserCond.setCellValueFactory(new PropertyValueFactory<>("id_utilisateur"));
        
        TVCond.getColumns().addAll(colIdCond, colDateCond,colDescCond,colIdUserCond);
        TVCond.setItems(dataCommConduite);
        
        //Commentaire by Revision & Vidange
        
        onSelectionChangedProperty = TPRevVid.onSelectionChangedProperty();
        dataCommRevisVidan = FXCollections.observableArrayList(commDAO.displayCommRevisVidang());
        
        TableColumn colIdRevVid = new TableColumn("ID");
        colIdRevVid.setPrefWidth(60);
        colIdRevVid.setCellValueFactory(new PropertyValueFactory<>("id_commentaire"));
        
        TableColumn colDateRevVid = new TableColumn("Date");
        colDateRevVid.setPrefWidth(200);
        colDateRevVid.setCellValueFactory(new PropertyValueFactory<>("date_commentaire"));
        
        TableColumn colDescRevVid = new TableColumn("Description");
        colDescRevVid.setPrefWidth(400);
        colDescRevVid.setCellValueFactory(new PropertyValueFactory<>("description_commentaire"));
        
        TableColumn colIdUserRevVid = new TableColumn("ID Utilisateur");
        colIdUserRevVid.setPrefWidth(150);
        colIdUserRevVid.setCellValueFactory(new PropertyValueFactory<>("id_utilisateur"));
        
        TVRevVid.getColumns().addAll(colIdRevVid, colDateRevVid,colDescRevVid,colIdUserRevVid);
        TVRevVid.setItems(dataCommRevisVidan);
        
        //Commentaire by Climatisation
        
        onSelectionChangedProperty = TPClim.onSelectionChangedProperty();
        dataCommClim = FXCollections.observableArrayList(commDAO.displayCommClim());
        
        TableColumn colIdClim = new TableColumn("ID");
        colIdClim.setPrefWidth(60);
        colIdClim.setCellValueFactory(new PropertyValueFactory<>("id_commentaire"));
        
        TableColumn colDateClim = new TableColumn("Date");
        colDateClim.setPrefWidth(200);
        colDateClim.setCellValueFactory(new PropertyValueFactory<>("date_commentaire"));
        
        TableColumn colDescClim = new TableColumn("Description");
        colDescClim.setPrefWidth(400);
        colDescClim.setCellValueFactory(new PropertyValueFactory<>("description_commentaire"));
        
        TableColumn colIdUserClim = new TableColumn("ID Utilisateur");
        colIdUserClim.setPrefWidth(150);
        colIdUserClim.setCellValueFactory(new PropertyValueFactory<>("id_utilisateur"));
        
        TVClim.getColumns().addAll(colIdClim, colDateClim,colDescClim,colIdUserClim);
        TVClim.setItems(dataCommClim);
        
        //Commentaire by Electrique
        
        onSelectionChangedProperty = TPElec.onSelectionChangedProperty();
        dataCommElec = FXCollections.observableArrayList(commDAO.displayCommElec());
        
        TableColumn colIdElec = new TableColumn("ID");
        colIdElec.setPrefWidth(60);
        colIdElec.setCellValueFactory(new PropertyValueFactory<>("id_commentaire"));
        
        TableColumn colDateElec = new TableColumn("Date");
        colDateElec.setPrefWidth(200);
        colDateElec.setCellValueFactory(new PropertyValueFactory<>("date_commentaire"));
        
        TableColumn colDescElec = new TableColumn("Description");
        colDescElec.setPrefWidth(400);
        colDescElec.setCellValueFactory(new PropertyValueFactory<>("description_commentaire"));
        
        TableColumn colIdUserElec = new TableColumn("ID Utilisateur");
        colIdUserElec.setPrefWidth(150);
        colIdUserElec.setCellValueFactory(new PropertyValueFactory<>("id_utilisateur"));
        
        TVElec.getColumns().addAll(colIdElec, colDateElec,colDescElec,colIdUserElec);
        TVElec.setItems(dataCommElec);
        
        //Commentaire by Mecanique
        
        onSelectionChangedProperty = TPMec.onSelectionChangedProperty();
        dataCommMeca = FXCollections.observableArrayList(commDAO.displayCommMeca());
        
        TableColumn colIdMec = new TableColumn("ID");
        colIdMec.setPrefWidth(60);
        colIdMec.setCellValueFactory(new PropertyValueFactory<>("id_commentaire"));
        
        TableColumn colDateMec = new TableColumn("Date");
        colDateMec.setPrefWidth(200);
        colDateMec.setCellValueFactory(new PropertyValueFactory<>("date_commentaire"));
        
        TableColumn colDescMec = new TableColumn("Description");
        colDescMec.setPrefWidth(400);
        colDescMec.setCellValueFactory(new PropertyValueFactory<>("description_commentaire"));
        
        TableColumn colIdUserMec = new TableColumn("ID Utilisateur");
        colIdUserMec.setPrefWidth(150);
        colIdUserMec.setCellValueFactory(new PropertyValueFactory<>("id_utilisateur"));
        
        TVMec.getColumns().addAll(colIdMec, colDateMec,colDescMec,colIdUserMec);
        TVMec.setItems(dataCommMeca);
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
    private void chartview(ActionEvent event) {
   
PieChart pieChart = new PieChart();
Connection c;
ObservableList data;
data = FXCollections.observableArrayList();
try {
    
    
    String req = "select nom, count(C.id_commentaire) from utilisateur U , commentaire C where U.id_utilisateur=C.id_utilisateur group by id_commentaire";
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
    
    @FXML
    private void deleteComm(ActionEvent event) throws MalformedURLException, IOException, MessagingException {
        if (TVAnn.getSelectionModel().getSelectedIndices().size() > 0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Verifier votre choix");
            System.out.println(TVAnn.getSelectionModel().getSelectedItem());
            alert.setContentText("Etes-vous sûre de vouloir supprimer?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                commDAO.delete(TVAnn.getSelectionModel().getSelectedItem());

                List<Commentaire> list = commDAO.displayCommAnn();
                dataCommAnn = FXCollections.observableArrayList(list);
                TVAnn.setItems(dataCommAnn);
                

                alert.setTitle("Succes");
                alert.setHeaderText(null);
                alert.setContentText("Commentaire supprimer avec succés");
                alert.showAndWait();
                
                TrayNotification tray = new TrayNotification("Succes", " Commentaire supprimée avec succes",NotificationType.SUCCESS);
            tray.showAndDismiss(javafx.util.Duration.seconds(2));
            
            
            } else {
                // ... user chose CANCEL or closed the dialog
            }

        }
    }
}
