package Learn.InterStar_Travel.controller;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

    @ControllerAdvice
    public class GlobalerrHandling {
        @ExceptionHandler(HttpMessageConversionException.class)
        public ResponseEntity<String> handleHttpMessageConversionException(HttpMessageConversionException ex) {
            // log exception
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(TypeMismatchException.class)
        public ResponseEntity<String> handleTypeMismatchException(TypeMismatchException ex) {
            // log exception
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
        public ResponseEntity<String> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
            // log exception
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<String> handleException(Exception ex) {
            // log exception
            return new ResponseEntity<String>("Something went wrong on our end :(", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
