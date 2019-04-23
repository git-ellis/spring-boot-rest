package com.example.demo.ro;

public class FieldErrorRO {
    private String field;
    private String message;
    private String code;
    private String className;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "FieldErrorRO{" +
                "field='" + field + '\'' +
                ", message='" + message + '\'' +
                ", code='" + code + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
