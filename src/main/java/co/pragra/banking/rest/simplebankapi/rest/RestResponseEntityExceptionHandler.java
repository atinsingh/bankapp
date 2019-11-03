package co.pragra.banking.rest.simplebankapi.rest;

import co.pragra.banking.rest.simplebankapi.domain.ExceptionResponse;
import co.pragra.banking.rest.simplebankapi.exceptions.InsufficientBalanceException;
import co.pragra.banking.rest.simplebankapi.exceptions.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<ExceptionResponse> notfound(NotFoundException ex){
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), ex.getMessage(),
                        "Not Found");

        return new ResponseEntity<ExceptionResponse>
                (exceptionResponse, new HttpHeaders(),
                        HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    public final ResponseEntity<ExceptionResponse> noBalance(InsufficientBalanceException ex){
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), ex.getMessage(),
                        "Not a enough balance");

        return new ResponseEntity<ExceptionResponse>
                (exceptionResponse, new HttpHeaders(),
                        HttpStatus.FORBIDDEN);
    }
}
