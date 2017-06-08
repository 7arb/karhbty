/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.karhbty.datasource;

import app.karhbty.entities.Utilisateur;

/**
 *
 * @author Saleh
 */
public class Session {
    private Utilisateur current;
    private static Session single;
    
    //Constructeur privé
    private Session(Utilisateur obj) {
        current = obj;
    }

    //Méthode qui va nous retourner notre instance et la créer si elle n'existe pas
    public static void connect(Utilisateur obj) {
        if (single == null) {
            single = new Session(obj);
        }
    }
    
    public static Session getInstance() {
        return single;
    }
    
    //accesseur
    public Utilisateur getCurrent() {
        return this.current;
    }
    
    public static void logOut(){
        single = null;
    }
}
