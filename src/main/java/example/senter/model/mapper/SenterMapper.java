package example.senter.model.mapper;

import example.senter.model.dto.SenterDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SenterMapper {

    // 문의등록 SQL
    @Insert( " insert into senter( stitle , scontent , spassword , suser ) values( #{stitle} , #{scontent} , #{spassword} , #{suser} ) " )
    boolean sWrite( SenterDto senterDto );

    // 문의전체조회 SQL
    @Select( " select sno , stitle , scontent , suser from senter " )
    List<SenterDto> sFindAll();
} // i end
