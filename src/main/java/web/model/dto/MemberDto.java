package web.model.dto;

import lombok.*;

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

} // c end
