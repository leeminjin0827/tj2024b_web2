package web.model.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data // @Getter @Setter @ToString 등등 포함
@AllArgsConstructor // 전체 생성자
@NoArgsConstructor // 빈 생성자
@Builder // 빌더패턴 지원
public class MemberDto {

    // 회원 번호 (기본키)
    private int mno;
    // 회원 아이디
    private String mid;
    // 비밀번호
    private String mpwd;
    // 회원 이름
    private String mname;
    // 프로필 이미지 URL
    private String mimg;
    // + 그외
    private MultipartFile uploadfile; // [FORM전송] 등록시 업로드 된 파일의 바이트 인터페이스 (1개)
    // private List<MultipartFile> uploadfiles; // 등록시 여러개 업로드 된 파일 (여러개)

} // c end
