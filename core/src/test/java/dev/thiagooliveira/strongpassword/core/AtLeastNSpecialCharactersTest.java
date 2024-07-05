package dev.thiagooliveira.strongpassword.core;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AtLeastNSpecialCharactersTest {

    private AtLeastNSpecialCharacters atLeastNSpecialCharacters;

    @BeforeEach
    void setUp() {
        this.atLeastNSpecialCharacters = new AtLeastNSpecialCharacters(1, Set.of('!', '@', '#', '$', '%'));
    }

    @Test
    void shouldValidateWithError1() {
        List<String> errors = this.atLeastNSpecialCharacters.validate("without-specialchars");
        assertEquals(1, errors.size());
        assertEquals("'password' should have at least 1 special chars among (!@#$%).", errors.get(0));
    }

    @Test
    void shouldValidateWithError2() {
        List<String> errors = this.atLeastNSpecialCharacters.validate(null);
        assertEquals(1, errors.size());
        assertEquals("'password' should have at least 1 special chars among (!@#$%).", errors.get(0));
    }

    @Test
    void shouldValidateWithSuccessfully() {
        List<String> errors = this.atLeastNSpecialCharacters.validate("with-#");
        assertEquals(0, errors.size());
    }
}
