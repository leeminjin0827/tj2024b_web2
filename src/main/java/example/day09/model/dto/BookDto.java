package example.day09.model.dto;

import lombok.*;

@Setter @Getter @ToString @Builder
@NoArgsConstructor @AllArgsConstructor
public class BookDto {

    // 책 번호(PK)
    private int bno;
    // 책 제목
    private String bname;
    // 책 저자
    private String buser;
    // 책 소개
    private String bmessage;
    // 책 비밀번호( 수정 , 삭제 사용 )
    private String bpassword;

} // c end
