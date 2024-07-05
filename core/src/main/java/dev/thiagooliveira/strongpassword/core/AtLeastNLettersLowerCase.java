package dev.thiagooliveira.strongpassword.core;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AtLeastNLettersLowerCase implements ValidatorChain {

    public static final String MESSAGE_ERROR_TEMPLATE = "'password' should have at least %s letter(s) lowercase.";

    private final int n;

    @Override
    public List<String> validate(String password) {
        var errors = new ArrayList<String>();
        if (password == null) {
            errors.add(String.format(MESSAGE_ERROR_TEMPLATE, n));
        } else {
            int count = 0;
            for (int i = 0; i < password.length(); i++) {
                char c = password.charAt(i);
                if (Character.isLowerCase(c)) {
                    count++;
                }
            }
            if (count < n) {
                errors.add(String.format(MESSAGE_ERROR_TEMPLATE, n));
            }
        }
        return errors;
    }
}
