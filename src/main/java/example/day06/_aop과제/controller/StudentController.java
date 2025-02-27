package example.day06._aop과제.controller;

import example.day06._aop과제.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/day06/students")
public class StudentController {

    @Autowired private StudentService studentService;
    
    // [1] 등록
    @PostMapping("")
    public boolean save(@RequestBody HashMap< String, Object > map ){
        return studentService.save( map );
    } // f end
    
    // [2] 전체조회
    @GetMapping("")
    public List<Map < String , Object > > listAll (){
        return studentService.listAll();
    } // f end

} // c end
