package example.day09.model.mapper;

import example.day09.model.dto.BookDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {

    // 책 등록
    @Insert("insert into books( bname , buser , bmessage , bpassword )values( #{bname} , #{buser} , #{bmessage} , #{bpassword} )")
    public boolean bWrite( BookDto bookDto );

    // 책 전체조회
    @Select("select * from books")
    public List<BookDto> bList();

    // 책 개별조회
    @Select("select * from books where bno = #{bno}")
    public BookDto bView( int bno );

    // 책 수정
    @Update("update books set bname = #{bname} , buser = #{buser} , bmessage = #{bmessage} where bno = #{bno}")
    public boolean bUpdate( BookDto bookDto );

    // 책 삭제
    @Delete("delete from books where bno = #{bno}")
    public boolean bDelete( int bno );

} // c end
