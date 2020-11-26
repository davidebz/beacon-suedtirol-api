package it.bz.beacon.api.exception.auth;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "The given password is wrong")
public class InvalidPasswordException extends RuntimeException {
    private static final long serialVersionUID = -4855642782766246720L;
}