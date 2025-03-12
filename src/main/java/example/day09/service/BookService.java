package example.day09.service;

import example.day09.model.dto.BookDto;
import example.day09.model.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;
    
    // 책 등록
    public boolean bWrite(BookDto bookDto){
        System.out.println("BookService.bWrite");
        System.out.println("bookDto = " + bookDto);
        return bookMapper.bWrite( bookDto );
    } // f end

    // 책 전체조회
    public List<BookDto> bList(){
        System.out.println("BookService.bList");
        return bookMapper.bList();
    } // f end
    
    // 책 개별조회
    public BookDto bView( int bno ){
        System.out.println("BookService.bView");
        System.out.println("bno = " + bno);
        return bookMapper.bView( bno );
    } // f end
    
    // 책 수정
    public boolean bUpdate( BookDto bookDto ){
        System.out.println("BookService.bUpdate");
        System.out.println("bookDto = " + bookDto);
        return bookMapper.bUpdate( bookDto );
    } // f end
    
    // 책 삭제
    public boolean bDelete( int bno ){
        System.out.println("BookService.bDelete");
        System.out.println("bno = " + bno);
        return bookMapper.bDelete( bno );
    } // f end
    
} // c end
