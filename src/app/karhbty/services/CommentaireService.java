/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.karhbty.services;

import app.karhbty.datasource.ServiceFactory;
import app.karhbty.entities.Commentaire;
import app.karhbty.entities.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
        ArrayList<Commentaire> listeCommAnn = new ArrayList<>();

        String requete = "select id_commentaire,date_commentaire,description_commentaire,id_utilisateur from commentaire where id_annonce";
        try {
            Statement statement = ServiceFactory.connect.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Commentaire c = new Commentaire();
                
            c.setIdCommentaire(resultat.getInt(1));
            c.setDateCommentaire(resultat.getDate(2));
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
        ArrayList<Commentaire> listeCommPiece = new ArrayList<>();

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
        public ArrayList<Commentaire> displayCommBoutique() {
        ArrayList<Commentaire> listeCommPiece = new ArrayList<>();

        String requete = "select id_commentaire,date_commentaire,description_commentaire,id_utilisateur from commentaire where id_boutique";
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
        
        public ArrayList<Commentaire> displayCommTestBlanc() {
        ArrayList<Commentaire> listeCommPiece = new ArrayList<>();

        String requete = "select id_commentaire,date_commentaire,description_commentaire,id_utilisateur from commentaire where id_testBlanc";
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
        public ArrayList<Commentaire> displayCommCode() {
        ArrayList<Commentaire> listeCommPiece = new ArrayList<>();

        String requete = "select id_commentaire,date_commentaire,description_commentaire,id_utilisateur from commentaire where id_code";
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
        public ArrayList<Commentaire> displayCommConduite() {
        ArrayList<Commentaire> listeCommPiece = new ArrayList<>();

        String requete = "select id_commentaire,date_commentaire,description_commentaire,id_utilisateur from commentaire where id_conduite";
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
        
        public ArrayList<Commentaire> displayCommRevisVidang() {
        ArrayList<Commentaire> listeCommPiece = new ArrayList<>();

        String requete = "select id_commentaire,date_commentaire,description_commentaire,id_utilisateur from commentaire where id_revisVidang";
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
        
        public ArrayList<Commentaire> displayCommClim() {
        ArrayList<Commentaire> listeCommPiece = new ArrayList<>();

        String requete = "select id_commentaire,date_commentaire,description_commentaire,id_utilisateur from commentaire where id_clim";
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
        
        public ArrayList<Commentaire> displayCommElec() {
        ArrayList<Commentaire> listeCommPiece = new ArrayList<>();

        String requete = "select id_commentaire,date_commentaire,description_commentaire,id_utilisateur from commentaire where id_elec";
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
        
        public ArrayList<Commentaire> displayCommMeca() {
        ArrayList<Commentaire> listeCommPiece = new ArrayList<>();

        String requete = "select id_commentaire,date_commentaire,description_commentaire,id_utilisateur from commentaire where id_meca";
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
        
        public List<Utilisateur> displaychartview() {
   List<Utilisateur> list=new ArrayList<>();
   String req = "select nom, count(C.id_commentaire) from utilisateur U , commentaire C where U.id_utilisateur=C.id_utilisateur group by id_commentaire";
try {
    
    //SQL FOR SELECTING CUSTOMERS
    //String req = "select nom , count(V.id_utilisateur) ,U.id_utilisateur from utilisateur U , voiture V where U.id_utilisateur=V.id_utilisateur group by id_utilisateur";
    
    PreparedStatement ps = ServiceFactory.connect.prepareStatement(req);
    
    ResultSet rs = ps.executeQuery();
    Utilisateur u = new Utilisateur();
    while (rs.next()) {
        u.setNom(rs.getString(1));
        u.setPrenom(rs.getString(2));
        //adding data on piechart data
        list.add(u);
        
    }
    
} catch (SQLException ex) {
    
    Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null, ex);
    
    
}
    
   return list; 
}
        public boolean delete(Commentaire obj) {
        String req="delete from voiture where id_voiture=?";
    try {
        
        PreparedStatement st = ServiceFactory.connect.prepareStatement(req);
        st.setInt(1,obj.getIdCommentaire());
        st.executeUpdate();
        
        System.out.println("Commentaire supprimé");
            return true;
    } catch (SQLException ex) {
        Logger.getLogger("erreur lors de la suppression"+ex.getMessage());
    
    }
        return false;
    }
}
