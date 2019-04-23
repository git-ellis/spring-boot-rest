package com.example.demo.ro;

import java.util.List;

public class InvalidRequestRO {
    private String message;
    private List<FieldErrorRO> fieldErrorRO;

    public InvalidRequestRO(String message, List<FieldErrorRO> fieldErrorRO) {
        this.message = message;
        this.fieldErrorRO = fieldErrorRO;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<FieldErrorRO> getFieldErrorRO() {
        return fieldErrorRO;
    }

    public void setFieldErrorRO(List<FieldErrorRO> fieldErrorRO) {
        this.fieldErrorRO = fieldErrorRO;
    }
}
