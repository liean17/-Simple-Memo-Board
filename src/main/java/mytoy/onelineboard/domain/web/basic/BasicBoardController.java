package mytoy.onelineboard.domain.web.basic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mytoy.onelineboard.domain.board.HorseHead;
import mytoy.onelineboard.domain.board.Memo;
import mytoy.onelineboard.domain.board.MemoType;
import mytoy.onelineboard.domain.board.MemoryMemoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/basic/memos")
@RequiredArgsConstructor
public class BasicBoardController {

    private final MemoryMemoRepository memoryMemoRepository;

    @ModelAttribute("memoTypes")
    public MemoType[] memoTypes() {
        return MemoType.values();
    }

    @ModelAttribute("horseHeads")
    public List<HorseHead> horseHeads() {
        List<HorseHead> horseHeads = new ArrayList<>();
        horseHeads.add(new HorseHead("NOTICE", "공지"));
        horseHeads.add(new HorseHead("NORMAL", "일반글"));
        horseHeads.add(new HorseHead("SECRET", "비밀글"));
        return horseHeads;
    }


    @GetMapping
    public String memos(Model model) {
        List<Memo> memos = memoryMemoRepository.findAll();
        model.addAttribute("memos", memos);
        return "basic/memos";
    }

    @GetMapping("/{memoId}")
    public String memo(@PathVariable Long memoId, Model model) {
        Memo memo = memoryMemoRepository.findById(memoId);
        model.addAttribute("memo", memo);
        return "basic/memo";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("memo",new Memo());
        return "/basic/addForm";
    }

    @PostMapping("/add")
    public String addMemo(@ModelAttribute("memo") Memo memo, Model model) {
        log.info("memo.agreement={}",memo.isAgreement());
        memoryMemoRepository.save(memo);
        model.addAttribute("memo", memo);
        return "redirect:" + memo.getId();
    }

    @GetMapping("/{memoId}/edit")
    public String editForm(@PathVariable Long memoId, Model model) {
        Memo memo = memoryMemoRepository.findById(memoId);
        model.addAttribute("memo", memo);
        return "basic/editForm";
    }

    @PostMapping("/{memoId}/edit")
    public String editMemo(@PathVariable Long memoId, @ModelAttribute Memo memo) {
        memoryMemoRepository.update(memoId, memo);
        return "redirect:/basic/memos/{memoId}";
    }

    @GetMapping("/{memoId}/delete")
    public String deleteForm(@PathVariable Long memoId, Model model) {
        Memo memo = memoryMemoRepository.findById(memoId);
        model.addAttribute("memo", memo);
        return "basic/deleteForm";
    }

    @PostMapping("/{memoId}/delete")
    public String deleteMemo(@PathVariable Long memoId) {
        memoryMemoRepository.delete(memoId);
        return "redirect:/basic/memos";
    }
}
