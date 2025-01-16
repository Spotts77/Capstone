package Learn.InterStar_Travel.controller;

import Learn.InterStar_Travel.Models.Booking;
import Learn.InterStar_Travel.domain.BookingService;
import Learn.InterStar_Travel.domain.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service){this.service = service;}


    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> findBookingById(@PathVariable int bookingId){
        Booking booking = service.findBookingById(bookingId);
        if(booking == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(booking);
    }

    @PostMapping("/make/booking")
    public ResponseEntity<Object> createBooking(@RequestBody Booking booking){
        Result<Booking> result = service.createBooking(booking);
        if(result.isSuccess()){
            return new ResponseEntity<>(result.getPayload(), HttpStatus.CREATED);
        }
        return ErrorResponse.build(result);
    }
}
