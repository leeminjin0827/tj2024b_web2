package example.day06._aop과제.service;

import example.day06._aop과제.aspect.StudentAspect;
import example.day06._aop과제.model.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    @Autowired private StudentMapper studentMapper;
    @Autowired private StudentAspect studentAspect;

    // 등록
    public boolean save(HashMap<String , Object> map ){
        return studentMapper.save( map );
    } // f end

    // 전체조회
    public List<Map< String ,Object > > listAll(){
        return studentMapper.listAll();
    } // f end


} // c end
