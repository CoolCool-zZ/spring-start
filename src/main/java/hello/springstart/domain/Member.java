package hello.springstart.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Member {
    @Setter private Long id;
    private String name;

    public static Member from(String name) {
        return new Member(name);
    }

    private Member(String name) {
        this.name = name;
    }
}
