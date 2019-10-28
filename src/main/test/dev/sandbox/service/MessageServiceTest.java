package dev.sandbox.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;

import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class MessageServiceTest {

    @Mock
    private MessageSource messageSource;

    @InjectMocks
    private MessageService underTest;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getValueInCurrentLanguage() {
        // GIVEN
        when(messageSource.getMessage(anyString(), any(), any(Locale.class))).thenReturn("Test message");

        // WHEN
        String actual = underTest.getValueInCurrentLanguage("test.message");

        // THEN
        assertEquals("Test message", actual);
    }

}
