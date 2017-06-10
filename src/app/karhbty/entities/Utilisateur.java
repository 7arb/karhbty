/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.karhbty.entities;



/**
 *
 * @author Saleh
 */
public class Utilisateur {

    private Integer idUtilisateur;
    private int cin;
    private boolean administrateur;
    private String nom;
    private String prenom;
    private String email;
    private int telephone;
    private String adresse;
    private String password;
    private String photo;
    private boolean respstationMultiService;
    private boolean respautoEcole;
    private boolean respBoutique;

    public Utilisateur() {
    }

    
    public Utilisateur(int cin, int telephone, String adresse) {
        this.cin = cin;
        this.telephone = telephone;
        this.adresse = adresse;
    }

    public Utilisateur(int cin, String nom, String prenom, String email, int telephone, String adresse, String password) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
        this.password = password;
    }

    
    
    public Utilisateur(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    public Utilisateur(String email, String password,boolean administrateur) {
        this.email = email;
        this.password = password;
        this.administrateur= administrateur;
    }

    
    public Utilisateur(Integer idUtilisateur, int cin, boolean administrateur, String nom, String prenom, String email, int telephone, String adresse, String password, String photo, boolean respstationMultiService, boolean respautoEcole, boolean respBoutique) {
        this.idUtilisateur = idUtilisateur;
        this.cin = cin;
        this.administrateur = administrateur;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
        this.password = password;
        this.photo = photo;
        this.respstationMultiService = respstationMultiService;
        this.respautoEcole = respautoEcole;
        this.respBoutique = respBoutique;
    }
    
     
    public Utilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Utilisateur(int cin, boolean administrateur, String nom, String prenom, String email, int telephone, String adresse, String password, String photo, boolean respstationMultiService, boolean respautoEcole, boolean respBoutique) {
        
        this.cin = cin;
        this.administrateur = administrateur;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
        this.password = password;
        this.photo = photo;
        this.respstationMultiService = respstationMultiService;
        this.respautoEcole = respautoEcole;
        this.respBoutique = respBoutique;
    }

public Utilisateur(int idUtilisateur, int cin, boolean administrateur, String nom, String prenom, String email, int telephone, String adresse, String password, String photo, boolean respstationMultiService, boolean respautoEcole, boolean respBoutique) {
        this.idUtilisateur = idUtilisateur;
        this.cin = cin;
        this.administrateur = administrateur;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
        this.password = password;
        
        this.photo = photo;
        this.respstationMultiService = respstationMultiService;
        this.respautoEcole = respautoEcole;
        this.respBoutique = respBoutique;
    }

    public Utilisateur(int cin, String nom, String prenom, String email, int telephone, String adresse, String password, String photo, boolean respstationMultiService, boolean respautoEcole, boolean respBoutique) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
        this.password = password;
        this.photo = photo;
        this.respstationMultiService = respstationMultiService;
        this.respautoEcole = respautoEcole;
        this.respBoutique = respBoutique;
    }
    

    public Utilisateur(int idUtilisateur, int cin, String nom, String prenom, String email, int telephone, String adresse, String password,String photo, boolean respstationMultiService, boolean respautoEcole, boolean respBoutique) {
        this.idUtilisateur = idUtilisateur;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
        this.password = password;
        this.photo = photo;
        this.respstationMultiService = respstationMultiService;
        this.respautoEcole = respautoEcole;
        this.respBoutique = respBoutique;
    }   
    

    public Utilisateur(String nom, String prenom, String email, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }

    public Utilisateur(int telephone , String adresse, String password, String photo) {
        this.telephone = telephone;
        this.adresse = adresse;
        this.password = password;
        this.photo = photo;
    }

    public Utilisateur(int idUtilisateur, String nom, String prenom, String email, String password) {
        this.idUtilisateur=idUtilisateur;
        this.nom=nom;
        this.prenom=prenom;
        this.email=email;
        this.password=password;
    }
    
    

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public boolean getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(boolean administrateur) {
        this.administrateur = administrateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean getRespstationMultiService() {
        return respstationMultiService;
    }

    public void setRespstationMultiService(boolean respstationMultiService) {
        this.respstationMultiService = respstationMultiService;
    }

    public boolean getRespautoEcole() {
        return respautoEcole;
    }

    public void setRespautoEcole(boolean respautoEcole) {
        this.respautoEcole = respautoEcole;
    }

    public boolean getRespBoutique() {
        return respBoutique;
    }

    public void setRespBoutique(boolean respBoutique) {
        this.respBoutique = respBoutique;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUtilisateur != null ? idUtilisateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.idUtilisateur == null && other.idUtilisateur != null) || (this.idUtilisateur != null && !this.idUtilisateur.equals(other.idUtilisateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "idUtilisateur=" + idUtilisateur + ", cin=" + cin + ", administrateur=" + administrateur + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", telephone=" + telephone + ", adresse=" + adresse + ", password=" + password + ", photo=" + photo + ", respstationMultiService=" + respstationMultiService + ", respautoEcole=" + respautoEcole + ", respBoutique=" + respBoutique + '}';
    }

    
    
}
