package it.bz.beacon.api.exception.kontakt.io;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid api key")
public class InvalidApiKeyException extends RuntimeException {
}