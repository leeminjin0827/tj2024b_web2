package example.day03.mvc2_mybatis.model.mapper;

import example.day03.mvc2_mybatis.model.dto.MyDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyMapper {

    // [1] 등록 SQL 매퍼
    int save (MyDto myDto); // 추상메소드 매핑 구현
    // [2] 전제조회 SQL 처리하는 XML 매퍼
    List<MyDto> findall();
    // [3] 개별조회 SQL 처리하는 XML 매퍼
    MyDto find( int id );
    // [4] 개별수정 SQL 처리하는 XML 매퍼
    int update( MyDto myDto );
    // [5] 개별삭제 SQL 처리하는 XML 매퍼
    int delete( int id );

} // i end
