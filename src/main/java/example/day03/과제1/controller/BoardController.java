package example.day03.과제1.controller;


import example.day03.과제1.model.dto.BoardDto;
import example.day03.과제1.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day03/task/board")
public class BoardController {

    @Autowired private BoardService boardService;

    // 글쓰기 [POST]
    @PostMapping("")
    public boolean write( @RequestBody BoardDto boardDto ){
        System.out.println("BoardController.write");
        System.out.println("boardDto = " + boardDto);
        boolean result = boardService.write(boardDto);
        return result;
    } // f end

    // 전체 글 조회[GET]
    @GetMapping("")
    public List<BoardDto> findAll(){
        System.out.println("BoardController.findAll");
        List<BoardDto> result = boardService.findAll();
        return result;
    } // f end

    // 개별 글 조회[GET]
    @GetMapping("/view")
    public BoardDto find( @RequestParam("bno") int bno ){
        System.out.println("BoardController.find");
        System.out.println("bno = " + bno);
        BoardDto result = boardService.find( bno );
        return result;
    } // f end

    // 개별 글 수정[PUT]
    @PutMapping("")
    public boolean update( @RequestBody BoardDto boardDto ){
        boolean result = boardService.update( boardDto );
        return result;
    } // f end

    // 개별 글 삭제[DELETE]
    @DeleteMapping("")
    public boolean delete( @RequestParam("bno") int bno ){
        boolean result = boardService.delete( bno );
        return result;
    } // f end

} // c end
