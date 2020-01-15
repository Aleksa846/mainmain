package nestala_vozila;

import java.sql.*;

public class VozilaDB {
    private Connection konekcija;
    private Statement st;
    private ResultSet rez;
    
    public VozilaDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            konekcija= DriverManager.getConnection("jdbc:mysql://localhost:3306/automobili","root","");
            st= konekcija.createStatement();
        }catch(Exception ex){
            System.out.println("err"+ex);
        }
    }
        
    public void getData(){
        try{
            String query= "Select * From vozila";
            rez= st.executeQuery(query);
            System.out.println("rezz");
            while(rez.next()){
                String marka= rez.getString("Marka");
                String model= rez.getString("Model");
                String registracija= rez.getString("Registracija");
                String sasija= rez.getString("Sasija");
                String brTablica= rez.getString("BrTablica");
                String vlasnik= rez.getString("Vlasnik");
                System.out.println("Vlasnik "+vlasnik+" "+"Marka "+marka+" "+"Model "+ model+" "+"registracija "+registracija+" "+"Sasija "+sasija+" "+"BrTablica "+brTablica);
            }
        }catch(Exception ex){
            System.out.println(ex);
}
}
  
}
