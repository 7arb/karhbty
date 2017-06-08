/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.karhbty.services;

import java.sql.Connection;

/**
 *
 * @author Saleh
 */
public abstract class Service {

    protected Connection connect = null;

    public Service(Connection conn) {
        this.connect = conn;
    }
}
