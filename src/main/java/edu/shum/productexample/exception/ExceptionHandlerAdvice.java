package edu.shum.productexample.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.shum.productexample.model.ErrorDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
@Slf4j
public class ExceptionHandlerAdvice {

    private final ObjectMapper om;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public ErrorDto validationException(ValidationException exception) {
        return new ErrorDto(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ErrorDto throwable(Throwable exception) {
        log.error("unhandled error: ", exception);
        return new ErrorDto(exception.getMessage());
    }
}
