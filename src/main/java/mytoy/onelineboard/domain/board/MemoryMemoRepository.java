package mytoy.onelineboard.domain.board;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryMemoRepository {
    //해시맵 임시 저장소
    private static final Map<Long, Memo> store = new HashMap<>();
    //id 자동증가
    private static long sequence = 0L;

    //메모저장, id를 1 증가시키고 memo와 함께 임시저장소에 저장 그리고 해당 메모 반환
    public Memo save(Memo memo){
        memo.setId(++sequence);
        store.put(memo.getId(), memo);
        return memo;
    }
    //id로 memo조회
    public Memo findById(Long id){
        return store.get(id);
    }
    //메모 조회 - 메인화면
    public List<Memo> findAll(){
        return new ArrayList<>(store.values());
    }
    public void update(Long memoId, Memo updateParam){
        Memo findMemo = findById(memoId);
        findMemo.setUsername(updateParam.getUsername());
        findMemo.setTitle(updateParam.getTitle());
        findMemo.setText(updateParam.getText());
    }
    public void clearStore(){
        store.clear();
    }

    public void delete(Long memoId){
        store.remove(memoId);
    }


}
