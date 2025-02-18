package example.day02._3과제;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Component // 싱글톤 대신에 사용한다.
public class BoardDao {

    List<BoardDto> list = new ArrayList<>();
    private int auto_increment = 1; // bno 자동번호 역할

    // 글쓰기
    public boolean bPost( @RequestBody BoardDto boardDto ){ // 매개변수 Dto
        boardDto.setBno( auto_increment ); // dto에 bno 주입
        list.add( boardDto ); // list에 dto 주입
        auto_increment++; //  bno 1 증가
        System.out.println("BoardController.bPost");
        return true;
    } // f end

    // 전체 글 조회
    public List<BoardDto> bGet1(){
        return list;
    } // f end

    // 개별 글 조회
    public BoardDto bGet2( int bno ){
        for( int index = 0; index <= list.size() -1; index++ ) {
            BoardDto boardDto = list.get(index); // 순회하면서 하나씩 리스트안에 넣기
            if( boardDto.getBno() == bno ) { // 입력한 bno가 순회하는 dto의 bno랑 맞으면
                return boardDto; // dto 리턴
            }
        } // for end
        return null; // 없으면
    } // f end

    // 개별 글 수정
    public boolean bPut( BoardDto boardDto ){
        for ( int index = 0; index <= list.size() -1; index++ ){
            BoardDto boardDto2 = list.get( index );
            if( boardDto2.getBno() == boardDto.getBno() ){
                list.set( index , boardDto );
                return true;
            }
        }
        return false;
    } // f end

    // 개별 글 삭제
    public boolean bDelete( int bno ){
        for ( int index = 0; index <= list.size() -1; index++ ){
            BoardDto boardDto2 = list.get( index );
            if( boardDto2.getBno() == bno ){
                list.remove( index );
                return true;
            }
        }
        return false;
    } // f end

} // c end
