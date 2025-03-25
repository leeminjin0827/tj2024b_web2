package example.day12._스프링스레드;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ThreadService {

    // (1) 비동기
    @Async // [2] 멀티 스레드를 적용할 메소드 위에 @Async
    public void thread1(){
        String name = UUID.randomUUID().toString(); // 구분용
        for( int i = 1; i <= 10; i++ ){
            System.out.println( "[비동기]" + i + " 작업스레드 : " + name );
            try{ Thread.sleep( 1000); }
            catch ( Exception e ) { System.out.println( e ); }
        } // for end
    } // f end

    // (2) 동기 , synchronized
    @Async
    public synchronized void thread2(){
        String name = UUID.randomUUID().toString();
        for( int i = 1; i <= 10; i++ ){
            System.out.println( "[동기]" + i + " 작업스레드 : " + name );
            try{ Thread.sleep( 1000); }
            catch ( Exception e ) { System.out.println( e ); }
        } // for end
    } // f end

} // class end

