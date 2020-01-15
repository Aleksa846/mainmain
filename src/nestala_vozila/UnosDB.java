/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nestala_vozila;

import java.sql.*;


public class UnosDB {
    private Connection konekcija;
    private Statement st;
    private ResultSet rs;
    public UnosDB(){
    try{
            Class.forName("com.mysql.jdbc.Driver");
            konekcija= DriverManager.getConnection("jdbc:mysql://localhost:3306/vozila","root","");
            st= konekcija.createStatement();
        }catch(Exception ex){
            System.out.println("err"+ex);
        }
    }
     public  UnosDB(String marka, String model, String registracija, String sasija, String brTablica, String vlasnik) {
       try{
           
           String query="insert into vozila values("+marka+","+model+","+registracija+","+sasija+","+brTablica+","+vlasnik+")";
                   
           PreparedStatement preparedStmt=konekcija.prepareStatement(query);
           preparedStmt.execute();
           System.out.println("Uspesno uneto nestalo vozilo.");
       }
       catch(Exception ex){
           System.out.println("Greska");
       }
   }

    }
