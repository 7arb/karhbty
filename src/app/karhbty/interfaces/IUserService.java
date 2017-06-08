/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.karhbty.interfaces;
import app.karhbty.entities.Utilisateur;
/**
 *
 * @author Saleh
 */
public interface IUserService {
    
         public abstract void add(Utilisateur obj);

    /**
     * Méthode pour supprimer 
     *
     * @param obj
     * @return boolean
     */
    public abstract boolean delete(Utilisateur obj);

    /**
     * Méthode pour modifier 
     *
     * @param obj
     * @return boolean
     */
    public abstract boolean update(Utilisateur obj);

    /**
     * Méthode pour rechercher des informations
     *
     * @param obj
     * @return boolean
     */
    public abstract boolean find(Utilisateur obj);

    
}
