/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.karhbty.datasource;


import app.karhbty.services.NotificationService;
import app.karhbty.services.UserService;
import app.karhbty.services.VoitureService;
import java.sql.Connection;

/**
 *
 * @author Saleh
 */
public class ServiceFactory {
     public static final Connection connect =  DataSource.getInstance().getConnection();
    
 
    
    public static UserService getUser(){
        return new UserService(connect);
    }
    
    public static VoitureService getVoiture(){
        return new VoitureService(connect);
    }
    
    public static NotificationService getNotification(){
        return new NotificationService(connect);
    }
}
