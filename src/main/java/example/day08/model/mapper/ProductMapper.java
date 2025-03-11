package example.day08.model.mapper;

import example.day08.model.dto.ProductDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {

    // [1] 제품등록
    @Insert("insert into productsample( name , price , comment ) values ( #{name} , #{price} , #{comment} )")
    public boolean onWrite( ProductDto productDto );

    // [2] 전체조회
    @Select("select * from productsample")
    public List<ProductDto> onRead();

    // [3] 제품수정
    @Update("update productsample set name = #{name} , price = #{price} , comment = #{comment} where id = #{id} ")
    public boolean onUpdate( ProductDto productDto );

    // [4] 제품삭제
    @Delete("delete from productsample where id = #{id} ")
    public boolean onDelete( int id );

} // i end
