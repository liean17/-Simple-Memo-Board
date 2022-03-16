package mytoy.onelineboard.domain.web.basic;

import lombok.RequiredArgsConstructor;
import mytoy.onelineboard.domain.board.Memo;
import mytoy.onelineboard.domain.board.MemoryMemoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/basic/memos")
@RequiredArgsConstructor
public class BasicBoardController {

    private final MemoryMemoRepository memoryMemoRepository;

    @GetMapping
    public String memos(Model model){
        List<Memo> memos = memoryMemoRepository.findAll();
        model.addAttribute("memos",memos);
        return "basic/memos";
    }


    /**
     * 테스트용
     */

    @PostConstruct
    public void init(){
        memoryMemoRepository.save(new Memo("김두한","나 김두한이다","방금피자시켰다."));
        memoryMemoRepository.save(new Memo("하야시","난다고래","방금치킨시켰다."));

    }
}
