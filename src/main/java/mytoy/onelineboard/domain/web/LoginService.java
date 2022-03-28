package mytoy.onelineboard.domain.web;

import lombok.RequiredArgsConstructor;
import mytoy.onelineboard.domain.member.Member;
import mytoy.onelineboard.domain.member.MemberRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login(String loginId, String password){
        return memberRepository.findByLoginId(loginId)
                .filter(member -> member.getPassword().equals(password))
                .orElse(null);
    }
}
