package Learn.InterStar_Travel.Models;

public class Spaceport {
    private int spaceportId;
    private String spaceportName;
    private String contactNumber;
    private String facilities;
    private String yearEstablished;

    private int destinationId;

    public Spaceport(){}

    public Spaceport(int spaceportId, String spaceportName, String contactNumber,
                     String facilities, String yearEstablished){
        this.spaceportId = spaceportId;
        this.spaceportName = spaceportName;
        this.contactNumber = contactNumber;
        this.facilities = facilities;
        this.yearEstablished = yearEstablished;
    }

    public int getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    public String getYearEstablished() {
        return yearEstablished;
    }

    public void setYearEstablished(String yearEstablished) {
        this.yearEstablished = yearEstablished;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getSpaceportName() {
        return spaceportName;
    }

    public void setSpaceportName(String spaceportName) {
        this.spaceportName = spaceportName;
    }

    public int getSpaceportId() {
        return spaceportId;
    }

    public void setSpaceportId(int spaceportId) {
        this.spaceportId = spaceportId;
    }


}
