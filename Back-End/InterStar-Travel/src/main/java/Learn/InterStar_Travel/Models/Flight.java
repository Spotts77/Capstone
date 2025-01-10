package Learn.InterStar_Travel.Models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Flight {
    private int flightId;
    private String flightName;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int pricePerTicket;
    private LocalDate departureDate;

    private Spaceport departurePort;
    private Spaceport arrivalPort;

    private Spacecraft spacecraft;

    public Spacecraft getSpacecraft() {
        return spacecraft;
    }

    public void setSpacecraft(Spacecraft spacecraft) {
        this.spacecraft = spacecraft;
    }

    public Spaceport getArrivalPort() {
        return arrivalPort;
    }

    public void setArrivalPort(Spaceport arrivalPort) {
        this.arrivalPort = arrivalPort;
    }

    public Spaceport getDeparturePort() {
        return departurePort;
    }

    public void setDeparturePort(Spaceport departurePort) {
        this.departurePort = departurePort;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public int getPricePerTicket() {
        return pricePerTicket;
    }

    public void setPricePerTicket(int pricePerTicket) {
        this.pricePerTicket = pricePerTicket;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }
}
