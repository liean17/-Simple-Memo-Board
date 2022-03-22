package mytoy.onelineboard.domain.board;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * PIG : 돼지머리
 * COW : 소머리
 * HORSE : 말머리
 * ELEPHANT : 코끼리머리
 */
@Data
@AllArgsConstructor
public class HorseHead {
    private String code;
    private String displayName;
}
