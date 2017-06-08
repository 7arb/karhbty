/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.karhbty.entities;

import java.util.Objects;

/**
 *
 * @author amira
 */
public class Panier {
    public int id_panier;
    public static int nbr_element_panier;
    Utilisateur id_utilisateur;
    Piece_Rechange id_pieceRechange;

    public Panier() {
    }

    public int getId_panier() {
        return id_panier;
    }

    public static int getNbr_element_panier() {
        return nbr_element_panier;
    }

    public Utilisateur getId_utilisateur() {
        return id_utilisateur;
    }

    public Piece_Rechange getId_pieceRechange() {
        return id_pieceRechange;
    }

    public Panier(int id_panier, Utilisateur id_utilisateur, Piece_Rechange id_pieceRechange) {
        this.id_panier = id_panier;
        this.id_utilisateur = id_utilisateur;
        this.id_pieceRechange = id_pieceRechange;
    }

    public void setId_panier(int id_panier) {
        this.id_panier = id_panier;
    }

    public static void setNbr_element_panier(int nbr_element_panier) {
        Panier.nbr_element_panier = nbr_element_panier;
    }

    public void setId_utilisateur(Utilisateur id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public void setId_pieceRechange(Piece_Rechange id_pieceRechange) {
        this.id_pieceRechange = id_pieceRechange;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Panier other = (Panier) obj;
        if (this.id_panier != other.id_panier) {
            return false;
        }
        if (!Objects.equals(this.id_utilisateur, other.id_utilisateur)) {
            return false;
        }
        if (!Objects.equals(this.id_pieceRechange, other.id_pieceRechange)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Panier{" + "id_panier=" + id_panier + ", id_utilisateur=" + id_utilisateur + ", id_pieceRechange=" + id_pieceRechange + '}';
    }
    
    
    
    
            }
