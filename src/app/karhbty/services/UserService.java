/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.karhbty.services;

import app.karhbty.datasource.ServiceFactory;
import app.karhbty.datasource.Session;
import app.karhbty.entities.Administrateur;
import app.karhbty.entities.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 
 */
public class UserService extends Service /*implements IUserService*/ {
    private ResultSet rs;
PreparedStatement ste;
//    public UserService() {
//        ds = DataSource.getInstance();
//    }

    public UserService(Connection conn) {
        super(conn);
    }

    


    
    

    /*@Override*/
    public void add(Utilisateur obj) {
       {
    try {
        String req= "INSERT INTO utilisateur (cin, administrateur, nom, prenom, email, telephone, adresse, password, photo, resp_stationMultiService, resp_autoEcole, resp_boutique)"
                 + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
         
        ste=connect.prepareStatement(req);
        ste.setInt(1,obj.getCin());
        ste.setBoolean(2,obj.getAdministrateur());
        ste.setString(3,obj.getNom());
        ste.setString(4,obj.getPrenom());
        ste.setString(5,obj.getEmail());
        ste.setInt(6,obj.getTelephone());
        ste.setString(7,obj.getAdresse());
        ste.setString(8,obj.getPassword());
        ste.setString(9,obj.getPhoto());
        ste.setBoolean(10,obj.getRespstationMultiService());
        ste.setBoolean(11,obj.getRespautoEcole());
        ste.setBoolean(12,obj.getRespBoutique());
        ste.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    }

    
    public void delete(int id) {
        
    try {
        String req="DELETE FROM utilisateur WHERE id=?";
        ste=connect.prepareStatement(req);
        ste.setInt(1,id);
        ste.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
    
    }
    }
    
   /* public void update(Utilisateur obj) {
        try {
            String req = "UPDATE utilisateur "
                    + "SET cin=?, administrateur=?, nom=?, prenom=?, email=?, telephone=?, adresse=?, password=?, photo=?, resp_stationMultiService=?, resp_autoEcole=?, resp_boutique=? WHERE id=?";
            ste = connect.prepareStatement(req);
            ste.setInt(1,obj.getCin());
        ste.setBoolean(2,obj.getAdministrateur());
        ste.setString(3,obj.getNom());
        ste.setString(4,obj.getPrenom());
        ste.setString(5,obj.getEmail());
        ste.setInt(6,obj.getTelephone());
        ste.setString(7,obj.getAdresse());
        ste.setString(8,obj.getPassword());
        ste.setString(9,obj.getPhoto());
        ste.setBoolean(10,obj.getRespstationMultiService());
        ste.setBoolean(11,obj.getRespautoEcole());
        ste.setBoolean(12,obj.getRespBoutique());
        ste.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    

      public Utilisateur findByEmail(String email,String password ) {
        
        String req = "select * from utilisateur WHERE `email`=? AND `password`=?";
        try {
            
            ste=connect.prepareStatement(req);
            ste.setString(1,email);
            ste.setString(2,password);
            ResultSet rs = ste.executeQuery();

                 // if( ste.executeQuery()!=null){
            if (rs.first()) {
                System.out.println("USER FOUND , his surname is : " + rs.getString("nom"));
                System.out.println(" and his name is : " + rs.getString("prenom"));
           if ("admin".equals(rs.getString("email"))) {
                   System.out.println(rs.getString("nom") + " est un Administrateur !! ");
                    return new Administrateur(rs.getInt("id_utilisateur"),
                                     rs.getInt("cin"),
                                     rs.getBoolean("administrateur"),
                                     rs.getString("nom"),
                                     rs.getString("prenom"),
                                     rs.getString("email"),
                                     rs.getInt("telephone"),
                                     rs.getString("adresse"),
                                     rs.getString("password"),
                                     rs.getString("photo"),
                                     rs.getBoolean("resp_stationMultiService"),
                                     rs.getBoolean("resp_autoEcole"),
                                     rs.getBoolean("resp_boutique"));
                }
                else {
                   System.out.println(rs.getString("nom") + " est un Utilisateur !! ");
                    return new Utilisateur(rs.getInt("id_utilisateur"),
                                     rs.getInt("cin"),
                                     rs.getBoolean("administrateur"),
                                     rs.getString("nom"),
                                     rs.getString("prenom"),
                                     rs.getString("email"),
                                     rs.getInt("telephone"),
                                     rs.getString("adresse"),
                                     rs.getString("password"),
                                     rs.getString("photo"),
                                     rs.getBoolean("resp_stationMultiService"),
                                     rs.getBoolean("resp_autoEcole"),
                                     rs.getBoolean("resp_boutique"));
                }

                

            
            } else {
                System.out.println("USER not Found !! ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex); 
        }
        
        return null;
    }
    
       
  
    public  boolean findByEmail(String email) {
        
        String req = "select * from utilisateur WHERE `email`=?";
        try {
            
            ste=connect.prepareStatement(req);
            ste.setString(1,email);
            
            ResultSet rs = ste.executeQuery();

                 // if( ste.executeQuery()!=null){
            if (rs.first()) {
                System.out.println("USER FOUND , his surname is : " + rs.getString("nom"));
                System.out.println(" and his name is : " + rs.getString("prenom"));
                return true;
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex); 
        }
        
        return false;
    }
    
    
    public List<Utilisateur> lister() {

        List<Utilisateur> list = new ArrayList<Utilisateur>();
        ResultSet rs; // pour récupérer le résultat de select
        String req = "SELECT * FROM utilisateur";
        try {
            ste = connect.prepareStatement(req);
            rs = ste.executeQuery(req);
            
            while (rs.next()) {
                Utilisateur u = 
                        new Utilisateur(rs.getInt("id_utilisateur"),
                                     rs.getInt("cin"),
                                     rs.getBoolean("administrateur"),
                                     rs.getString("nom"),
                                     rs.getString("prenom"),
                                     rs.getString("email"),
                                     rs.getInt("telephone"),
                                     rs.getString("adresse"),
                                     rs.getString("password"),
                                     rs.getString("photo"),
                                     rs.getBoolean("resp_stationMultiService"),
                                     rs.getBoolean("resp_autoEcole"),
                                     rs.getBoolean("resp_boutique"));
        
                list.add(u);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return list;
        }
    }

    
    public ArrayList<Utilisateur> DisplayInfoUser(){
        ArrayList<Utilisateur> listeInfoUser = new ArrayList<Utilisateur>();
        
        String req = "SELECT id_utilisateur,cin,nom,prenom,email,telephone,adresse,photo FROM utilisateur where id_utilisateur='"+Session.getInstance().getCurrent().getIdUtilisateur()+"'";
        
        try {
        Statement statement = ServiceFactory.connect.createStatement();
            ResultSet rsul = statement.executeQuery(req);
            
            
            
            
                while (rsul.next()){
                        
                        Utilisateur u = new Utilisateur();
                                    u.setIdUtilisateur(rsul.getInt(1));
                                    u.setCin(rsul.getInt(2));                                         
                                    u.setNom(rsul.getString(3));
                                    u.setPrenom(rsul.getString(4));
                                    u.setEmail(rsul.getString(5));
                                    u.setTelephone(rsul.getInt(6));
                                    u.setAdresse(rsul.getString(7));
                                    u.setPhoto(rsul.getString(8));
                                    
            //,resp_stationMultiService,resp_autoEcole,resp_boutique
            listeInfoUser.add(u);
        }
               return listeInfoUser;
        }catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement du profile utilisateur" + ex.getMessage());
        }
            return null;
    }
    
    public Utilisateur afficher(int id) throws SQLException{
       
        
        String req = "SELECT cin,nom,prenom,email,telephone,adresse,photo,resp_stationMultiService,resp_autoEcole,resp_boutique FROM utilisateur where id_utilisateur='"+id+"'";
        try {
        Statement statement = ServiceFactory.connect.createStatement();
            ResultSet rsul = statement.executeQuery(req);
            
            
            
            
                while (rsul.next()){
                        
                        Utilisateur u = new Utilisateur();
                                    u.setCin(rsul.getInt(1));                                         
                                    u.setNom(rsul.getString(2));
                                    u.setPrenom(rsul.getString(3));
                                    u.setEmail(rsul.getString(4));
                                    u.setTelephone(rsul.getInt(5));
                                    u.setAdresse(rsul.getString(6));
                                           
            
            
        }
        }catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement du profile utilisateur" + ex.getMessage());
        }
            return null;
    }
  
    public void ajouter(Utilisateur u){
        try {
            String req = "INSERT INTO utilisateur(cin,administrateur,nom,prenom,email,telephone,adresse,password,photo,resp_stationMultiService,resp_autoEcole,resp_boutique)VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            ste =connect.prepareStatement(req);
            ste.setInt(1,u.getCin());
            ste.setBoolean(2,u.getAdministrateur());
            ste.setString(3,u.getNom());
            ste.setString(4,u.getPrenom());
            ste.setString(5,u.getEmail());
            ste.setInt(6,u.getTelephone());
            ste.setString(7,u.getAdresse());
            ste.setString(8, u.getPassword());
            ste.setString(9, u.getPhoto());
            ste.setBoolean(10, u.getRespstationMultiService());
            ste.setBoolean(11, u.getRespautoEcole());
            ste.setBoolean(12, u.getRespBoutique());
            ste.executeUpdate();//insert update delete
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void supprimer(int id)
    {
            try {
            String req = "DELETE from utilisateur WHERE id_utilisateur=?";
            ste = ServiceFactory.connect.prepareStatement(req);
            ste.setInt(1,id); 
            ste.executeUpdate();
                        System.out.println("ok deleted");

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("not deleted");
        }
    }
    public void modifier(Utilisateur u, int id)
    {
        try {
            String req = "UPDATE utilisateur "
                    + "SET adresse=?,telephone=?,password=?,photo=? WHERE id_utilisateur='"+Session.getInstance().getCurrent().getIdUtilisateur()+"'";
            ste = connect.prepareStatement(req);
            ste.setString(1,u.getAdresse());
            ste.setInt(2,u.getTelephone());
            ste.setString(3,u.getPassword());
            ste.setString(4,u.getPhoto());
            ste.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modifierInfo(Utilisateur u)
    {
        try {
            String req = "UPDATE utilisateur SET cin=?,telephone=?,adresse=? WHERE id_utilisateur='"+Session.getInstance().getCurrent().getIdUtilisateur()+"'";
            ste = connect.prepareStatement(req);
            
            ste.setInt(1,u.getCin());
            ste.setInt(2,u.getTelephone());
            ste.setString(3,u.getAdresse());
            
            
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
