package com.example.demo.handler;

import com.example.demo.execption.ClientNotFoundException;
import com.example.demo.execption.InvalidRequestException;
import com.example.demo.ro.FieldErrorRO;
import com.example.demo.ro.InvalidRequestRO;
import com.example.demo.ro.MsgRO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApiExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(ApiExceptionHandler.class);

    /**
     * 處理ClientNotFoundException
     *
     * @param e
     * @return ResponseEntity<MsgRO>
     */
    @ExceptionHandler({ClientNotFoundException.class})
    private ResponseEntity<?> handleNotFoundException(ClientNotFoundException e) {
        logger.warn("***** error: ", e.getMessage());
        ResponseEntity result = new ResponseEntity<>(new MsgRO(e.getMessage()), HttpStatus.NOT_FOUND);
        logger.warn("***** return: {}", result);
        return result;
    }

    /**
     * 處理InvalidRequestException
     *
     * @param e String
     * @return ResponseEntity<InvalidRequestRO>
     */
    @ExceptionHandler({InvalidRequestException.class})
    private ResponseEntity<?> handleInvalidRequestException(InvalidRequestException e) {
        logger.warn("***** error: {}", e.getMessage());
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

        InvalidRequestRO iro = new InvalidRequestRO(e.getMessage(), feros);
        ResponseEntity<?> result = new ResponseEntity<>(iro, HttpStatus.BAD_REQUEST);

        String msg = feros.stream().map(fero -> fero.toString()).collect(Collectors.joining(","));
        logger.warn("***** return: {}|{}", HttpStatus.BAD_REQUEST, msg);

        return result;
    }

    /**
     * 處理所有的Exception
     *
     * @param e
     * @return
     */
    @ExceptionHandler({Exception.class})
    private ResponseEntity<?> handleException(Exception e) {
        logger.error("***** error: ", e);
        return new ResponseEntity<>(new MsgRO(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
