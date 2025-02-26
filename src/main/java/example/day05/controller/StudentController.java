package example.day05.controller;

import example.day05.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/day05/students")
public class StudentController {

    @Autowired // (스프링 컨테이너) 에서 빈(인스턴스) 주입
    private StudentService studentService;

    // [1] 등록
    @PostMapping("")
    public int save(@RequestBody HashMap< String , Object > map ){
        System.out.println("StudentController.save");
        System.out.println("map = " + map);
        return studentService.save( map );
    } // f end

    // [2] 전체조회
    @GetMapping("")
    public List<Map< String , Object > > findAll(){
        System.out.println("StudentController.findAll");
        return studentService.findAll();
    } // f end

    // [3] 수정
    @PutMapping("")
    public int update( @RequestBody HashMap< String , Object > map ) {
        System.out.println("StudentController.update");
        System.out.println("map = " + map);
        return studentService.update( map );
    } // f end

    // [4] 삭제
    @DeleteMapping("")
    public boolean delete ( @RequestParam("sno") int sno ) {
        System.out.println("StudentController.delete");
        System.out.println("sno = " + sno);
        return studentService.delete( sno );
    } // f end

    // [5] 특정 점수 이상 학생 조회
    @GetMapping("/find/scores")
    public List< Map < String , Object > > findStudentScores(
            @RequestParam int minKor ,
            @RequestParam int minMath ) {
        System.out.println("StudentController.findStudentScores");
        System.out.println("minKor = " + minKor + ", minMath = " + minMath);
        return studentService.findStudentScores(minKor, minMath);
    } // f end

    // [6] 여러명의 학생 등록하기
    @PostMapping("/save/all")
    // post : http://localhost:8080/day
    // body : [ { "name" : "라라라" , "kor" : 50 , "math" : 40 } , { "name" : "라라라" , "kor" : 50 , "math" : 40 } ]
    public boolean saveAll( @RequestBody List< Map< String , Object > > list ){
        System.out.println("StudentController.saveAll");
        System.out.println("list = " + list);
        return studentService.saveAll( list );

    } // f end


} // c end
