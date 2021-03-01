package adamSmithComp373Proj1.Domain;
import adamSmithComp373Proj1.Domain.*;

enum RequestType {Repair, Cleaning, BrokenItem}

public class FacilityMaintainence implements Facility {

    private Integer RequestID;
    private int mainRequestID;
    private int facilityID;
    private String maintDetails;
    private int cost;
    private Facility facility;


    public int getRequestID() {
        return RequestID;
    }
    public void setRequestID(int RequestID) {
        this.RequestID = RequestID;
    }
    public int getMainRequestID() {
        return mainRequestID;
    }
    public void setMainRequestID(int mainRequestID) {
        this.mainRequestID = maintRequestID;
    }
    public int getFacilityID() {
        
        return facilityID;
    }
    public void setFacilityID(int facilityID) {
        this.facilityID = facilityID;
    }
    
}
