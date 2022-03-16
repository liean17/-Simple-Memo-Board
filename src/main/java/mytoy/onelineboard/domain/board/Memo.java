package mytoy.onelineboard.domain.board;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Memo {

    private long id;
    private String username;
    private String title;
    private String text;

    public Memo() {
    }

    public Memo(String username, String title, String text) {
        this.username = username;
        this.title = title;
        this.text = text;
    }
}
