package example.senter.service;

import example.senter.aspect.SenterAspect;
import example.senter.model.dto.SenterDto;
import example.senter.model.mapper.SenterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SenterService {

    @Autowired
    private SenterMapper senterMapper;
    private SenterAspect senterAspect;

    // 문의하기
    public int sWrite( SenterDto senterDto ){
        System.out.println( senterDto );
        // 문의 제목이 2글자 미만이거나 30글자 초과일경우
        if( senterDto.getStitle().length() < 2 || senterDto.getStitle().length() > 30 ) {
            return 2;
        }
        // 작성자 이름이 10글자 초과 일 경우
        if( senterDto.getSuser().length() > 10 ) {
            return 3;
        }
        boolean result = senterMapper.sWrite( senterDto );
        if( result ) { return 1; } // true면 1 반환
        else{ return 0; } // false면 0 반환
} // f end

    // 문의전체조회
    public List<SenterDto> sFindAll(){
        return senterMapper.sFindAll();
    } // f end
} // c end
