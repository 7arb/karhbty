/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.karhbty.entities;

import java.sql.Timestamp;
import java.util.Objects;


/**
 *
 * @author Saleh
 */

public class Commentaire {

    private Integer id_commentaire;
    private Timestamp dateCommentaire;
    private String descriptionCommentaire;
    private Integer id_utilisateur;
    private Integer id_annonce;
    private Integer id_piece;
    private Integer id_boutique;
    private Integer id_testBlanc;
    private Integer id_code;
    private Integer idConduite;
    private Integer id_revisVidang;
    private Integer id_clim;
    private Integer id_elec;
    private Integer id_meca;

    public Commentaire() {
    }

    public Commentaire(Integer idCommentaire) {
        this.id_commentaire = id_commentaire;
    }

    public Commentaire(Integer id_commentaire, Timestamp dateCommentaire, String descriptionCommentaire,Integer id_utilisateur) {
        this.id_commentaire = id_commentaire;
        this.dateCommentaire = dateCommentaire;
        this.descriptionCommentaire = descriptionCommentaire;
        this.id_utilisateur = id_utilisateur;
    }   

    public Integer getIdCommentaire() {
        return id_commentaire;
    }

    public void setIdCommentaire(Integer idCommentaire) {
        this.id_commentaire = idCommentaire;
    }

    public Timestamp getDateCommentaire() {
        return dateCommentaire;
    }

    public void setDateCommentaire(Timestamp dateCommentaire) {
        this.dateCommentaire = dateCommentaire;
    }

    public String getDescriptionCommentaire() {
        return descriptionCommentaire;
    }

    public void setDescriptionCommentaire(String descriptionCommentaire) {
        this.descriptionCommentaire = descriptionCommentaire;
    }

    public Integer getIdConduite() {
        return idConduite;
    }

    public Integer getId_commentaire() {
        return id_commentaire;
    }

    public void setId_commentaire(Integer id_commentaire) {
        this.id_commentaire = id_commentaire;
    }

    public Integer getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(Integer id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public Integer getId_annonce() {
        return id_annonce;
    }

    public void setId_annonce(Integer id_annonce) {
        this.id_annonce = id_annonce;
    }

    public Integer getId_piece() {
        return id_piece;
    }

    public void setId_piece(Integer id_piece) {
        this.id_piece = id_piece;
    }

    public Integer getId_boutique() {
        return id_boutique;
    }

    public void setId_boutique(Integer id_boutique) {
        this.id_boutique = id_boutique;
    }

    public Integer getId_testBlanc() {
        return id_testBlanc;
    }

    public void setId_testBlanc(Integer id_testBlanc) {
        this.id_testBlanc = id_testBlanc;
    }

    public Integer getId_code() {
        return id_code;
    }

    public void setId_code(Integer id_code) {
        this.id_code = id_code;
    }

    public Integer getId_revisVidang() {
        return id_revisVidang;
    }

    public void setId_revisVidang(Integer id_revisVidang) {
        this.id_revisVidang = id_revisVidang;
    }

    public Integer getId_clim() {
        return id_clim;
    }

    public void setId_clim(Integer id_clim) {
        this.id_clim = id_clim;
    }

    public Integer getId_elec() {
        return id_elec;
    }

    public void setId_elec(Integer id_elec) {
        this.id_elec = id_elec;
    }

    public Integer getId_meca() {
        return id_meca;
    }

    public void setId_meca(Integer id_meca) {
        this.id_meca = id_meca;
    }

    
    
    public void setIdConduite(Integer idConduite) {
        this.idConduite = idConduite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_commentaire != null ? id_commentaire.hashCode() : 0);
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
        final Commentaire other = (Commentaire) obj;
        if (!Objects.equals(this.id_commentaire, other.id_commentaire)) {
            return false;
        }
        if (!Objects.equals(this.dateCommentaire, other.dateCommentaire)) {
            return false;
        }
        if (!Objects.equals(this.id_utilisateur, other.id_utilisateur)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id_commentaire=" + id_commentaire + ", dateCommentaire=" + dateCommentaire + ", descriptionCommentaire=" + descriptionCommentaire + ", id_utilisateur=" + id_utilisateur + ", id_annonce=" + id_annonce + ", id_piece=" + id_piece + ", id_boutique=" + id_boutique + ", id_testBlanc=" + id_testBlanc + ", id_code=" + id_code + ", idConduite=" + idConduite + ", id_revisVidang=" + id_revisVidang + ", id_clim=" + id_clim + ", id_elec=" + id_elec + ", id_meca=" + id_meca + '}';
    }

    
    
}
