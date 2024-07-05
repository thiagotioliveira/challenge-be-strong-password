package dev.thiagooliveira.strongpassword;

import dev.thiagooliveira.strongpassword.core.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PasswordValidatorConfig {

    @Bean
    ValidatorChain atLeastNCharacters(@Value("${app.atLeastNCharacters.n}") int n) {
        return new AtLeastNCharacters(n);
    }

    @Bean
    ValidatorChain atLeastNLettersUpperCase(@Value("${app.atLeastNLettersUpperCase.n}") int n) {
        return new AtLeastNLettersUpperCase(n);
    }

    @Bean
    ValidatorChain atLeastNLettersLowerCase(@Value("${app.atLeastNLettersLowerCase.n}") int n) {
        return new AtLeastNLettersLowerCase(n);
    }

    @Bean
    ValidatorChain atLeastNDigits(@Value("${app.atLeastNDigits.n}") int n) {
        return new AtLeastNDigits(n);
    }

    @Bean
    ValidatorChain atLeastNSpecialCharacters(
            @Value("${app.atLeastNSpecialCharacters.n}") int n,
            @Value("${app.atLeastNSpecialCharacters.specialChars}") String specialChars) {
        Set<Character> specialCharSet = new HashSet<>();
        for (char ch : specialChars.toCharArray()) {
            specialCharSet.add(ch);
        }
        return new AtLeastNSpecialCharacters(n, specialCharSet);
    }

    @Bean
    PasswordValidator passwordValidator(List<ValidatorChain> chains) {
        return new PasswordValidator(chains);
    }
}
