/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.karhbty.tests;

import app.karhbty.entities.Voiture;
import app.karhbty.services.UserService;
import app.karhbty.services.VoitureService;
import static app.karhbty.datasource.ServiceFactory.connect;
import java.util.Date;




/**
 *
 * @author Saleh
 */
public class Karhbty {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            
        //java.util.Date myDate = new java.util.Date("2017-04-01");
        //java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
       
        UserService user = new UserService(connect);
        VoitureService car = new VoitureService(connect);
        
//        user.add(new Utilisateur(12345678,true,"mdini","saleh","saleh@mdini.com",25818450,"laaouina","password","photo",false,false,false));
      //  car.ajouter(new Voiture ("10Tu10","peugeot","106",sqlDate,"gris",4,11000,"essence",sqlDate,sqlDate,sqlDate,sqlDate,sqlDate,sqlDate,"mldjqf","ljhgl","kjlhkdf"));
  //          car.lister();
                user.findByEmail("saleh", "saleh");
                System.out.println(user);
  int x=2;
                
                Date d=new Date(117,05,11);
//         Voiture v=new Voiture("152","peugeot","206",d,"rouge",6,1689,"",x,d,d,d,d,d,d,"","","",x);
//         
//   car.ajouterv2 (v);
//    TrayNotification tray = new TrayNotification("Success", " Voiture ajouter",NotificationType.SUCCESS);
//            tray.showAndDismiss(javafx.util.Duration.seconds(2));
   car.ajouterv3(new Voiture("152","peugeot","206",d,"rouge",6,1689,"",x,d,d,d,d,d,d,"","","",x));
   //car.add(new Voiture("11","bm","m3","noir",12,50000,"essence","dgf","dgf","dgf"));
    }
}