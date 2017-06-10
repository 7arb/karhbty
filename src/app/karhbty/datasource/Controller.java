/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.karhbty.datasource;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 *
 * @author Saleh
 */
public class Controller {
    
    
    public static java.sql.Date convertFromJAVADateToSQLDate(java.util.Date javaDate) {
        java.sql.Date sqlDate = null;
        if (javaDate != null) {
            sqlDate = new Date(javaDate.getTime());
        }
        return sqlDate;
    }
    public static java.util.Date convertFromSQLDateToJAVADate(
            java.sql.Date sqlDate) {
        java.util.Date javaDate = null;
        if (sqlDate != null) {
            javaDate =  new Date(sqlDate.getTime());
        }
        return javaDate;
    }
    
    public static java.util.Date asDate(LocalDate localDate) {
    return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
  }
    
}
