package example.day09.model.mapper;

import example.day09.model.dto.CommentDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {

    // 리뷰 등록
    @Insert("insert into comment( cmessage , cpassword , bno )values( #{cmessage} , #{cpassword} , #{bno} ) ")
    public boolean cWrite( CommentDto commentDto );

    // 리뷰 조회
    @Select("select b.bno , b.bname , b.buser , b.bmessage , b.bpassword , c.cno , c.cmessage , c.cpassword from" +
            " books as b inner join comment as c on b.bno = c.cno where c.bno = #{bno}")
    public List<CommentDto> cList( int bno );

    // 리뷰 삭제
    @Delete("delete from comment where cno = #{cno}")
    public boolean cDelete( int cno );


} // i end
