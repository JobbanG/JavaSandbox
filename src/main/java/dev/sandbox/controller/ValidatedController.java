package dev.sandbox.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@RestController
@Validated
@RequestMapping(value = "validated")
public class ValidatedController {

    @GetMapping(produces = "application/json")
    public String getTestData(
            @RequestParam @Size(max = 2, message = "length can't be more than 2!") String firstParameter,
            @RequestParam @Min(value = 1, message = "value can't be less than 1!")
                          @Max(value = 3, message = "value can't be more than 3!") int secondParameter,
            @RequestParam @Pattern(regexp = "^[A-Z]{5}$", message = "must consist of 5 capital letters!")
                    String thirdParameter) {
        return null;
    }

}
