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
import java.sql.Connection;
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
public class NotificationService extends Service {
   DataSource dataSource=DataSource.getInstance();
    PreparedStatement st;

    public NotificationService(Connection conn) {
        super(conn);
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
                                     rs.getInt("id_voiture");
                list.add(n);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return list;
        }
    }
   public void ajouter(Notification n){
        try {
            String req = "INSERT INTO notification(libelle_notification,date_notification,objet_notification,id_voiture)VALUES(?,?,?,?)";
            st =dataSource.getConnection().prepareStatement(req);
            st.setString(1,n.getLibelle_notification());
            st.setDate(2,Controller.convertFromJAVADateToSQLDate(n.getDate_notification()));
            st.setString(3,n.getObjet_notification());
            st.setInt(4,n.getId_voiture());
            st.executeUpdate();//insert update delete
        } catch (SQLException ex) {
            Logger.getLogger(NotificationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   public boolean supprimer(Notification n)
    {
            try {
            String req = "DELETE FROM notification WHERE id_notification= ?";
            st = dataSource.getConnection().prepareStatement(req);
            st.setInt(1,n.getId_notification()); 
            st.executeUpdate();
                System.err.println("notif supprimée");
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(NotificationService.class.getName()).log(Level.SEVERE, null, ex);
        }
            return false;
    }
   public ArrayList<Notification> displayAllNotifbyVoiture(Voiture v)
   {
        ArrayList<Notification> listNotif = new ArrayList<Notification>();

        String requete = "select * from notification where id_voiture =? order by date_notification ASC  ";
        try {
           PreparedStatement ps = dataSource.getConnection().prepareStatement(requete);
            ps.setInt(1, v.getIdVoiture());
            ResultSet resultat = ps.executeQuery();

            while (resultat.next()) {
                Notification n = new Notification();
                n.setId_notification(resultat.getInt(1));
                n.setLibelle_notification(resultat.getString(2));
                n.setDate_notification(resultat.getDate(3));
                n.setObjet_notification(resultat.getString(4));
//                n.setId_voiture(v.getIdVoiture());
                listNotif.add(n);
            }
            return listNotif;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des notifications " + ex.getMessage());
            return null;
        }

   }

   
}
