package Learn.InterStar_Travel.Models;

public class Destination {
    private int destinationId;
    private String destinationName;
    private String destinationDescription;
    private String imageUrl;

    public Destination(){}

    public Destination(int destinationId, String destinationName, String destinationDescription, String imageUrl){
        this.destinationId = destinationId;
        this.destinationName = destinationName;
        this.destinationDescription = destinationDescription;
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDestinationDescription() {
        return destinationDescription;
    }

    public void setDestinationDescription(String destinationDescription) {
        this.destinationDescription = destinationDescription;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public int getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }
}
