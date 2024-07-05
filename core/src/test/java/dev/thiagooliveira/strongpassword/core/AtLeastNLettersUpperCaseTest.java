package dev.thiagooliveira.strongpassword.core;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AtLeastNLettersUpperCaseTest {

    private AtLeastNLettersUpperCase atLeastNLettersUpperCase;

    @BeforeEach
    void setUp() {
        this.atLeastNLettersUpperCase = new AtLeastNLettersUpperCase(1);
    }

    @Test
    void shouldValidateWithError1() {
        List<String> errors = this.atLeastNLettersUpperCase.validate("without-uppercase");
        assertEquals(1, errors.size());
        assertEquals("'password' should have at least 1 letter(s) uppercase.", errors.get(0));
    }

    @Test
    void shouldValidateWithError2() {
        List<String> errors = this.atLeastNLettersUpperCase.validate(null);
        assertEquals(1, errors.size());
        assertEquals("'password' should have at least 1 letter(s) uppercase.", errors.get(0));
    }

    @Test
    void shouldValidateWithSuccessfully() {
        List<String> errors = this.atLeastNLettersUpperCase.validate("with-Uppercase");
        assertEquals(0, errors.size());
    }
}
