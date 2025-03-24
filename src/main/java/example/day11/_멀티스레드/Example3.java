package example.day11._멀티스레드;

import java.time.LocalTime;
import java.util.Scanner;

class 시간클래스 implements Runnable{
    @Override
    public void run() {
        try {
            while (true){ // 무한루프
                System.out.println(LocalTime.now()); // LocalTime.now() : 현재 시스템 시간 반환함수.
                Thread.sleep(1000); // 1초간 일시정지
            } // w end
        }catch ( Exception e ) { System.out.println( e ); }
    } // f end
} // c end

class 타이머클래스 extends Thread{

    boolean state = true; // 무한루프 실행여부
    @Override
    public void run() {
        int second = 0;
        try{
            while( state ){
                Thread.sleep( 1000 ); // 1초 일시정지
                second++; // 1즐가
                System.out.println("타이머 : " + second + "초");
            }
        }catch ( Exception e ) { System.out.println( e ); }
    } // f end // 작업스레드는 run 메소드가 종료되면 사라진다.
} // c end

public class Example3 {
    public static void main(String[] args) {
        // 1. ( 작업 스레드 )현재 시간을 출력하는 스레드
        시간클래스 runnable1 = new 시간클래스(); // 구현객체
        Thread thread1 = new Thread( runnable1 );
        thread1.start(); // start() 메소드가 run() 메소드 호출한다.

        // 3. ( 작업 스레드 ) 타이머를 출력하는 스레드 추가
        타이머클래스 thread2 = new 타이머클래스(); // 1개 타이머

        // 2. ( main 스레드 ) 입력받기
        while (true){
            Scanner scan = new Scanner( System.in );
            System.out.println("타이머 1.On 그외.Off : ");
            int ch = scan.nextInt();
            if( ch == 1 ) {
                System.out.println("** 타이머 시작 ** ");
                thread2 = new 타이머클래스();
                thread2.start();
            }else{
                System.out.println("** 타이머 종료 ** ");
                thread2.state = false;
            }
        } // w end

    } // f end
} // c end
