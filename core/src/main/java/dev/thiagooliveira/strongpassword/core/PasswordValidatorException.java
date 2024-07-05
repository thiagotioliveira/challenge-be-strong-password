package dev.thiagooliveira.strongpassword.core;

import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PasswordValidatorException extends RuntimeException {

    private final List<String> errors;

    public List<String> getErrors() {
        return Collections.unmodifiableList(errors);
    }
}
