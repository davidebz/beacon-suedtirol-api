package it.bz.beacon.api.exception.kontakt.io;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "No device added")
public class NoDeviceAddedException extends RuntimeException {
}
