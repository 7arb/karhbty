/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.karhbty.entities;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author amira
 */
public class Notification {
    public int id_notification;
    public String libelle_notification;
    public Date date_notification;
    public String objet_notification;
    public Voiture id_voiture;
  

    public Notification() {
    }

    public Notification(int id_notification, String libelle_notification, Date date_notification, String objet_notification) {
        this.id_notification = id_notification;
        this.libelle_notification = libelle_notification;
        this.date_notification = date_notification;
        this.objet_notification = objet_notification;
    }

    public Notification(int id_notification, String libelle_notification, Date date_notification, String objet_notification, Voiture id_voiture) {
        this.id_notification = id_notification;
        this.libelle_notification = libelle_notification;
        this.date_notification = date_notification;
        this.objet_notification = objet_notification;
        this.id_voiture = id_voiture;
    }

    public int getId_notification() {
        return id_notification;
    }

    public String getLibelle_notification() {
        return libelle_notification;
    }

    public Date getDate_notification() {
        return date_notification;
    }

    public String getObjet_notification() {
        return objet_notification;
    }

    public Voiture getId_voiture() {
        return id_voiture;
    }

    public void setId_notification(int id_notification) {
        this.id_notification = id_notification;
    }

    public void setLibelle_notification(String libelle_notification) {
        this.libelle_notification = libelle_notification;
    }

    public void setDate_notification(Date date_notification) {
        this.date_notification = date_notification;
    }

    public void setObjet_notification(String objet_notification) {
        this.objet_notification = objet_notification;
    }

    public void setId_voiture(Voiture id_voiture) {
        this.id_voiture = id_voiture;
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
        final Notification other = (Notification) obj;
        if (this.id_notification != other.id_notification) {
            return false;
        }
        if (!Objects.equals(this.libelle_notification, other.libelle_notification)) {
            return false;
        }
        if (!Objects.equals(this.objet_notification, other.objet_notification)) {
            return false;
        }
        if (!Objects.equals(this.date_notification, other.date_notification)) {
            return false;
        }
        if (!Objects.equals(this.id_voiture, other.id_voiture)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Notification{" + "id_notification=" + id_notification + ", libelle_notification=" + libelle_notification + ", date_notification=" + date_notification + ", objet_notification=" + objet_notification + ", id_voiture=" + id_voiture + '}';
    }
    

}