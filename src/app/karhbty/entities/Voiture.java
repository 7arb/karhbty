/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.karhbty.entities;
import java.util.Date;

import java.util.Objects;

/**
 *
 * @author Saleh
 */
public class Voiture {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




   private int idVoiture;
   private String matricule;
   private String marque;
   private String modele;
   private Date date_mec;
   private String couleur;
   private int nbr_cheveaux;
   private int kilometrage;
   private String energie;
   private int vendeur,utilisateur;
   private Date date_assurance;
   private Date date_pneu,date_VT,date_vidg,date_croix;
   private Date date_vignette;
   private String photo1,photo2,photo3;

    public Voiture() {
    }

    public Voiture(String matricule, String marque, String modele, Date date_mec, String couleur, int nbr_cheveaux, int kilometrage, String energie, int vendeur, Date date_assurance, Date date_pneu, Date date_VT, Date date_vidg, Date date_croix, Date date_vignette, String photo1, String photo2, String photo3, int utilisateur) {
        this.matricule = matricule;
        this.marque = marque;
        this.modele = modele;
        this.date_mec = date_mec;
        this.couleur = couleur;
        this.nbr_cheveaux = nbr_cheveaux;
        this.kilometrage = kilometrage;
        this.energie = energie;
        this.vendeur = vendeur;
        
        this.date_assurance = date_assurance;
        this.date_pneu = date_pneu;
        this.date_VT = date_VT;
        this.date_vidg = date_vidg;
        this.date_croix = date_croix;
        this.date_vignette = date_vignette;
        this.photo1 = photo1;
        this.photo2 = photo2;
        this.photo3 = photo3;
        this.utilisateur = utilisateur;
    }
//
//    public Voiture(String matricule, String marque, String modele, Date date_mec, String couleur, int nbr_cheveaux, int kilometrage, String energie, Date date_assurance, Date date_pneu, Date date_VT, Date date_vidg, Date date_croix, Date date_vignette, String photo1, String photo2, String photo3) {
//        this.matricule = matricule;
//        this.marque = marque;
//        this.modele = modele;
//        this.date_mec = date_mec;
//        this.couleur = couleur;
//        this.nbr_cheveaux = nbr_cheveaux;
//        this.kilometrage = kilometrage;
//        this.energie = energie;
//        this.date_assurance = date_assurance;
//        this.date_pneu = date_pneu;
//        this.date_VT = date_VT;
//        this.date_vidg = date_vidg;
//        this.date_croix = date_croix;
//        this.date_vignette = date_vignette;
//        this.photo1 = photo1;
//        this.photo2 = photo2;
//        this.photo3 = photo3;
//    }

    public Voiture(int idVoiture, String matricule, String marque, String modele, Date date_mec, String couleur, int nbr_cheveaux, int kilometrage, String energie, Date date_assurance, Date date_pneu, Date date_VT, Date date_vidg, Date date_croix, Date date_vignette, String photo1, String photo2, String photo3) {
        this.idVoiture = idVoiture;
        this.matricule = matricule;
        this.marque = marque;
        this.modele = modele;
        this.date_mec = date_mec;
        this.couleur = couleur;
        this.nbr_cheveaux = nbr_cheveaux;
        this.kilometrage = kilometrage;
        this.energie = energie;
        this.date_assurance = date_assurance;
        this.date_pneu = date_pneu;
        this.date_VT = date_VT;
        this.date_vidg = date_vidg;
        this.date_croix = date_croix;
        this.date_vignette = date_vignette;
        this.photo1 = photo1;
        this.photo2 = photo2;
        this.photo3 = photo3;
    }

//    public Voiture(String matricule, String marque, String modele, String couleur, int nbr_cheveaux, int kilometrage, String energie, String photo1, String photo2, String photo3) {
//        this.matricule = matricule;
//        this.marque = marque;
//        this.modele = modele;
//        this.couleur = couleur;
//        this.nbr_cheveaux = nbr_cheveaux;
//        this.kilometrage = kilometrage;
//        this.energie = energie;
//        this.photo1 = photo1;
//        this.photo2 = photo2;
//        this.photo3 = photo3;
//    }

    
    

    
    

    public int getIdVoiture() {
        return idVoiture;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public Date getDate_mec() {
        return date_mec;
    }

    public String getCouleur() {
        return couleur;
    }

    public int getNbr_cheveaux() {
        return nbr_cheveaux;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public String getEnergie() {
        return energie;
    }

    public int getVendeur() {
        return vendeur;
    }

    public int getUtilisateur() {
        return utilisateur;
    }

    public Date getDate_assurance() {
        return date_assurance;
    }

    public Date getDate_pneu() {
        return date_pneu;
    }

    public Date getDate_VT() {
        return date_VT;
    }

    public Date getDate_vidg() {
        return date_vidg;
    }

    public Date getDate_croix() {
        return date_croix;
    }

    public Date getDate_vignette() {
        return date_vignette;
    }

    public String getPhoto1() {
        return photo1;
    }

    public String getPhoto2() {
        return photo2;
    }

    public String getPhoto3() {
        return photo3;
    }

    public void setIdVoiture(int idVoiture) {
        this.idVoiture = idVoiture;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public void setDate_mec(Date date_mec) {
        this.date_mec = date_mec;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void setNbr_cheveaux(int nbr_cheveaux) {
        this.nbr_cheveaux = nbr_cheveaux;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    public void setEnergie(String energie) {
        this.energie = energie;
    }

    public void setVendeur(int vendeur) {
        this.vendeur = vendeur;
    }

    public void setUtilisateur(int utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setDate_assurance(Date date_assurance) {
        this.date_assurance = date_assurance;
    }

    public void setDate_pneu(Date date_pneu) {
        this.date_pneu = date_pneu;
    }

    public void setDate_VT(Date date_VT) {
        this.date_VT = date_VT;
    }

    public void setDate_vidg(Date date_vidg) {
        this.date_vidg = date_vidg;
    }

    public void setDate_croix(Date date_croix) {
        this.date_croix = date_croix;
    }

    public void setDate_vignette(Date date_vignette) {
        this.date_vignette = date_vignette;
    }

    public void setPhoto1(String photo1) {
        this.photo1 = photo1;
    }

    public void setPhoto2(String photo2) {
        this.photo2 = photo2;
    }

    public void setPhoto3(String photo3) {
        this.photo3 = photo3;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Voiture other = (Voiture) obj;
        if (this.idVoiture != other.idVoiture) {
            return false;
        }
        if (this.nbr_cheveaux != other.nbr_cheveaux) {
            return false;
        }
        if (this.kilometrage != other.kilometrage) {
            return false;
        }
        if (!Objects.equals(this.matricule, other.matricule)) {
            return false;
        }
        if (!Objects.equals(this.marque, other.marque)) {
            return false;
        }
        if (!Objects.equals(this.modele, other.modele)) {
            return false;
        }
        if (!Objects.equals(this.couleur, other.couleur)) {
            return false;
        }
        if (!Objects.equals(this.energie, other.energie)) {
            return false;
        }
        if (!Objects.equals(this.photo1, other.photo1)) {
            return false;
        }
        if (!Objects.equals(this.photo2, other.photo2)) {
            return false;
        }
        if (!Objects.equals(this.photo3, other.photo3)) {
            return false;
        }
        if (!Objects.equals(this.date_mec, other.date_mec)) {
            return false;
        }
        if (!Objects.equals(this.vendeur, other.vendeur)) {
            return false;
        }
        if (!Objects.equals(this.utilisateur, other.utilisateur)) {
            return false;
        }
        if (!Objects.equals(this.date_assurance, other.date_assurance)) {
            return false;
        }
        if (!Objects.equals(this.date_pneu, other.date_pneu)) {
            return false;
        }
        if (!Objects.equals(this.date_VT, other.date_VT)) {
            return false;
        }
        if (!Objects.equals(this.date_vidg, other.date_vidg)) {
            return false;
        }
        if (!Objects.equals(this.date_croix, other.date_croix)) {
            return false;
        }
        if (!Objects.equals(this.date_vignette, other.date_vignette)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Voiture{" + "id=" + idVoiture + ", matricule=" + matricule + ", marque=" + marque + ", modele=" + modele + ", date_mec=" + date_mec + ", couleur=" + couleur + ", nbr_cheveaux=" + nbr_cheveaux + ", kilometrage=" + kilometrage + ", energie=" + energie + ", vendeur=" + vendeur + ", utilisateur=" + utilisateur + ", date_assurance=" + date_assurance + ", date_pneu=" + date_pneu + ", date_VT=" + date_VT + ", date_vidg=" + date_vidg + ", date_croix=" + date_croix + ", date_vignette=" + date_vignette + ", photo1=" + photo1 + ", photo2=" + photo2 + ", photo3=" + photo3 + '}';
    }

    
   

}
