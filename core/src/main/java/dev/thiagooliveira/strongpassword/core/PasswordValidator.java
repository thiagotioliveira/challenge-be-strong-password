package dev.thiagooliveira.strongpassword.core;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PasswordValidator {

    private final List<ValidatorChain> chains;

    public void validate(String password) {
        List<String> errors = this.chains.stream()
                .map(c -> c.validate(password))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        if (!errors.isEmpty()) {
            throw new PasswordValidatorException(errors);
        }
    }
}
