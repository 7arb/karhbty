/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.karhbty.services;

import app.karhbty.entities.Notification;
import app.karhbty.entities.Voiture;
import app.karhbty.datasource.Controller;
import app.karhbty.datasource.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amira
 */
public class NotificationService {
   DataSource dataSource;
    PreparedStatement st;

    public NotificationService() {
        dataSource = DataSource.getInstance();
    }
    public List<Notification> afficher(){
       List<Notification> list = new ArrayList<Notification>();
        ResultSet rs; // pour récupérer le résultat de select
        String req = "SELECT * FROM notification";
        
        try {
            st = dataSource.getConnection().prepareStatement(req);
            rs = st.executeQuery(req);
     
            while (rs.next()) {
                Notification n = new Notification(rs.getInt("id_notification"),
                                     rs.getString("libelle_notification"),
                                     rs.getDate("date_notification"),
                                     rs.getString("objet_notification"));
                list.add(n);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return list;
        }
    }
   /* public void ajouter(Notification n){
        try {
            String req = "INSERT INTO notification(libelle_notification,date_notification,objet_notification,id_voiture)VALUES(?,?,?,?)";
            st =dataSource.getConnection().prepareStatement(req);
            st.setString(1,n.getLibelle_notification());
            st.setDate(2,n.getDate_notification());
            st.setString(3,n.getObjet_notification());
            st.setInt(4,n.getId_voiture().getId());
            st.executeUpdate();//insert update delete
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   /* public void supprimer(int id)
    {
            try {
            String req = "DELETE FROM utilisateur WHERE id_utilisateur= ?";
            st = dataSource.getConnection().prepareStatement(req);
            st.setInt(1, id); 
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modifier(Utilisateur u, int id){
        try {
            String req = "UPDATE utilisateur "
                    + "SET nom=?, prenom=? WHERE id_utilisateur=?";
            st = dataSource.getConnection().prepareStatement(req);
            st.setString(1,u.getNom());
            st.setString(2,u.getPrenom());
            st.setInt(3,id);
            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }
    } */
}
