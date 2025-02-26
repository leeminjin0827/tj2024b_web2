package example.day05.service;

import example.day05.model.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service // (스프링 컨테이너) 에서 빈(인스턴스) 등록
public class StudentService{

    @Autowired
    private StudentMapper studentMapper;

    // [1] 등록
    public int save( HashMap< String , Object > map ){
        System.out.println("StudentService.save");
        System.out.println("map = " + map);
        return studentMapper.save(map);
    } // f end

    // [2] 전체조회
    public List< Map< String , Object > > findAll(){
        System.out.println("StudentService.findAll");
        return studentMapper.findAll();
    } // f end

    // [3] 수정
    public int update( HashMap< String , Object > map ) {
        System.out.println("StudentService.update");
        System.out.println("map = " + map);
        return studentMapper.update(map);
    } // f end

    // [4] 삭제
    public boolean delete ( int sno ) {
        System.out.println("StudentService.delete");
        System.out.println("sno = " + sno);
        return studentMapper.delete(sno);
    } // f end

    // [5] 특정 점수 이상 학생 조회
    public List< Map < String , Object > > findStudentScores(
            int minKor , int minMath ) {
        System.out.println("StudentService.findStudentScores");
        System.out.println("minKor = " + minKor + ", minMath = " + minMath);
        return studentMapper.findStudentScores(minKor, minMath);
    }

    // [6] 여러명의 학생 등록하기
    public boolean saveAll( List< Map< String , Object> > list ) {
        System.out.println("StudentService.saveAll");
        System.out.println("list = " + list);
        return studentMapper.saveAll( list );
    } // f end

} // c end
