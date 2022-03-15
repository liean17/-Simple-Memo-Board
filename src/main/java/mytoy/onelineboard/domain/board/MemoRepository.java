package mytoy.onelineboard.domain.board;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoRepository {

    private static final Map<Long, Memo> store = new HashMap<>();
    private static long sequence = 0L;

    public Memo save(Memo memo){
        memo.setId(++sequence);
        store.put(memo.getId(), memo);
        return memo;
    }

    public Memo findById(Long id){
        return store.get(id);
    }

    public List<Memo> findAll(){
        return new ArrayList<>(store.values());
    }


}
