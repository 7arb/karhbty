/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.karhbty.services;

import app.karhbty.datasource.Controller;
import app.karhbty.datasource.DataSource;
import app.karhbty.datasource.Session;

import app.karhbty.datasource.Controller;
import app.karhbty.datasource.ServiceFactory;
import app.karhbty.entities.Voiture;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.rmi.CORBA.Util;


/**
 *
 * @author Saleh
 */
public class VoitureService extends Service{
DataSource ds= DataSource.getInstance();
    PreparedStatement ste;
    
    

    public VoitureService(Connection connect) {
        super(connect);
    }
    public void ajouterv2(Voiture v){
        try {
            String req = "INSERT INTO voiture(matricule,marque,modele,date_mecanique,couleur,nbr_cheveaux,kilometrage,energie,id_vendeur,date_assurance,date_pneux,date_visiteTechnique,date_croix,date_vidange,date_vigniette,photo1,photo2,photo3,id_utilisateur)"
                    + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ste = ds.getConnection().prepareStatement(req);
            ste.setString(1, v.getMatricule());
            ste.setString(2,v.getMarque());
            ste.setString(3,v.getModele());
            ste.setDate(4,Controller.convertFromJAVADateToSQLDate(v.getDate_mec()));
            ste.setString(5,v.getCouleur());
            ste.setInt(6,v.getNbr_cheveaux());
            ste.setInt(7,v.getKilometrage());
            ste.setString(8,v.getEnergie());
            ste.setInt(9,v.getVendeur());
            ste.setDate(10,Controller.convertFromJAVADateToSQLDate(v.getDate_assurance()));
            ste.setDate(11,Controller.convertFromJAVADateToSQLDate(v.getDate_pneu()));
            ste.setDate(12,Controller.convertFromJAVADateToSQLDate(v.getDate_VT()));
            ste.setDate(13,Controller.convertFromJAVADateToSQLDate(v.getDate_croix()));
            ste.setDate(14,Controller.convertFromJAVADateToSQLDate(v.getDate_vidg()));
            ste.setDate(15,Controller.convertFromJAVADateToSQLDate(v.getDate_vignette()));
            ste.setString(16,v.getPhoto1());
            ste.setString(17,v.getPhoto2());
            ste.setString(18,v.getPhoto3());
            ste.setInt(19,v.getUtilisateur());
            ste.executeUpdate();//insert update delete
        } catch (SQLException ex) {
            Logger.getLogger(VoitureService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ajouterv3(Voiture v){
        try {
            String req = "INSERT INTO voiture (matricule,marque,modele,date_mecanique,couleur,nbr_cheveaux,kilometrage,energie,id_vendeur,date_assurance,date_pneux,date_visiteTechnique,date_croix,date_vidange,date_vigniette,photo1,photo2,photo3,id_utilisateur)"
                    + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ste = ds.getConnection().prepareStatement(req);
            ste.setString(1, v.getMatricule());
            ste.setString(2,v.getMarque());
            ste.setString(3,v.getModele());
            ste.setDate(4,Controller.convertFromJAVADateToSQLDate(v.getDate_mec()));
            ste.setString(5,v.getCouleur());
            ste.setInt(6,v.getNbr_cheveaux());
            ste.setInt(7,v.getKilometrage());
            ste.setString(8,v.getEnergie());
            //ste.setInt(9,v.getVendeur());
            ste.setInt(9,Session.getInstance().getCurrent().getIdUtilisateur());
            ste.setDate(10,Controller.convertFromJAVADateToSQLDate(v.getDate_assurance()));
            ste.setDate(11,Controller.convertFromJAVADateToSQLDate(v.getDate_pneu()));
            ste.setDate(12,Controller.convertFromJAVADateToSQLDate(v.getDate_VT()));
            ste.setDate(13,Controller.convertFromJAVADateToSQLDate(v.getDate_croix()));
            ste.setDate(14,Controller.convertFromJAVADateToSQLDate(v.getDate_vidg()));
            ste.setDate(15,Controller.convertFromJAVADateToSQLDate(v.getDate_vignette()));
            ste.setString(16,v.getPhoto1());
            ste.setString(17,v.getPhoto2());
            ste.setString(18,v.getPhoto3());
            //ste.setInt(19,v.getUtilisateur());
            ste.setInt(19,Session.getInstance().getCurrent().getIdUtilisateur());
            ste.executeUpdate();//insert update delete
        } catch (SQLException ex) {
            Logger.getLogger(VoitureService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ajouterv4(Voiture v){
        try {
            String req = "INSERT INTO voiture (matricule,marque,modele,date_mecanique,couleur,nbr_cheveaux,kilometrage,energie,id_vendeur,date_assurance,date_pneux,date_visiteTechnique,date_croix,date_vidange,date_vigniette,photo1,photo2,photo3,id_utilisateur)"
                    + " VALUES('"+
            
            v.getMatricule()+"',"+
            v.getMarque()+"',"+
            v.getModele()+"',"+
            Controller.convertFromJAVADateToSQLDate(v.getDate_mec())+"',"+
            v.getCouleur()+"',"+
            v.getNbr_cheveaux()+"',"+
            v.getKilometrage()+"',"+
            v.getEnergie()+"',"+
            //ste.setInt(9,v.getVendeur());
            Session.getInstance().getCurrent().getIdUtilisateur()+"',"+
            Controller.convertFromJAVADateToSQLDate(v.getDate_assurance())+"',"+
            Controller.convertFromJAVADateToSQLDate(v.getDate_pneu())+"',"+
            Controller.convertFromJAVADateToSQLDate(v.getDate_VT())+"',"+
            Controller.convertFromJAVADateToSQLDate(v.getDate_croix())+"',"+
            Controller.convertFromJAVADateToSQLDate(v.getDate_vidg())+"',"+
            Controller.convertFromJAVADateToSQLDate(v.getDate_vignette())+"',"+
            v.getPhoto1()+"',"+
            v.getPhoto2()+"',"+
            v.getPhoto3()+"',"+
            //ste.setInt(19,v.getUtilisateur());
            Session.getInstance().getCurrent().getIdUtilisateur()+")";
            ste.executeUpdate(req);//insert update delete
        } catch (SQLException ex) {
            Logger.getLogger(VoitureService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        
    public boolean delete(Voiture obj) {
        String req="delete from voiture where id_voiture=?";
    try {
        
        PreparedStatement ste = ServiceFactory.connect.prepareStatement(req);
        ste.setInt(1,obj.getIdVoiture());
        ste.executeUpdate();
        
        System.out.println("Voiture supprimé");
            return true;
    } catch (SQLException ex) {
        Logger.getLogger("erreur lors de la suppression"+ex.getMessage());
    
    }
        return false;
    }
    public void deleteInt(int id) {
        String req="DELETE FROM voiture WHERE id_voiture=?";
    try {
        
        PreparedStatement ste = ServiceFactory.connect.prepareStatement(req);
        ste.setInt(1,id);
        ste.executeUpdate();
        
        System.out.println("Voiture supprimé");
            
    } catch (SQLException ex) {
        Logger.getLogger("erreur lors de la suppression"+ex.getMessage());
    
    }
        
    }
    
    
    public void update(Voiture v) {
        try {
            String req = "UPDATE voiture "
                    + "SET matricule=?,marque=?,modele=?,date_mecanique=?,couleur=?,nbr_cheveaux=?,kilometrage=?,energie=?,id_vendeur=?,date_assurance=?,date_pneux=?,date_visiteTechnique=?,date_croix=?,date_vidange=?,date_vignette=?,photo1=?,photo2=?,photo3=?,id_utilisateur=?";
            ste = ds.getConnection().prepareStatement(req);
            ste.setString(1, v.getMatricule());
            ste.setString(2,v.getMarque());
            ste.setString(3, v.getModele());
            ste.setDate(4, (Date) v.getDate_mec());
            ste.setString(5,v.getCouleur());
            ste.setInt(6,v.getNbr_cheveaux());
            ste.setFloat(7,v.getKilometrage());
            ste.setString(8,v.getEnergie());
            ste.setObject(9,v.getUtilisateur());
            ste.setDate(10, (Date) v.getDate_assurance());
            ste.setDate(11,(Date)v.getDate_pneu());
            ste.setDate(12,(Date)v.getDate_VT());
            ste.setDate(13,(Date)v.getDate_croix());
            ste.setDate(14,(Date)v.getDate_vidg());
            ste.setDate(15,(Date)v.getDate_vignette());
            ste.setString(16,v.getPhoto1());
            ste.setString(17,v.getPhoto2());
            ste.setString(18,v.getPhoto3());
            ste.setObject(19,v.getUtilisateur());
        ste.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
       
  
       public ArrayList<Voiture> displayAllVoi() {
        ArrayList<Voiture> listeVoi = new ArrayList<Voiture>();

        String requete = "select id_voiture,matricule,marque,modele,couleur,nbr_cheveaux,kilometrage from voiture";
        try {
            Statement statement = ServiceFactory.connect.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Voiture v = new Voiture();
                v.setIdVoiture(resultat.getInt(1));
                v.setMatricule(resultat.getString(2));
            v.setMarque(resultat.getString(3));
            v.setModele(resultat.getString(4));
            v.setCouleur(resultat.getString(5));
            v.setNbr_cheveaux(resultat.getInt(6));
            v.setKilometrage(resultat.getInt(7));
                

                listeVoi.add(v);
            }
            return listeVoi;
        } catch (SQLException ex) {
           
            System.out.println("erreur lors du chargement de la Voiture" + ex.getMessage());
            return null;
        }
    }
        public ArrayList<Voiture> displayUserVoi() {
        ArrayList<Voiture> listeUserVoi = new ArrayList<Voiture>();

        String requete = "select id_voiture,matricule,marque,modele,couleur,nbr_cheveaux,kilometrage from voiture where id_utilisateur="+Session.getInstance().getCurrent().getIdUtilisateur()+"";
        try {
            Statement statement = ServiceFactory.connect.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Voiture v = new Voiture();
                v.setIdVoiture(resultat.getInt(1));
                v.setMatricule(resultat.getString(2));
            v.setMarque(resultat.getString(3));
            v.setModele(resultat.getString(4));
            v.setCouleur(resultat.getString(5));
            v.setNbr_cheveaux(resultat.getInt(6));
            v.setKilometrage(resultat.getInt(7));
            
                

                listeUserVoi.add(v);
            }
            return listeUserVoi;
        } catch (SQLException ex) {
           
            System.out.println("erreur lors du chargement de la Voiture" + ex.getMessage());
            return null;
        }
    }
        
                
    public List<Voiture> displaychartview() {
   List<Voiture> list=new ArrayList<>();
   String req = "select marque, count(V.id_voiture) from utilisateur U , voiture V where U.id_utilisateur=V.id_utilisateur group by id_voiture";
try {
    
    //SQL FOR SELECTING CUSTOMERS
    //String req = "select nom , count(V.id_utilisateur) ,U.id_utilisateur from utilisateur U , voiture V where U.id_utilisateur=V.id_utilisateur group by id_utilisateur";
    
    PreparedStatement ps = ServiceFactory.connect.prepareStatement(req);
    
    ResultSet rs = ps.executeQuery();
    Voiture v = new Voiture();
    while (rs.next()) {
        v.setMarque(rs.getString(1));
        v.setIdVoiture(rs.getInt(2));
        //adding data on piechart data
        list.add(v);
        
    }
    
} catch (Exception ex) {
    
    Logger.getLogger(VoitureService.class.getName()).log(Level.SEVERE, null, ex);
    
    
}
    
   return list; 
}
    
    
    public ArrayList<Voiture> rechercheVoiture (String marque) {
        ArrayList<Voiture> listeUserVoi = new ArrayList<Voiture>();

        String requete = "select id_voiture,matricule,marque,modele,couleur,nbr_cheveaux,kilometrage from voiture where id_utilisateur="+Session.getInstance().getCurrent().getIdUtilisateur()+"";
        try {
            Statement statement = ServiceFactory.connect.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Voiture v = new Voiture();
                v.setIdVoiture(resultat.getInt(1));
                v.setMatricule(resultat.getString(2));
            v.setMarque(resultat.getString(3));
            v.setModele(resultat.getString(4));
            v.setCouleur(resultat.getString(5));
            v.setNbr_cheveaux(resultat.getInt(6));
            v.setKilometrage(resultat.getInt(7));
            
                

                listeUserVoi.add(v);
            }
            return listeUserVoi;
        } catch (SQLException ex) {
           
            System.out.println("erreur lors du chargement de la Voiture" + ex.getMessage());
            return null;
        }
    }
}