package example.day06._aop과제.model.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    // 등록
    @Insert( " insert into student ( name , kor , math ) values( #{ name } , #{ kor } , #{ math } ) " )
    boolean save(HashMap< String , Object > map );

    // 전체조회
    @Select( " select * from student")
    List<Map <String , Object > > listAll();
} // f end
