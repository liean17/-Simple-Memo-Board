package mytoy.onelineboard;

import lombok.RequiredArgsConstructor;
import mytoy.onelineboard.domain.board.Memo;
import mytoy.onelineboard.domain.member.Member;
import mytoy.onelineboard.domain.member.MemberRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDataInit {
    private final MemberRepository itemRepository;
    private final MemberRepository memberRepository;
    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        Member member = new Member();
        member.setLoginId("test");
        member.setPassword("test!");
        member.setUsername("테스터");
        memberRepository.save(member);
    }
}

