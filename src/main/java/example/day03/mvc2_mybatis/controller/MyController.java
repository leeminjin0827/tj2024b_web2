package example.day03.mvc2_mybatis.controller;

import example.day03.mvc2_mybatis.model.dto.MyDto;
import example.day03.mvc2_mybatis.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 1. HTTP servlet 매핑 지원 // 2. ResponseBody 포함 // 3. 컨테이너 빈 등록
public class MyController {

    // * 스프링 컨테이너에서 객체/인스턴스 를 주입
    @Autowired private MyService myService;

    // (1) PostMapping [POST] http://localhost:8080/day03/save [BODY] { "name" : "아아아" , "age" : 11 }
    @PostMapping("/day03/save")
    public int save( @RequestBody MyDto myDto ) {
        System.out.println("MyController.save"); // soutm 자동완성 : 메소드명 출력
        System.out.println("myDto = " + myDto); // soutp 자동완성 : 매개변수 출력
        // 컨트롤러가 유저로부터 받은 데이터를 서비스에게 전달하고 응답받기
        int result = myService.save( myDto );
        return result;
    } // f end

    // (2)GetMapping [GET] http://localhost:8080/day03/findall
    @GetMapping("/day03/findall")
    public List< MyDto > findall( ){
        System.out.println("MyController.findall");
        // 컨트롤러에서 서비스에게 전달하고 응답받기
        List<MyDto> result = myService.findall();
        return result;
    } // f end

    // (2)GetMapping [GET] http://localhost:8080/day03/find?id=1
    @GetMapping("/day03/find")
    public MyDto find(@RequestParam("id") int id ){
        System.out.println("MyController.find");
        System.out.println("id = " + id);
        // 컨트롤러에서 서비스에게 전달하고 응답받기
        MyDto result = myService.find(id);
        return result;
    } // f end
    
    // (3)PutMapping [PUT] http://localhost:8080/day03/update
    @PutMapping("/day03/update")
    public int update( @RequestBody MyDto myDto ){
        System.out.println("MyController.update");
        System.out.println("myDto = " + myDto);
        int result = myService.update(myDto);
        return result;
    } // f end

    // (4)DeleteMapping [DELETE] http://localhost:8080/day03/delete?id=1
    @DeleteMapping("/day03/delete")
    public int delete( @RequestParam("id") int id ){
        System.out.println("MyController.delete");
        System.out.println("id = " + id);
        int result = myService.delete(id);
        return result;
    } // f end

} // c end
