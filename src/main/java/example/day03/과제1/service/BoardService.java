package example.day03.과제1.service;


import example.day03.과제1.model.dto.BoardDto;
import example.day03.과제1.model.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired private BoardMapper boardMapper;
    
    // 글쓰기
    public boolean write(BoardDto boardDto){
        System.out.println("BoardService.write");
        System.out.println("boardDto = " + boardDto);
        return boardMapper.write( boardDto );
    } // f end

    // 전체 글 조회
    public List<BoardDto> findAll() {
        System.out.println("BoardService.findAll");
        List<BoardDto> result = boardMapper.findAll();
        return boardMapper.findAll();
    } // f end

    // 개별 글 조회
    public BoardDto find( int bno ){
        System.out.println("BoardService.find");
        System.out.println("bno = " + bno);
        return boardMapper.find( bno );
    } // f end
    
    // 개별 글 수정
    public boolean update( BoardDto boardDto ){
        System.out.println("BoardService.update");
        System.out.println("boardDto = " + boardDto);
        return boardMapper.update( boardDto );
    } // f end

    // 개별 글 삭제
    public boolean delete( int bno ) {
        System.out.println("BoardService.delete");
        System.out.println("bno = " + bno);
        return boardMapper.delete( bno );
    } // f end

} // f end
