package hello.springstart.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@Slf4j
@ControllerAdvice
public class BindingControllerAdvice {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        log.info("webBinder : {}", binder);

        binder.initDirectFieldAccess();
    }
}
