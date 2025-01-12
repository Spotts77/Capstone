package Learn.InterStar_Travel.Models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Flight {
    private int flightId;
    private String flightName;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private BigDecimal pricePerTicket;
    private LocalDate departureDate;

    private int departurePortId;
    private int arrivalPortId;

    private int spacecraftId;

    public Flight(){}

    public Flight(int flightId, String flightName, LocalTime departureTime, LocalTime arrivalTime,
                  BigDecimal pricePerTicket, LocalDate departureDate, int departurePortId, int arrivalPortId,
                  int spacecraftId){
        this.flightId = flightId;
        this.flightName = flightName;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.pricePerTicket = pricePerTicket;
        this.departureDate = departureDate;
        this.departurePortId = departurePortId;
        this.arrivalPortId = arrivalPortId;
    }

    public int getSpacecraftId() {
        return spacecraftId;
    }

    public void setSpacecraftId(int spacecraftId) {
        this.spacecraftId = spacecraftId;
    }

    public int getArrivalPortId() {
        return arrivalPortId;
    }

    public void setArrivalPortId(int arrivalPortId) {
        this.arrivalPortId = arrivalPortId;
    }

    public int getDeparturePortId() {
        return departurePortId;
    }

    public void setDeparturePortId(int departurePortId) {
        this.departurePortId = departurePortId;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public BigDecimal getPricePerTicket() {
        return pricePerTicket;
    }

    public void setPricePerTicket(BigDecimal pricePerTicket) {
        this.pricePerTicket = pricePerTicket;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
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
