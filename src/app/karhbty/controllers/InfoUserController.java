/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.karhbty.controllers;

import static app.karhbty.controllers.InscriUserController.user;
import static app.karhbty.controllers.InscriUserController.userDAO;
import app.karhbty.datasource.Session;
import app.karhbty.entities.Utilisateur;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javax.imageio.ImageIO;
/**
 * FXML Controller class
 *
 * @author amira
 */

public class InfoUserController implements Initializable {

    public static Utilisateur u;
public void setUser(Utilisateur u) {
        this.u = u;
    }
    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private ImageView ImgView;

    @FXML
    private Button AddImgButton;

    @FXML
    private Pane Pane1;

    @FXML
    private Label AdresseLabel;

    @FXML
    private TextField AdresseTF;

    @FXML
    private Pane Pane2;

    @FXML
    private Label CinLabel;

    @FXML
    private TextField CinTF;

    @FXML
    private Pane Pane3;

    @FXML
    private Label TelLabel;

    @FXML
    private TextField TelTF;

    @FXML
    private Button OKButton;
    
    @FXML
    private Label errorLab;
    
    private Desktop desktop = Desktop.getDesktop();
    private File fichier;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            
    } 
    String x;
    @FXML
    private void ajoutPhoto(ActionEvent event) throws IOException
    {
         
        FileChooser fileChooser = new FileChooser();
            
            //Set extension filter
            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
              
            //Show open file dialog
            File fichier = fileChooser.showOpenDialog(null);
                       
            try {
                BufferedImage bufferedImage = ImageIO.read(fichier);
                WritableImage image = SwingFXUtils.toFXImage(bufferedImage, null);
         
                ImgView.setImage(image);
                System.out.println(fichier.getName());
                x=fichier.getName();
                
                
                
            } catch (IOException ex) {
                Logger.getLogger(InfoUserController.class.getName()).log(Level.SEVERE, null, ex);
            }
 
    }
    @FXML
    private void OkbuttonClicked(ActionEvent event) throws IOException
    {   
        
        
         u = userDAO.findByEmail(user.getEmail(),user.getPassword());
        
        Session.connect(u);
            System.out.println(u);
             
            String adresse = this.AdresseTF.getText();
            String cin = this.CinTF.getText();
            String tel = this.TelTF.getText();
            
        if((adresse.isEmpty())||(cin.isEmpty())||(tel.isEmpty()))
      errorLab.setText("Veuillez compléter tous les champs");
        else if(CinTF.getLength()!=8)
        {
            errorLab.setText("champs cin invalide");
        }
        else if(TelTF.getLength()!=8)
        {
            errorLab.setText("champs tel invalide");
        }
        else{
            
            u=new Utilisateur(Integer.parseInt(cin),user.getNom(),user.getPrenom(),user.getEmail(),Integer.parseInt(tel),adresse,user.getPassword());
             
            userDAO.modifierInfo(u);
            
            //userDAO.modifierInfo(u,u.getAdresse(),u.getCin(),u.getTelephone());
            URL sceneToLoad = new File ("src/app/karhbty/views/ProfilUser.fxml").toURL();
            FXMLLoader fxmlloader=new FXMLLoader(sceneToLoad);
            Parent root1=(Parent) fxmlloader.load();
            Node node =(Node)event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            stage.setTitle("Profil "+u.getNom()+" "+u.getPrenom());
            stage.setScene(new Scene(root1));
//            ProfilUserController controller=fxmlloader.<ProfilUserController>getController();
//            controller.setUser(u);
            stage.show();
        }
    }
    
}
