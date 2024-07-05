package dev.thiagooliveira.strongpassword.core;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AtLeastNCharactersTest {

    private AtLeastNCharacters atLeastNCharacters;

    @BeforeEach
    void setUp() {
        this.atLeastNCharacters = new AtLeastNCharacters(8);
    }

    @Test
    void shouldValidateWithSuccessfully() {
        List<String> errors = this.atLeastNCharacters.validate("this-is-a-bigger-password");
        assertEquals(0, errors.size());
    }

    @Test
    void shouldValidateWithErrors() {
        List<String> errors = this.atLeastNCharacters.validate("small");
        assertEquals(1, errors.size());
        assertEquals("'password' should have at least 8 characters.", errors.get(0));
    }
}
