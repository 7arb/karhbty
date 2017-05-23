/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.karhbty.entities;

import java.util.Objects;

/**
 *
 * @author Saleh
 */
public class Administrateur extends Utilisateur{
    
    private String prenom;
    private long cin;

    public Administrateur(String prenom, long cin) {
        this.prenom = prenom;
        this.cin = cin;
    }

    public Administrateur(String prenom, long cin, Integer idUtilisateur) {
        super(idUtilisateur);
        this.prenom = prenom;
        this.cin = cin;
    }

    public Administrateur(Integer idUtilisateur, int cin, boolean administrateur, String nom, String prenom, String email, int telephone, String adresse, String password, String photo, boolean respstationMultiService, boolean respautoEcole, boolean respBoutique) {
        super(cin, administrateur, nom, prenom, email, telephone, adresse, password, photo, respstationMultiService, respautoEcole, respBoutique);
        this.prenom = prenom;
        
        this.cin = cin;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.prenom);
        hash = 97 * hash + (int) (this.cin ^ (this.cin >>> 32));
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
        final Administrateur other = (Administrateur) obj;
        if (this.cin != other.cin) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n + Administrateur{" + "prenom=" + prenom + ", numCin=" + cin + '}';
    }
    
}
