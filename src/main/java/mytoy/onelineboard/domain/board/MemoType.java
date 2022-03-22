package mytoy.onelineboard.domain.board;

public enum MemoType {

    CHAT("잡담"), INFO("정보"), FILE("자료"), ETC("기타");

    private final String description;

    MemoType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
