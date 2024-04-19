package hello.springstart.exception;

import hello.springstart.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseDto handleException(Exception e) {
        log.error(e.getLocalizedMessage());

        return ResponseDto.ofError("exception", "e.getLocalizedMessage()");
    }
}
