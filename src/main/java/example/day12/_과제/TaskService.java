package example.day12._과제;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskMapper taskMapper;
    
    // 30초 마다 모든 제품의 재고 3개 감소
    @Scheduled( cron = "*/30 * * * * *")
    public void task1( ){
        taskMapper.task1();
        System.out.println( " ========== 30초 마다 제품 재고 3개 감소 ================== ");
    } // f end
    
    // 1분마다 모든 제품 정보를 조회 하여 sout출력
    @Scheduled( cron = "0 */1 * * * *")
    public List<TaskDto> task2(){
        List<TaskDto> list = taskMapper.task2();
        System.out.println(" ========== 1분마다 제품 정보 조회 ========================= ");
        System.out.println( list );
        return list;
    } // f end

    // 5분마다 재고가 10 이하인 상품의 재고를 20개 추가
    @Scheduled( cron = "0 */5 * * * * ")
    public void task3(){
        taskMapper.task3();
        System.out.println(" ========== 5분마다 재고가 10 이하인 상품 재고 20개 추가 ====== ");
    } // f end
    
} // class end