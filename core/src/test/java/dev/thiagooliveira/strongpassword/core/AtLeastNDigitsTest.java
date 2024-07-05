package dev.thiagooliveira.strongpassword.core;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AtLeastNDigitsTest {

    private AtLeastNDigits atLeastNDigits;

    @BeforeEach
    void setUp() {
        this.atLeastNDigits = new AtLeastNDigits(1);
    }

    @Test
    void shouldValidateWithError1() {
        List<String> errors = this.atLeastNDigits.validate("without-digits");
        assertEquals(1, errors.size());
        assertEquals("'password' should have at least 1 digit(s).", errors.get(0));
    }

    @Test
    void shouldValidateWithError2() {
        List<String> errors = this.atLeastNDigits.validate(null);
        assertEquals(1, errors.size());
        assertEquals("'password' should have at least 1 digit(s).", errors.get(0));
    }

    @Test
    void shouldValidateWithSuccessfully() {
        List<String> errors = this.atLeastNDigits.validate("password1");
        assertEquals(0, errors.size());
    }
}
