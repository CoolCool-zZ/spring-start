package hello.springstart.controller;

import hello.springstart.domain.Member;
import hello.springstart.service.MemberService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class MemberController {
    private final MemberService memberService;

    @GetMapping("member/new")
    public String createForm() {
        return "member/createMemberForm";
    }

    @PostMapping("member")
    public String createMember(MemberForm form) {
        Member member = Member.from(form.getName());
        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("member/list")
    public String retrieveMemberList(Model model) {
        List<Member> memberList = memberService.findMembers();
        model.addAttribute("memberList", memberList);

        return "member/memberList";
    }
}
