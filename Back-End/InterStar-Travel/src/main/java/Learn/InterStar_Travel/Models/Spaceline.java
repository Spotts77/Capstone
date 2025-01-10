package Learn.InterStar_Travel.Models;

public class Spaceline {
    private int spacelineId;
    private String spacelineName;
    private String contactNumber;
    private String foundedYear;
    private int fleetSize;

    public int getFleetSize() {
        return fleetSize;
    }

    public void setFleetSize(int fleetSize) {
        this.fleetSize = fleetSize;
    }

    public String getFoundedYear() {
        return foundedYear;
    }

    public void setFoundedYear(String foundedYear) {
        this.foundedYear = foundedYear;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getSpacelineName() {
        return spacelineName;
    }

    public void setSpacelineName(String spacelineName) {
        this.spacelineName = spacelineName;
    }

    public int getSpacelineId() {
        return spacelineId;
    }

    public void setSpacelineId(int spacelineId) {
        this.spacelineId = spacelineId;
    }
}
