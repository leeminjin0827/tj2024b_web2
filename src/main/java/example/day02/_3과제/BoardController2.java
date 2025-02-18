package example.day02._3과제;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day02/task2")
public class BoardController2 {


    @Autowired // 싱글톤 호출 대신에 .getInstance() 대용
    BoardDao boardDao;
    public BoardController2( BoardDao boardDao ){
        this.boardDao = boardDao;
    }

    // 글쓰기
    @PostMapping("/board")
    public boolean bPost( @RequestBody BoardDto boardDto ){ // 매개변수 Dto
        boolean result = boardDao.bPost( boardDto );
        return result;
    } // f end

    // 전체 글 조회
    @GetMapping("/board")
    public List<BoardDto> bGet1(){
        List<BoardDto> result = boardDao.bGet1();
        return result;
    } // f end

    // 개별 글 조회
    @GetMapping("/board/view")
    public BoardDto bGet2( @RequestParam( name = "bno") int bno ){
        BoardDto result = boardDao.bGet2( bno );
        return result;
    } // f end

    // 개별 글 수정
    @PutMapping("/board")
    public boolean bPut(  @RequestBody BoardDto boardDto ){
        boolean result = boardDao.bPut( boardDto );
        return result;
    } // f end

    // 개별 글 삭제
    @DeleteMapping("/board")
    public boolean bDelete( @RequestParam( name = "bno" ) int bno ){
        boolean result = boardDao.bDelete( bno );
        return result;
    } // f end

} // c end
