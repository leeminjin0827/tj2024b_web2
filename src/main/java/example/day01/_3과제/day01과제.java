package example.day01._3과제;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/day01/task")
public class day01과제 {
    // 글쓰기
    @PostMapping("/board")
    public boolean bPost(){
        System.out.println("day01 bpost!!");
        return true;
    } // f end

    // 전체 글 조회
    @GetMapping("/board")
    public List<Map<String, String>> bGet1(){
        System.out.println("day01 bget1!!");
        List<Map<String , String > > list = new ArrayList<>();
        Map<String , String > map1 = new HashMap<>();
        map1.put("bno" , "1" );
        map1.put("btitle" , "테스트1" );
        list.add(map1);
        Map<String , String > map2 = new HashMap<>();
        map2.put("bno" , "2" );
        map2.put("btitle" , "테스트2" );
        list.add(map2);
        return list;
    } // f end

    // 개별 글 조회
    @GetMapping("/board/view")
    public Map<String,String> bGet2(){
        System.out.println("day01 bget2!!");
        Map<String ,String> map = new HashMap<>();
        map.put("bno" , "1");
        map.put("btitle" , "테스트" );
        return map;
    } // f end

    // 개별 글 수정
    @PutMapping("/board")
    public boolean bPut(){
        System.out.println("day01 bput!!");
        return true;
    } // f end

    // 개별 글 삭제
     @DeleteMapping("/board")
    public int bDelete(){
        System.out.println("day01 bdelete!!");
        return 1;
    } // f end


} // c end
