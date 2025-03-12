package example.day09.controller;

import example.day09.model.dto.BookDto;
import example.day09.model.dto.CommentDto;
import example.day09.service.BookService;
import example.day09.service.CommentService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book0312/comment")
@CrossOrigin("http://localhost:5173")
// http://localhost:8080/book0312/comment
public class CommentController {

    @Autowired
    private CommentService commentService;

    // 리뷰 등록
    @PostMapping("")
    public boolean cWrite( @RequestBody CommentDto commentDto ){
        System.out.println("CommentController.cWrite");
        System.out.println("commentDto = " + commentDto);
        return commentService.cWrite( commentDto );
    } // f end

    // 리뷰 조회
    @GetMapping("")
    public List<CommentDto> cList( @RequestParam("bno") int bno ){
        System.out.println("CommentController.cList");
        System.out.println("bno = " + bno);
        return commentService.cList( bno );
    } // f end

    // 리뷰 삭제
    @DeleteMapping("")
    public boolean cDelete( @RequestParam("cno") int cno ){
        System.out.println("CommentController.cDelete");
        System.out.println("cno = " + cno);
        return commentService.cDelete( cno );
    } // f end

} // c end
