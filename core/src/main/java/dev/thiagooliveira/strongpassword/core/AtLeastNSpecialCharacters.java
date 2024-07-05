package dev.thiagooliveira.strongpassword.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AtLeastNSpecialCharacters implements ValidatorChain {

    public static final String MESSAGE_ERROR_TEMPLATE = "'password' should have at least %s special chars among %s.";

    private final int n;

    private final Set<Character> specialChars;

    @Override
    public List<String> validate(String password) {
        var errors = new ArrayList<String>();
        if (password == null) {
            errors.add(String.format(MESSAGE_ERROR_TEMPLATE, n, format(specialChars)));
        } else {
            int count = 0;
            for (int i = 0; i < password.length(); i++) {
                char c = password.charAt(i);
                if (specialChars.contains(c)) {
                    count++;
                }
            }
            if (count < n) {
                errors.add(String.format(MESSAGE_ERROR_TEMPLATE, n, format(specialChars)));
            }
        }
        return errors;
    }

    private static String format(Set<Character> chars) {
        return String.format("(%s)", chars.stream().map(Object::toString).collect(Collectors.joining()));
    }
}
