package mytoy.onelineboard.domain.board;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemoRepositoryTest {

    MemoryMemoRepository memoryMemoRepository = new MemoryMemoRepository();

    @AfterEach
    void afterEach(){
        memoryMemoRepository.clearStore();
    }

    @Test
    void save(){
        //given
        Memo memo = new Memo("ㅇㅇ","1빠","ㅈㄱㄴ");
        //when
        Memo savedMemo = memoryMemoRepository.save(memo);
        //then
        Memo findMemo = memoryMemoRepository.findById(memo.getId());
        assertThat(findMemo).isEqualTo(savedMemo);
    }

    @Test
    void findAll(){
        //given
        Memo memo1 = new Memo("ㅇㅇ","1빠","ㅈㄱㄴ");
        Memo memo2 = new Memo("ㅇㅇ","2빠","ㄲㅂ");

        memoryMemoRepository.save(memo1);
        memoryMemoRepository.save(memo2);
        //when
        List<Memo> result = memoryMemoRepository.findAll();
        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(memo1,memo2);
    }

    @Test
    void updateMemo(){
        //given
        Memo memo = new Memo("ㅇㅇ","먼데","무냐고");
        Memo savedMemo = memoryMemoRepository.save(memo);
        Long findId = savedMemo.getId();
        //when
        Memo upMemo = new Memo("ㄴㄴ","아 그런건가","그거네");
        memoryMemoRepository.update(findId,upMemo);
        Memo findMemo = memoryMemoRepository.findById(findId);
        //then
        assertThat(findMemo.getText()).isEqualTo(upMemo.getText());
    }

}