package hello.springstart.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class PagingReq<T> {
    @NotNull @PositiveOrZero private int pageSize;

    @NotNull @PositiveOrZero private int pageNumber;

    private T criteria;
}
