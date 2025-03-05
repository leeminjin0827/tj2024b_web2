package example.senter.controller;

import example.senter.model.dto.SenterDto;
import example.senter.service.SenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/senter")
public class SenterController {

    @Autowired
    private SenterService senterService;

    // 문의등록
    @PostMapping("")
    public void sWrite( @RequestBody SenterDto senterDto ){
        int result = senterService.sWrite( senterDto );
        if( result == 0 ){
            System.out.println("회원가입 실패");
        }else if ( result == 1 ){
            System.out.println("회원가입 성공");
        }else if ( result == 2 ){
            System.out.println("문의 제목은 3글자 이상 30글자 미만으로 작성해주세요.");
        }else if ( result == 3 ){
            System.out.println("작성자 이름을 10글자 이하로 작성해주세요.");
        }
    } // f end

    // 문의전체조회
    @GetMapping("")
    public List<SenterDto> sFindAll(){
        List<SenterDto> list = senterService.sFindAll();
        return list;
    } // f end

} // c end
