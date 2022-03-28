package mytoy.onelineboard.domain.web.basic.form;

import lombok.Data;
import mytoy.onelineboard.domain.board.MemoType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class MemoUpdateForm {

    @NotNull
    private long id;

    @NotBlank
    private String username;
    @NotBlank
    private String title;
    @NotBlank
    private String text;

    private boolean agreement;
    private MemoType memoType;
    @NotBlank
    private String horseHead;
}
