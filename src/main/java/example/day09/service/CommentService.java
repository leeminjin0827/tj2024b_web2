package example.day09.service;

import example.day09.model.dto.CommentDto;
import example.day09.model.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    // 리뷰 등록
    public boolean cWrite( CommentDto commentDto ){
        System.out.println("CommentService.cWrite");
        System.out.println("commentDto = " + commentDto);
        return commentMapper.cWrite( commentDto );
    } // f end

    // 리뷰 조회
    public List<CommentDto> cList( int bno ){
        System.out.println("CommentService.cList");
        System.out.println("bno = " + bno);
        return commentMapper.cList( bno );
    } // f end

    // 리뷰 삭제
    public boolean cDelete( int cno ){
        System.out.println("CommentService.cDelete");
        System.out.println("cno = " + cno);
        return commentMapper.cDelete( cno );
    } // f end

} // c end
