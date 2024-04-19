package hello.springstart.dto;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ResponseDto {
    private String status;
    private String data;
    private String errorCode;
    private String errorMessage;

    public static ResponseDto ofSuccessWithoutData() {
        return new ResponseDto("success", null, null, null);
    }

    public static ResponseDto ofError(String errorCode, String errorMessage) {
        return new ResponseDto("error", null, errorCode, errorMessage);
    }

    private ResponseDto(String status, String data, String errorCode, String errorMessage) {
        this.status = status;
        this.data = data;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
