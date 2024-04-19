package hello.springstart.controller;

import hello.springstart.dto.PagingReq;
import hello.springstart.dto.ResponseDto;
import hello.springstart.dto.TempUserReq;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TempController {
    @GetMapping("/temp/request-param")
    public ResponseDto getRequestParamWithDto(@Valid PagingReq<TempUserReq> pagingReq) {
        log.debug("pagingReq : {}", pagingReq);
        log.debug("pagingReq.criteria : {}", pagingReq.getCriteria());
        return ResponseDto.ofSuccessWithoutData();
    }

    @PostMapping("/temp/request-body")
    public ResponseDto getRequestBodyWithDto(@RequestBody @Valid PagingReq<TempUserReq> pagingReq) {
        log.debug("pagingReq : {}", pagingReq);
        log.debug("pagingReq.criteria : {}", pagingReq.getCriteria());
        return ResponseDto.ofSuccessWithoutData();
    }
}
