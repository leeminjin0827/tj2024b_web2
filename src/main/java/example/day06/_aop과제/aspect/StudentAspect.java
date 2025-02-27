    package example.day06._aop과제.aspect;

    import example.day06._aop과제.service.StudentService;
    import org.aspectj.lang.ProceedingJoinPoint;
    import org.aspectj.lang.annotation.AfterReturning;
    import org.aspectj.lang.annotation.Around;
    import org.aspectj.lang.annotation.Aspect;
    import org.aspectj.lang.annotation.Before;
    import org.springframework.stereotype.Component;

    import java.util.Arrays;
    import java.util.HashMap;

    @Aspect // AOP 적용
    @Component // 스프링 컨테이너에 빈 등록
    public class StudentAspect {

        // [*] @Before / @AfterReturning 사용하지 않고 / @Around 하나로 표현
        @Around( " execution( * example.day06._aop과제.service.StudentService.*(..) )")
        public Object TaskServiceCheck( ProceedingJoinPoint joinPoint ) throws Throwable {
            // * 지정한 함수 시그너처 출력
            System.out.println("[실행메소드] : " + joinPoint.getSignature() );
            // 1. 매개변수 출력
            // Arrays.toString( 배열변수 ) : 배열 출력을 주소값이 아닌 값으로 반환
            System.out.println("[매개변수] : " + Arrays.toString( joinPoint.getArgs() ) );
            // * 지정한 함수 실행
            Object result = joinPoint.proceed();
            // 2. 반환 값 출력
            System.out.println("[반환값] : " + result );
            // * 지정한 함수의 반환 값 그래도 반환
            return result;
        } // f end

        /*
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

            // ProceedingJoinPoint : AOP 에서 사용되는 인터페이스
            // 제공하는 메소드
            // 1. .proceed() : 지정한 메소드를 실행하는 메소드
            System.out.println( joinPoint.getArgs() ); // 지정한 메소드의 매개변수 반환( 배열타입 )
            System.out.println( joinPoint.getSignature() ); // 지정한 메소드 시그니처 반환( 실행된 메소드의 리턴타입,함수명,매개변수 )
            System.out.println( joinPoint.getTarget() ); // 지정한 메소드를 실행한 객체 ( TaskService객체 )

            // 시작시간
            long sTime = System.currentTimeMillis();
            Object result = joinPoint.proceed();
            long eTime = System.currentTimeMillis();
            long pTime = eTime - sTime;
            System.out.println("메소드가 실행된 시간 : " + pTime + "ms");
            return result;
        } // f end
        */


} // c end
