package hello.springstart.service;

import hello.springstart.domain.Member;
import hello.springstart.repository.MemberRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member) {
        validateDuplicatedMemberByName(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicatedMemberByName(Member member) {
        memberRepository
                .findByName(member.getName())
                .ifPresent(
                        m -> {
                            throw new IllegalStateException("이미 존재하는 이름입니다.");
                        });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
