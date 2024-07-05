package dev.thiagooliveira.strongpassword.core;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PasswordValidatorTest {
    private PasswordValidator passwordValidator;

    @BeforeEach
    void setUp() {
        this.passwordValidator = new PasswordValidator(List.of(
                new AtLeastNCharacters(8),
                new AtLeastNLettersUpperCase(1),
                new AtLeastNLettersLowerCase(1),
                new AtLeastNDigits(1),
                new AtLeastNSpecialCharacters(1, Set.of('$'))));
    }

    @Test
    void shouldValidateWithSuccessfully() {
        this.passwordValidator.validate("aBcd3fg$");
        assertTrue(true);
    }

    @Test
    void shouldValidateWithError1() {
        PasswordValidatorException exception =
                assertThrows(PasswordValidatorException.class, () -> this.passwordValidator.validate(null));
        assertEquals(5, exception.getErrors().size());
    }

    @Test
    void shouldValidateWithError2() {
        PasswordValidatorException exception =
                assertThrows(PasswordValidatorException.class, () -> this.passwordValidator.validate(""));
        assertEquals(5, exception.getErrors().size());
    }

    @Test
    void shouldValidateWithError3() {
        PasswordValidatorException exception =
                assertThrows(PasswordValidatorException.class, () -> this.passwordValidator.validate("abcD3fgh"));
        assertEquals(1, exception.getErrors().size());
    }

    @Test
    void shouldValidateWithError4() {
        PasswordValidatorException exception =
                assertThrows(PasswordValidatorException.class, () -> this.passwordValidator.validate("abcdefgh"));
        assertEquals(3, exception.getErrors().size());
    }

    @Test
    void shouldValidateWithError5() {
        PasswordValidatorException exception =
                assertThrows(PasswordValidatorException.class, () -> this.passwordValidator.validate("aBcdefg$"));
        assertEquals(1, exception.getErrors().size());
    }
}
