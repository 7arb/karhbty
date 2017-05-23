/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.karhbty.services;

import app.karhbty.datasource.ServiceFactory;
import app.karhbty.entities.Commentaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Saleh
 */
public class CommentaireService extends Service {
    
    public CommentaireService(Connection connect){
        super(connect);
    }
    
    
    public ArrayList<Commentaire> displayCommAnn() {
        ArrayList<Commentaire> listeCommAnn = new ArrayList<Commentaire>();

        String requete = "select id_commentaire,date_commentaire,description_commentaire,id_utilisateur from commentaire where id_annonce";
        try {
            Statement statement = ServiceFactory.connect.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Commentaire c = new Commentaire();
                
            c.setIdCommentaire(resultat.getInt(1));
            c.setDateCommentaire(resultat.getTimestamp(2));
            c.setDescriptionCommentaire(resultat.getString(3));
            c.setId_utilisateur(resultat.getInt(4));
                

                listeCommAnn.add(c);
            }
            return listeCommAnn;
        } catch (SQLException ex) {
           
            System.out.println("erreur lors du chargement des commentaires" + ex.getMessage());
            return null;
        }
    }
    public ArrayList<Commentaire> displayCommPiece() {
        ArrayList<Commentaire> listeCommPiece = new ArrayList<Commentaire>();

        String requete = "select id_commentaire,date_commentaire,description_commentaire,id_utilisateur from commentaire where id_piece";
        try {
            Statement statement = ServiceFactory.connect.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Commentaire c = new Commentaire();
                
            c.setIdCommentaire(resultat.getInt(1));
            c.setDateCommentaire(resultat.getTimestamp(2));
            c.setDescriptionCommentaire(resultat.getString(3));
            c.setId_utilisateur(resultat.getInt(4));
                

                listeCommPiece.add(c);
            }
            return listeCommPiece;
        } catch (SQLException ex) {
           
            System.out.println("erreur lors du chargement des commentaires" + ex.getMessage());
            return null;
        }
    }
}
