package dev.thiagooliveira.strongpassword.core;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AtLeastNLettersLowerCaseTest {

    private AtLeastNLettersLowerCase atLeastNLettersLowerCase;

    @BeforeEach
    void setUp() {
        this.atLeastNLettersLowerCase = new AtLeastNLettersLowerCase(1);
    }

    @Test
    void shouldValidateWithError1() {
        List<String> errors = this.atLeastNLettersLowerCase.validate("WITHOUT-LOWERCASE");
        assertEquals(1, errors.size());
        assertEquals("'password' should have at least 1 letter(s) lowercase.", errors.get(0));
    }

    @Test
    void shouldValidateWithError2() {
        List<String> errors = this.atLeastNLettersLowerCase.validate(null);
        assertEquals(1, errors.size());
        assertEquals("'password' should have at least 1 letter(s) lowercase.", errors.get(0));
    }

    @Test
    void shouldValidateWithSuccessfully() {
        List<String> errors = this.atLeastNLettersLowerCase.validate("with-lowercase");
        assertEquals(0, errors.size());
    }
}
