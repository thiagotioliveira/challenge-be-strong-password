package dev.thiagooliveira.strongpassword.core;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AtLeastNCharacters implements ValidatorChain {

    public static final String MESSAGE_ERROR_TEMPLATE = "'password' should have at least %s characters.";

    private final int n;

    @Override
    public List<String> validate(String password) {
        var errors = new ArrayList<String>();
        if (password == null || password.length() < n) {
            errors.add(String.format(MESSAGE_ERROR_TEMPLATE, n));
        }
        return errors;
    }
}
