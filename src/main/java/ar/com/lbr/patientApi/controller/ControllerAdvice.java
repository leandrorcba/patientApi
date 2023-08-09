package ar.com.lbr.patientApi.controller;

import ar.com.lbr.patientApi.exceptions.ClientNotFoundException;
import ar.com.lbr.patientApi.model.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = ClientNotFoundException.class)
    public ResponseEntity<ErrorDto> clientNotFountExceptionHandler(ClientNotFoundException ex){
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
