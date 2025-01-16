package Learn.InterStar_Travel.Models;


import java.math.BigDecimal;
import java.time.LocalDate;

public class Booking {
    private int bookingId;
    private LocalDate bookingDate;
    private String bookingStatus;
    private int ticketNumber;
    private BigDecimal total;

    private int userId;
    private int flightId;

    public Booking(){}

    public Booking(int bookingId, LocalDate bookingDate, String bookingStatus, int ticketNumber,
                   BigDecimal total, int userId, int flightId){
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.bookingStatus = bookingStatus;
        this.ticketNumber = ticketNumber;
        this.total = total;
        this.userId = userId;
        this.flightId = flightId;
    }

    public Booking(LocalDate bookingDate, String bookingStatus, int ticketNumber,
                   BigDecimal total, int userId, int flightId){
        this.bookingDate = bookingDate;
        this.bookingStatus = bookingStatus;
        this.ticketNumber = ticketNumber;
        this.total = total;
        this.userId = userId;
        this.flightId = flightId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
}
