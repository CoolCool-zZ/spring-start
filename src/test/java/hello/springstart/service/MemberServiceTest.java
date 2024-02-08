package hello.springstart.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import hello.springstart.domain.Member;
import hello.springstart.repository.MemberMemoryRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {
    private MemberService memberService;
    private MemberMemoryRepository memberRepository;

    @BeforeEach
    void beforeEach() {
        memberRepository = new MemberMemoryRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void join() {
        // given
        Member member = Member.from("hello");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(findMember.getName()).isEqualTo(member.getName());
    }

    @Test
    void joinWhenDuplicatedName() {
        // given
        Member member = Member.from("spring");
        Member duplicatedMember = Member.from("spring");

        // when
        memberService.join(member);
        IllegalStateException e =
                assertThrows(
                        IllegalStateException.class, () -> memberService.join(duplicatedMember));

        // then
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름입니다.");
    }

    @Test
    void findMembers() {}

    @Test
    void findOne() {}
}
