package example.day11._과제;

import java.util.Scanner;

class WebClass extends Thread{
    boolean state1 = false;
    @Override
    public void run() {
        try{
            while (state1){
                System.out.println( "웹서핑 중...");
                Thread.sleep( 1000 );
            }
        }catch ( Exception e ) { System.out.println( e ); }
    } // f end
} // c end

class MusicClass extends Thread{
    boolean state2 = false;
    @Override
    public void run() {
        try{
            while (state2){
                System.out.println("음악 재생 중 ...");
                Thread.sleep( 1000 );
            }
        }catch ( Exception e ) { System.out.println( e ); }
    } // f end
} // c end

public class Index {
    public static void main(String[] args) {
        WebClass webClass = new WebClass();
        MusicClass musicclass = new MusicClass();
        boolean web = true;
        while(web){
            Scanner scan = new Scanner( System.in );
            System.out.println("===== 1. 음악 On/Off | 2. 웹서핑 On/Off | 0. 종료 =====");
            int i = scan.nextInt();
            if( i == 1 ){
                if( musicclass.state2 == false ) {
                    System.out.println("음악 시작!");
                    musicclass.start();
                    musicclass.state2 = true;
                }
                else if( musicclass.state2 == true ){
                    System.out.println("음악 종료!");
                    musicclass.state2 = false;
                } // f
            }else if ( i == 2 ) {
                if( webClass.state1 == false ) {
                    System.out.println("웹서핑 시작!");
                    webClass.start();
                    webClass.state1 = true;
                }
                else if( webClass.state1 == true ){
                    System.out.println("웹서핑 종료!");
                    webClass.state1 = false;
                }
            }else if ( i == 0 ) {
                System.out.println("프로그램 종료!");
                musicclass.state2 = false;
                webClass.state1 = false;
                web = false;
            }
        } // w end
    } // f end
} // c end
