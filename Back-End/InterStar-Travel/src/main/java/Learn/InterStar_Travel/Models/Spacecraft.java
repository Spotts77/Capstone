package Learn.InterStar_Travel.Models;

public class Spacecraft {
    private int spacecraftId;
    private String spacecraftName;
    private int maxPassengers;
    private String maxPayload;
    private int stages;
    private String spacecraftStatus;
    private String specificImpulse;

    private Spaceline spaceline;

    public Spaceline getSpaceline() {
        return spaceline;
    }

    public void setSpaceline(Spaceline spaceline) {
        this.spaceline = spaceline;
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
