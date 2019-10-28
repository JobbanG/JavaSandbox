package dev.sandbox.controller;

import dev.sandbox.service.SimpleExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "simple")
public class SimpleExceptionController {

    private final SimpleExceptionService simpleExceptionService;

    @Autowired
    public SimpleExceptionController(SimpleExceptionService simpleExceptionService) {
        this.simpleExceptionService = simpleExceptionService;
    }

    @GetMapping(produces = "application/json")
    public String getTestData(@RequestParam String parameter) {
        return simpleExceptionService.getTestData(parameter);
    }

}
