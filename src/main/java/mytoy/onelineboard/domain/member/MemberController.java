package mytoy.onelineboard.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/join")
    public String joinForm(@ModelAttribute("member") Member member){
        return "members/joinMemberForm";
    }

    @PostMapping("/join")
    public String save(@Valid @ModelAttribute Member member, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "members/joinMemberForm";
        }

        memberRepository.save(member);
        return "redirect:/";
    }
}
