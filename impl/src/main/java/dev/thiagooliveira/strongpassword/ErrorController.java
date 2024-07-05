package dev.thiagooliveira.strongpassword;

import dev.thiagooliveira.strongpassword.core.PasswordValidatorException;
import dev.thiagooliveira.strongpassword.spec.dto.ValidatePasswordPost400Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(PasswordValidatorException.class)
    ResponseEntity<ValidatePasswordPost400Response> handlerPasswordValidatorException(PasswordValidatorException ex) {
        ValidatePasswordPost400Response body = new ValidatePasswordPost400Response();
        body.setErrors(ex.getErrors());
        return ResponseEntity.badRequest().body(body);
    }
}
