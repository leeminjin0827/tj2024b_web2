package example.day12._과제;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TaskMapper {

    // // 30초 마다 모든 제품의 재고 3개 감소
    @Update(" update day12products set stock_quantity = stock_quantity -3 where stock_quantity >= 3 ")
    void task1( );

    // 1분마다 모든 제품 정보를 조회 하여 sout출력
    @Select(" select * from day12products ")
    List<TaskDto>task2();

    // 5분마다 재고가 10 이하인 상품의 재고를 20개 추가
    @Update(" update day12products set stock_quantity = stock_quantity +20 where stock_quantity <= 10")
    void task3( );

} // i end
