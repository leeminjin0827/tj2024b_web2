package example.day02._2의존성;
/*
    [ 스프링 방법4 : IOC 와 DI ] *권장 = 싱글톤
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // @Service 에는 @Component 포함
class SampleService4{
    void method(){
        System.out.println("SampleService4.method");
    } // f end
} // c end

class SampleController4{
    // static : 전역키워드 , final : 수정불가키워드
    private final SampleService4 sampleService4;

    @Autowired // 생성자를 이용하여 빈 등록 하는 방법
    public SampleController4( SampleService4 sampleService4 ){
        this.sampleService4 = sampleService4;
    } // f end

    public void method(){
        sampleService4.method();
    }
    
} // c end

public class Example4 {

} // c end
