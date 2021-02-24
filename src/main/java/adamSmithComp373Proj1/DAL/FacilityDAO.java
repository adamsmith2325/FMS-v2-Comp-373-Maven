package adamSmithComp373Proj1.DAL;
import java.sql.*;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.ArrayList;


public class FacilityDAO {
    
    Dotenv dotenv = Dotenv.load();
    String  DBUser = dotenv.get("DATABASE_USERNAME");
    String  DBPass = dotenv.get("DATABASE_PASSWORD");
    



    public static ArrayList<String> getFacilityDetails(Integer ID){
        
        ArrayList<String> facilityDetails = new ArrayList<String>();
        
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/facilitymanagementsystem", "root", "root");  
            Statement stmt=con.createStatement();  
            
            String query = "select * from facilities where idFacilities = "+ ID; 
            
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                facilityDetails.add(rs.getString(1)); //Grabbing the ID from the database
                facilityDetails.add(rs.getString(2)); //Grabbing the name from the database
            }
            con.close();   
            return facilityDetails;

        }catch(Exception e){ 
            facilityDetails.add("Error when accessing database");
            return facilityDetails;
            }  
        }




            public static ArrayList<String> listFacilities(){
                
                ArrayList<String> allFacilities = new ArrayList<String>();

                try{  
                    Class.forName("com.mysql.jdbc.Driver");  
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/facilitymanagementsystem", "root", "root");  
                    Statement stmt=con.createStatement();  
                    
                    String query = "select * from facilities";
                    
                    ResultSet rs=stmt.executeQuery(query);  
                    
                    while(rs.next())  
                        allFacilities.add(rs.getString(2));
                    con.close();   
                    return allFacilities;
        
                }catch(Exception e){ 
                    allFacilities.add("Error");
                    return allFacilities;
                    }  
                }








                
        public static void main(String args[]){
            System.out.println(getFacilityDetails(1));
        }

    }

    