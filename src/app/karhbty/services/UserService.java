/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.karhbty.services;

import app.karhbty.entities.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import app.karhbty.entities.Administrateur;
/**
 *
 * @author Saleh
 */
public class UserService extends Service /*implements IUserService*/ {
    
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
    
    public void update(Utilisateur obj) {
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
    }

    
       
  
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
                
                if ("admin".equals(rs.getString("email")))  {
               System.out.println("ADMINISTRATEUR FOUND !!");
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
}
