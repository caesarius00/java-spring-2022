package pl.edu.ug.ckwella.Lab04.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Could not find vestment")
public class VestmentNotFoundException extends RuntimeException {
}
