package example.day14;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface TranMapper {

    // (1) 
    @Insert(" insert into day14users(name) values( #{name} )")
    public boolean tran( String name );
    
    // (2) 출금 , 빼기
    @Update("update day14users set money = money - #{money} where name = #{name}")
    public boolean withdraw( String name , int money );

    // (2) 입금 , 더하기
    @Update("update day14users set money = money + #{money} where name = #{name}")
    public boolean deposit( String name , int money );
    
    // (3) 모든 회원 목록 조회
    @Select("select name from day14users")
    public List<String> findAll();

    // (3)

} // i end
