package com.example.demo.handler;

import com.example.demo.execption.ClientNotFoundException;
import com.example.demo.execption.InvalidRequestException;
import com.example.demo.ro.FieldErrorRO;
import com.example.demo.ro.InvalidRequestRO;
import com.example.demo.ro.MsgRO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({ClientNotFoundException.class})
    private ResponseEntity<?> handleNotFoundException(ClientNotFoundException e) {
        return new ResponseEntity<>(new MsgRO(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({InvalidRequestException.class})
    private ResponseEntity<?> handleInvalidRequestException(InvalidRequestException e) {
        Errors errors = e.getErrors();

        List<FieldErrorRO> feros = new ArrayList<>();
        for (FieldError FieldError : errors.getFieldErrors()) {
            FieldErrorRO fero = new FieldErrorRO();
            fero.setField(FieldError.getField());
            fero.setCode(FieldError.getCode());
            fero.setMessage(FieldError.getDefaultMessage());
            fero.setClassName(FieldError.getObjectName());
            feros.add(fero);
        }

        return new ResponseEntity<>(new InvalidRequestRO(e.getMessage(), feros), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class})
    private ResponseEntity<?> handleException(Exception e) {
        return new ResponseEntity<>(new MsgRO(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
