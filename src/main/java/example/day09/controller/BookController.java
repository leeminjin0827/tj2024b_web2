package example.day09.controller;

import example.day09.model.dto.BookDto;
import example.day09.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book0312")
@CrossOrigin("http://localhost:5173")
// http://localhost:8080/book0312
// { "bname" : "아아" , "buser" : "아아아" , "bmessage" : "라라랄" , "bpassword" : "4444" }
// { "bno" : 1 , "bname" : "아아" , "buser" : "아아아" , "bmessage" : "라라랄" , "bpassword" : "4444" }
public class BookController {

    @Autowired
    private BookService bookService;

    // 책 등록
    @PostMapping("")
    public boolean bWrite( @RequestBody BookDto bookDto ){
        System.out.println("BookController.bWrite");
        System.out.println("bookDto = " + bookDto);
        return bookService.bWrite( bookDto );
    } // f end

    // 책 전체조회
    @GetMapping("")
    public List<BookDto> bList(){
        System.out.println("BookController.bList");
        return bookService.bList();
    } // f end

    // 책 개별조회
    @GetMapping("/view")
    public BookDto bView( @RequestParam("bno") int bno ){
        System.out.println("BookController.bView");
        System.out.println("bno = " + bno);
        return bookService.bView( bno );
    } // f end

    // 책 수정
    @PutMapping("")
    public boolean bUpdate( @RequestBody BookDto bookDto ){
        System.out.println("BookController.bUpdate");
        System.out.println("bookDto = " + bookDto);
        return bookService.bUpdate( bookDto );
    } // f end

    // 책 삭제
    @DeleteMapping("")
    public boolean bDelete( @RequestParam("bno") int bno ){
        System.out.println("BookController.bDelete");
        System.out.println("bno = " + bno);
        return bookService.bDelete( bno );
    } // f end

} // c end
