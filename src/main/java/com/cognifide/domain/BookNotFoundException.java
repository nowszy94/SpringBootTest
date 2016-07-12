package com.cognifide.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by cognifide.nowak on 11.04.2016.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Couldn't find book.")
public class BookNotFoundException extends RuntimeException {
}
