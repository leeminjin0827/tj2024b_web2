//package example.day13._과제;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class task {
//    public static void main(String[] args) {
//        List<String> 과일들 = List.of("사과" , "바나나" , "체리" , "대추" , "포도" );
//
//        // 1.[메소드 레퍼런스 사용안함]  forEach함수를 활용하여 과일들을 하나씩 console에 출력하시오.
//        과일들.forEach( (과일) -> { System.out.println( "[1] 과일명 : " + 과일 ); } );
//
//        // 2.[메소드 레퍼런스 사용안함]  map함수를 활용하여 과일들을 하나씩 console에 출력하시오.
//        List<String> result1 = 과일들.stream()
//                .map( 과일 ->   )
//                .forEach( 과일 -> System.out.println("[2]" + 과일 ));
//
//        // 3.[메소드 레퍼런스 사용안함]  filter함수를 활용하여 과일들 중에 '바나나' 또는 '대추'만 console에 출력하시오.
//
//        // 4.[메소드 레퍼런스 사용안함]  sorted함수를 활용하여 과일들을 내림차순으로 정렬하여 하나씩 console에 출력하시오.
//
//        // 5.[메소드 레퍼런스 사용함]  forEach함수를 활용하여 과일들을 하나씩 console에 출력하시오.
//
//        // 6.[메소드 레퍼런스 사용함]  map함수를 활용하여 과일들을 하나씩 console에 출력하시오.
//
//        // 7.[메소드 레퍼런스 사용함]  filter함수를 활용하여 과일들 중에 '바나나' 또는 '대추'만 console에 출력하시오.
//
//        // 8.[메소드 레퍼런스 사용함]  sorted함수를 활용하여 과일들을 내림차순으로 정렬하여 하나씩 console에 출력하시오.
//
//    } // main end
//} // class end
