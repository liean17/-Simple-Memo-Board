package mytoy.onelineboard.domain.web.basic;

import lombok.RequiredArgsConstructor;
import mytoy.onelineboard.domain.board.Memo;
import mytoy.onelineboard.domain.board.MemoryMemoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/basic/memos")
@RequiredArgsConstructor
public class BasicBoardController {

    private final MemoryMemoRepository memoryMemoRepository;

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
    public String addForm() {
        return "/basic/addForm";
    }

    @PostMapping("/add")
    public String addMemoV2(@ModelAttribute("memo") Memo memo, Model model) {
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
    @GetMapping("/delete")
    public String deleteForm(@PathVariable Long memoId) {
        memoryMemoRepository.delete(memoId);
        return "redirect:/basic/memos";
    }
}
