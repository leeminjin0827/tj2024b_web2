    package example.day06._aop과제.aspect;

    import example.day06._aop과제.service.StudentService;
    import org.aspectj.lang.ProceedingJoinPoint;
    import org.aspectj.lang.annotation.AfterReturning;
    import org.aspectj.lang.annotation.Around;
    import org.aspectj.lang.annotation.Aspect;
    import org.aspectj.lang.annotation.Before;
    import org.springframework.stereotype.Component;

    import java.util.HashMap;

    @Aspect // AOP 적용
    @Component // 스프링 컨테이너에 빈 등록
    public class StudentAspect {

        // [1] 등록 실행 전 // args(name,kor,math) // String name , int kor , int math
        @Before("execution( * example.day06._aop과제.service.StudentService.save(..)) && args(map) ")
        public void check1(HashMap<String,Object> map ){
            String name = (String) map.get("name");
            int kor = (Integer) map.get("kor");
            int math = (Integer) map.get("math");
            System.out.println("등록 메소드 실행 전(before) : " + name + "의 국어점수는 " + kor + "점 이고, 수학점수는 " + math + "점 이다." );
        } // f end

        // [1-1] 조회 실행 전
        @Before( "execution( * example.day06._aop과제.service.StudentService.listAll(..))")
        public void check2(){
            System.out.println("조회 메소드 실행 전(before)");
        } // f end

        // [2] 등록 실행된 후
        @AfterReturning( value = "execution( * example.day06._aop과제.service.StudentService.*(..))" , returning = "result" )
        public void check2( Object result ) {
            System.out.println("메소드 실행된 후 " + result );
        } // f end

        // [3] 서비스 걸린 시간
        @Around(" execution( * example.day06._aop과제.service.StudentService.*(..) )" )
        public Object timeCheck1(ProceedingJoinPoint joinPoint ) throws Throwable {
                // 시작시간
                long sTime = System.currentTimeMillis();
                Object result = joinPoint.proceed();
                long eTime = System.currentTimeMillis();
                long pTime = eTime - sTime;
                System.out.println("메소드가 실행된 시간 : " + pTime + "ms");
                return result;
        } // f end

} // c end
