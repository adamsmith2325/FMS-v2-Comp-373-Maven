package adamSmithComp373Proj1.DAL;
import adamSmithComp373Proj1.DAL.DBHelper;
import java.sql.*;

import java.util.ArrayList;


public class FacilityDAO {

    private static DBHelper DB = new DBHelper();

    private static Connection con = DB.formConnection();


    public ArrayList<String> getFacilityDetails(Integer ID){
        
        ArrayList<String> facilityDetails = new ArrayList<String>();
        
        try{              
            Statement stmt=con.createStatement();
            String query = "select * from facilities where idFacilities = "+ ID; 
            
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                facilityDetails.add(rs.getString(1)); //Grabbing the ID from the database
                facilityDetails.add(rs.getString(2)); //Grabbing the name from the database
                facilityDetails.add(rs.getString(3)); //Grabbing the Location from the database
                facilityDetails.add(rs.getString(4)); //Grabbing the phone from the database
                facilityDetails.add(rs.getString(5)); //Grabbing the number of rooms from the database
                facilityDetails.add(rs.getString(6)); //Grabbing the number of occupied rooms
            }
            
            return facilityDetails;

        }catch(Exception e){ 
            facilityDetails.add("Error when accessing database");
            return facilityDetails;
            }  
        }




            public ArrayList<String> listFacilities(){
                
                ArrayList<String> allFacilities = new ArrayList<String>();

                try{  
                    Statement stmt=con.createStatement();  
                    
                    String query = "select * from facilities";
                    
                    ResultSet rs=stmt.executeQuery(query);  
                    
                    while(rs.next())  
                        allFacilities.add(rs.getString(2) + " - id: " + rs.getInt(1));
                    return allFacilities;
        
                }catch(Exception e){ 
                    allFacilities.add("Error");
                    return allFacilities;
                    }  
                }
            
                public void addNewFacility(String name, String location, String phone, Integer numOfRooms){
                    try{  
                        Statement stmt=con.createStatement();  
                        
                        String query = "INSERT INTO facilities(Name,Location,phoneNumber,numOfRooms) VALUES(" + "'" + name + "','" + location + "','" + phone + "','" + numOfRooms + "')";
                        Integer rs=stmt.executeUpdate(query);
                        if(rs == 1){
                        System.out.println("Facility Added");
                        }else{
                            System.out.println("Problem with insert");
                        }
                    }catch(Exception e){ 
                        System.out.println(e);
                    }
                }
            
                public void removeFacility(Integer RemovalID){
                try{ 
                    Statement stmt=con.createStatement();      
                    String query = "DELETE FROM facilities WHERE idFacilities = " + RemovalID;
                    Integer rs=stmt.executeUpdate(query);
                    System.out.println("Facility " + RemovalID + " Deleted");
                }catch(Exception e){ 
                    System.out.println(e.toString());
                }
                }
            
                
                //Get functionalities
                
                public String getName(Integer SearchID){
                    String returnString ="";
                    try{              
                        Statement stmt=con.createStatement();
                        String query = "select * from facilities where idFacilities = "+ SearchID; 
                        
                        ResultSet rs=stmt.executeQuery(query);
                        while(rs.next()){
                            returnString = rs.getString(2);
                        }
                        
                        }catch(Exception e){ 
                            returnString = e.toString();
                        }
                        
                        return returnString;
                        
                    }
            
                public String getLocation(Integer SearchID){
                    String returnString ="";
                    try{              
                        Statement stmt=con.createStatement();
                        String query = "select * from facilities where idFacilities = "+ SearchID; 
                        
                        ResultSet rs=stmt.executeQuery(query);
                        while(rs.next()){
                            returnString = rs.getString(3);
                        }
                        
                        }catch(Exception e){ 
                            returnString = e.toString();
                        }
                        
                        return returnString;
                        
                    }
            
                public String getPhone(Integer SearchID){
                        String returnString ="";
                    try{              
                        Statement stmt=con.createStatement();
                        String query = "select * from facilities where idFacilities = "+ SearchID; 
                        
                        ResultSet rs=stmt.executeQuery(query);
                        while(rs.next()){
                            returnString = rs.getString(4);
                        }
                        
                        }catch(Exception e){ 
                            returnString = e.toString();
                        }
                        
                        return returnString;
                        
                    }
            
                public Integer getNumberOfRooms(Integer SearchID){
                    Integer returnInt = null;
                    try{              
                        Statement stmt=con.createStatement();
                        String query = "select * from facilities where idFacilities = "+ SearchID; 
                        
                        ResultSet rs=stmt.executeQuery(query);
                        while(rs.next()){
                            returnInt = rs.getInt(5);
                        }
                        
                        }catch(Exception e){ 
                            returnInt = 99999999;
                        }
                        
                        return returnInt;
                        
                    }
            
            
            
                //Set functionalities
            
                public void setName(Integer Id, String newName){
                    try{ 
                        Statement stmt=con.createStatement();      
                        String query = "UPDATE facilities " + "SET Name = " + "'" +  newName + "'" + " WHERE idFacilities = " + Id;
                        Integer rs=stmt.executeUpdate(query);
                        System.out.println("Facility " + Id + "'s name has been updated");
                    }catch(Exception e){ 
                        System.out.println(e.toString());
                    }
                }
            
                public void setLocation(Integer Id, String newLocation){
                    try{ 
                        Statement stmt=con.createStatement();      
                        String query = "UPDATE facilities " + "SET Location = " + "'" +  newLocation + "'" + " WHERE idFacilities = " + Id;
                        Integer rs=stmt.executeUpdate(query);
                        System.out.println("Facility " + Id + "'s location has been updated");
                    }catch(Exception e){ 
                        System.out.println(e.toString());
                    }
                }
            
                public void setPhone(Integer Id, String newPhone){
                    try{ 
                        Statement stmt=con.createStatement();      
                        String query = "UPDATE facilities " + "SET phoneNumber = " + "'" +  newPhone + "'" + " WHERE idFacilities = " + Id;
                        Integer rs=stmt.executeUpdate(query);
                        System.out.println("Facility " + Id + "'s phone number has been updated");
                    }catch(Exception e){ 
                        System.out.println(e.toString());
                    }
                }
            
                public void setNumberOfRooms(Integer Id, Integer newRoomsNum){
                    try{ 
                        Statement stmt=con.createStatement();      
                        String query = "UPDATE facilities " + "SET numOfRooms = " + "'" +  newRoomsNum + "'" + " WHERE idFacilities = " + Id;
                        Integer rs=stmt.executeUpdate(query);
                        System.out.println("Facility " + Id + "'s number of rooms has been updated");
                    }catch(Exception e){ 
                        System.out.println(e.toString());
                    }
                }

                public void updateOccupiedRooms(Integer change, Integer ID){
                    Integer updateNum = getOccupiedRooms(ID) + change;
                    try{ 
                        Statement stmt=con.createStatement();      
                        String query = "UPDATE facilities " + "SET OccupiedRooms = " + "'" + updateNum + "'" + " WHERE idFacilities = " + ID;
                        Integer rs=stmt.executeUpdate(query);
                        System.out.println("Facility " + ID + "'s list of available rooms has been updated");
                    }catch(Exception e){ 
                        System.out.println(e.toString());
                    }
                }

                
                public static  Integer getOccupiedRooms(Integer ID){
                    Integer Occupied = null;
                    try{
                        Statement stmt=con.createStatement();
                        String query = "select OccupiedRooms from facilities where idFacilities = " + ID; 
                        
                        ResultSet rs=stmt.executeQuery(query);
                        while(rs.next()){
                            Occupied = rs.getInt(1);
                        }
                            

                        }catch(Exception e){ 
                            System.out.println(e.toString());
                        }
                        return Occupied;   

                }



                
        public static void main(String args[]){
            //System.out.println(getFacilityDetails(1));
            //addNewFacility("Adam Insert Test", "Address", "4062039222", 10);
            //System.out.println(getFacilityDetails(7));
            //setName(3, "Set Name Test 2");
            //setLocation(3, "1357 W Touhy Avenue, Apartment 1S, Chicago, IL 60626");
            //setPhone(3, "9062039222");
            //setNumberOfRooms(3, 2);
            //System.out.println(listFacilities());
            //ArrayList<Integer> testList = new ArrayList<Integer>();
            //testList.add(1);
            //testList.add(2);
            //testList.remove(1);
            //updateOccupiedRooms(testList, 3);
            
        }

    }

    