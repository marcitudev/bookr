package com.bookr.bookr.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

    private List<FieldMessage> messageErrors = new ArrayList<>();

    public ValidationError() {
        super();
    }

    public ValidationError(Long timestamp, Integer status, String error) {
        super(timestamp, status, error);
    }

    public List<FieldMessage> getMessageErrors() {
        return messageErrors;
    }

    public void addMessageErrors(String field, String message) {
        this.messageErrors.add(new FieldMessage(field, message));
    }
}
