package hello.springstart.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Table(name = "tb_member")
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Long id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    public static Member from(String name) {
        return new Member(name);
    }

    private Member(String name) {
        this.name = name;
    }
}
