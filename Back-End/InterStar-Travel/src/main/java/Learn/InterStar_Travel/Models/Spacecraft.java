package Learn.InterStar_Travel.Models;

public class Spacecraft {
    private int spacecraftId;
    private String spacecraftName;
    private int maxPassengers;
    private String maxPayload;
    private int stages;
    private String spacecraftStatus;
    private String specificImpulse;

    private int spacelineId;

    public Spacecraft(){}

    public Spacecraft(int spacecraftId, String spacecraftName, int maxPassengers, String maxPayload,
    int stages, String spacecraftStatus, String specificImpulse){
        this.spacecraftId = spacecraftId;
        this.spacecraftName = spacecraftName;
        this.maxPassengers = maxPassengers;
        this.maxPayload = maxPayload;
        this.stages = stages;
        this.spacecraftStatus = spacecraftStatus;
        this.specificImpulse = specificImpulse;
    }

    public int getSpacelineId() {
        return spacelineId;
    }

    public void setSpacelineId(int spacelineId) {
        this.spacelineId = spacelineId;
    }

    public String getSpecificImpulse() {
        return specificImpulse;
    }

    public void setSpecificImpulse(String specificImpulse) {
        this.specificImpulse = specificImpulse;
    }

    public String getSpacecraftStatus() {
        return spacecraftStatus;
    }

    public void setSpacecraftStatus(String spacecraftStatus) {
        this.spacecraftStatus = spacecraftStatus;
    }

    public int getStages() {
        return stages;
    }

    public void setStages(int stages) {
        this.stages = stages;
    }

    public String getMaxPayload() {
        return maxPayload;
    }

    public void setMaxPayload(String maxPayload) {
        this.maxPayload = maxPayload;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public String getSpacecraftName() {
        return spacecraftName;
    }

    public void setSpacecraftName(String spacecraftName) {
        this.spacecraftName = spacecraftName;
    }

    public int getSpacecraftId() {
        return spacecraftId;
    }

    public void setSpacecraftId(int spacecraftId) {
        this.spacecraftId = spacecraftId;
    }
}
