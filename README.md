# Secure Password

Your challenge is to implement a service that validates if a password is considered secure based on predefined criteria.

## Example

Your service receives a request to validate a password.

[POST] `{{host}}/validate-password`
```json
{
    "password": "vYQIYxO&p$yfI^r"
}
```
If the password meets all security criteria, your service should return a success response:

```plaintext
HTTP/1.1 204 No Content
```

Otherwise, return a message indicating which criteria were not met. You can choose the structure for error messages:

```json
HTTP/1.1 400 Bad Request
{
    ...
}
```

# Requirements

* The password must be at least 8 characters long.
* It must contain at least one uppercase letter.
* It must contain at least one lowercase letter.
* It must contain at least one numeric digit.
* It must contain at least one special character (e.g., !@#$%).

---

# Dependencies
* Java 21
* Spring Boot 3.3.1
* Maven 3.6.3
* Docker

# Env Vars

Below is the list of environment variables corresponding to the properties (optional):

```cmd
APP_AT_LEAST_N_CHARACTERS_N=8
APP_AT_LEAST_N_LETTERS_UPPER_CASE_N=1
APP_AT_LEAST_N_LETTERS_LOWER_CASE_N=1
APP_AT_LEAST_N_DIGITS_N=1
APP_AT_LEAST_N_SPECIAL_CHARACTERS_N=1
APP_AT_LEAST_N_SPECIAL_CHARACTERS_SPECIAL_CHARS="!@#$%"

```