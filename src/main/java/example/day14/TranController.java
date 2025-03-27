package example.day14;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/day14/users")
public class TranController {

    private final TranService tranService;

    // (1)
    @PostMapping("")
    public boolean tran(){
        tranService.tran();
        return true;
    } // f end

    // (2) // '서장훈이 강호동에게 10만원 보내는 예제'
    @PostMapping("/transfer")
    // { "fromname" : "서장훈" , "toname" : "강호동" , "money" : "100000" }
    public boolean transfer(@RequestBody Map<String , String> params ){
        try {
            tranService.transfer(params);
            return true; // 에외 발생이 없다면 이체 완료
        }catch ( Exception e ){
            return false; // 에외 발생이 있다면 이체 실패
        } // try end
    } // f end


} // class end
