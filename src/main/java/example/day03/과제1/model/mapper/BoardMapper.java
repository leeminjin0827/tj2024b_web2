package example.day03.과제1.model.mapper;

import example.day03.과제1.model.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    // 글쓰기 SQL 매퍼
    boolean write(BoardDto boardDto);

    // 전체 글 조회 SQL 매퍼
    List<BoardDto> findAll();

    // 개별 글 조회 SQL 매퍼
    BoardDto find( int bno );

    // 개별 글 수정 SQL 매퍼
    boolean update( BoardDto boardDto );

    // 개별 글 삭제 SQL 매퍼
    boolean delete ( int bno );

} // c end
