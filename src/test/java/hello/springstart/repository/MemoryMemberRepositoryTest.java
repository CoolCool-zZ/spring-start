package hello.springstart.repository;

import static org.assertj.core.api.Assertions.assertThat;

import hello.springstart.domain.Member;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = Member.from("spring");

        Member result = repository.save(member);

        Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = Member.from("spring1");
        repository.save(member1);

        Member member2 = Member.from("sprint2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(member1).isEqualTo(result);
    }

    @Test
    public void findAll() {
        Member member1 = Member.from("spring1");
        repository.save(member1);

        Member member2 = Member.from("spring2");
        repository.save(member2);

        Member member3 = Member.from("spring3");
        repository.save(member3);

        List<Member> memberList = repository.findAll();

        assertThat(memberList.size()).isEqualTo(3);
    }
}
