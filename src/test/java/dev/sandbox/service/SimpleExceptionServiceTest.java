package dev.sandbox.service;

import org.junit.Test;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.Assert.assertNull;

public class SimpleExceptionServiceTest {

    private SimpleExceptionService underTest = new SimpleExceptionService();

    @Test
    public void getTestDataReturnsWithNull() {
        assertNull(underTest.getTestData("ab"));
    }

    @Test(expected = ResponseStatusException.class)
    public void getTestDataThrowsException() {
        underTest.getTestData("abc");
    }

}
