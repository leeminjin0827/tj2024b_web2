package web.service;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.UUID;

@Service // 해당 클래스가 서비스임을 빈 등록
public class FileService {

    // [*} 업로드 된 파일을 저장할 폴더 경로 , 주로 : resources(폴더)
    // src -> main -> resources -> static -> upload
    // 1. 현재 프로젝트 최상위 디렉토리(폴더) 경로찾기
    String baseDir = System.getProperty("user.dir"); // 현재 작업 최상위(프로젝트 절대경로) 폴더를 반환한다.
    // -> C:\Users\tj-bu-702-06\Desktop\tj2024b_web2 , [PC마다 다르다]
    // 2. src 와 build 차이점 : src(실행전코드:개발자) vs build(실행후코드:사용자)
    // * 개발자는 src에서 작업하고 항상 서버를 실행 하므로써 작업한 코드를 build로 반영한다. ( 컴파일/빌드 )
    // * 업로드는 개발자의 src에 업로드 하지 않고 배포/비륻 된 build 폴더에 업로드한다.
    // String uploadPath = "/src/resources/static/upload";
    String uploadPath = baseDir+"/build/resources/main/static/upload/";
    // -> C:\Users\tj-bu-702-06\Desktop\tj2024b_web2/build/resources/main/static/upload

    // [1] 업로드 : 스프링에서는 MultipartFile 인터페이스 지원하므로써 파일 업로드 지원
    public String fileUpload( MultipartFile multipartFile ){ // (1) 매개변수로 'MultipartFile' 인터페이스 타입을 받는다.
        System.out.println("FileService.fileUpload");
        System.out.println("multipartFile = " + multipartFile);
        // (2) multipartFile 인터페이스내 다양한 메소드 제공한다.
        System.out.println( "첨부파일의 확장자 : " + multipartFile.getContentType() ); // 첨부파일의 확장자 반환
        System.out.println( "첨부파일의 용량 : " + multipartFile.getSize() ); // 첨부파일의 용량(바이트) 반환
        System.out.println( "첨부파일의 파일명 : " + multipartFile.getOriginalFilename() ); // 첨부파일의 파일명 반환
        System.out.println( "첨부파일 여부 : " + multipartFile.isEmpty() ); // 첨푸파일이 있다 false , 없다 true 반환
        // (3) 업로드 할 경로 만들기. // 업로드할 기본경로 와(+) 파일명
            // (*) 동일한 파일명으로 업로드할경우 식별이 불가능하다. 해결방안 : UUID , 식별자 생성
        String uuid = UUID.randomUUID().toString(); // 임의의 UUID 규약에 따른 난수 문자열 생성
        System.out.println("uuid = " + uuid);
            // (*) uuid 와(+) 파일명 ( 파일명에 _언더바가 존재하면 -하이픈 프로 모두 변경 ) , _언버다는 uuid와 파일명 구분하는 용도
        String fileName = uuid + "_" + multipartFile.getOriginalFilename().replaceAll("_","-");
            // (*) 업로드기본경로 + uuid포함된파일명
        String filePath = uploadPath + fileName;
        System.out.println( filePath );
            // (*) 만일 업로드 경로( upload 폴더 )가 존재하지 않으면 폴더 생성
            File file2 = new File( uploadPath );
            if( !file2.exists() ){ file2.mkdir(); }
        // (4) File 클래스 : File 관련된 다양한 메소드 제공하는 클래스
        File file = new File( filePath ); // new File( 파일경로 );
        // (5) 경로에 업로드 하기 , transferTo( file객체 )
        try{ multipartFile.transferTo( file );
        }catch ( IOException e ) { System.out.println( e ); return null;} // 만일 업로드 실패시 null 반환
        return fileName; // 만일에 업로드 성공시 업로드한 파일명 방환
        
    } // f end

    // [2] 업로드된 파일 다운로드
    // [사용자] -- HTTP(response) --> [서버] -- FileInputStream --> C: ~~ build
    // [사용자] <-- HTTP(response) -- [서버] <-- FileInputStream <--
    // * HTTP : 문자(JSON) 전송 , 대용량 파일(첨부파일)은 바이트(바이너리) 로 전송
    public void fileDownload(String filename , HttpServletResponse resp ){
        System.out.println("FileService.fileDownload");
        // (1) 사용자로부터 다운로드 받을 파일명 과 HTTP 응답 객체 받는다.

        // (2) 다운로드 받을 파일명과 업로드 경로 조합 ( 업로드 기본경로 + 다운로드할파일명 )
        String downloadPath = uploadPath + filename;
        System.out.println("downloadPath = " + downloadPath); // soutv
        // C:\Users\tj-bu-702-06\Desktop\tj2024b_web2/build/resources/main/static/upload/default.jpg

        // (3) 만일 다운로드할 파일의 경로가 존재하지 않으면 리턴 , new File( 파일경로 ); , 다양한 파일 함수 제공
        File file = new File( downloadPath );
        if( !file.exists() ){ return; } // 다운로드 취소/안함

        // (4) 업로드된 파일을 자바(바이트) 로 가져오기 , 서버(자바)는 업로드 경로로부터 다운로드 받을 파일을 바이트로 가져온다.
        // * 스트림 : 바이트(데이터)가 다니는 통로 , 대용량(첨부파일)에서는 무조건 바이트 전송해야한다.
        try{
            // 1. 파일 입력스트림 객체 생성 , new FileInputStream( 파일객체 ); , 예외처리
            FileInputStream fin = new FileInputStream( downloadPath );

            // 2. 해당하는 파일의 용량 만큼 배열 선언 , 읽어온 바이트들을 저장할 변수가 필요하므로.
            long fileSize = file.length();    // .length() : 파일의 용량 (long)반환
            System.out.println("fileSize = " + fileSize); // fileSize = 8584
            byte[] bytes = new byte[ (int)fileSize ]; // 파일의 용량 만큼 배열 선언 , 배열은 int 타입으로 크기 설정

            // 3. 파일 입력스트림 객체로 파일 읽어오기 , .read( 바이트배열 ) , 읽어온 바이트들을 바이트배열에 대입
            fin.read( bytes );
            System.out.println( Arrays.toString( bytes ) ); // 확인용

            // 4. 파일 입력스트림 닫기 , .close() , 권장 : 스트림에서 이동한 바이트들이 사용한 메모리들을 초기화 하면 안전하다.
            fin.close(); // 입력스트림의 메모리를 직접 닫아준다. 생략시 일정시간이후 GC 삭제한다.

        // (5) 가져온 바이트배열(파일)을 HTTP response 이용하여 요청한 사용자로부터 (바이트) 응답하기
            // * HTTP 응답 객체의 헤더 속성 추가 , 브라우저에게 다운로드 형식임을 알리자. , 다운로드 화면은 브라우저가 제공한다.
                // resp.setHeader( "Content-Disposition" , "attachment;filename=다운로드에표시할파일명");
            // * 파일명에 한글이 존재하면 깨진다. HTTP는 본래 한글을 지원 안한다.(인코딩 필요)
                // URLEncoder.encode( 한글파일명 , "UTF-8" ); // 한글파일명을 인코딩 해준다.
            String oldFilename = URLEncoder.encode( filename.contains("_") ? filename.split("_")[1] : filename , "UTF-8" ); // UUID(사용자에게보여줄필요없음)는 제거한다.
            resp.setHeader( "Content-Disposition" , "attachment;filename="+oldFilename );

            // 1. 서블릿 출력스트림 객체 생성 , .getOutputStream(); : response 객체에서 (바이트)출력스트림 반환
            ServletOutputStream fout = resp.getOutputStream();
            // 2. 서블릿 출력스트림 객체 이용한 읽어온 바이트 내보내기 , .write( 출력할배열 )
            fout.write( bytes );
            // 3. 서블릿 출력스트림 객체 닫기 , .close() , 권장 : 스트림에서 이동한 바이트들이 사용한 메모리들을 초기화 하면 안전하다.
            fout.close(); // 출력스트림의 메모리를 직접 닫아준다. 생략시 일정시간이후 GC 삭제한다.( 누수발생 고려 )
        }catch ( IOException e ) { System.out.println( e ); }

    } // f end

    // [3] 업로드된 파일 삭제
    public boolean fileDelete( String filename ) { // (1) 삭제할 파일명을 매개변수로 받는다.
        System.out.println("FileService.fileDelete");
        System.out.println("fileName = " + filename);
        String filePath = uploadPath + filename; // (2) 업로드경로 와 삭제할 파일명 연결한다.
        File file = new File( filePath ); // (3) new File( 파일경로 );
        if( file.exists() ) { // (4) .exists() : 경로상의 파일이 존재하면 true 아니면 false 반환
            file.delete(); // (5) .delete() : 경로상의 파일 삭제
            return true; // 삭제 성공 반환
        }
        return false;
    } // f end
    
} // c end
