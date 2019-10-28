package dev.sandbox.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SimpleExceptionService {
    public String getTestData(String parameter) {
        if (parameter.length() > 2) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Parameter length can't be more than 2");
        }
        return null;
    }
}
