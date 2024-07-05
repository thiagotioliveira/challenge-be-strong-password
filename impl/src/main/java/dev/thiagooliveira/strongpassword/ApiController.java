package dev.thiagooliveira.strongpassword;

import dev.thiagooliveira.strongpassword.core.PasswordValidator;
import dev.thiagooliveira.strongpassword.spec.api.DefaultApi;
import dev.thiagooliveira.strongpassword.spec.dto.ValidatePasswordPostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ApiController implements DefaultApi {

    private final PasswordValidator passwordValidator;

    @Override
    public ResponseEntity<Void> validatePasswordPost(ValidatePasswordPostRequest validatePasswordPostRequest) {
        passwordValidator.validate(validatePasswordPostRequest.getPassword());
        return ResponseEntity.noContent().build();
    }
}
