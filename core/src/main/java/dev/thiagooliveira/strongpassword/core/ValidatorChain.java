package dev.thiagooliveira.strongpassword.core;

import java.util.List;

public interface ValidatorChain {

    List<String> validate(String password);
}
