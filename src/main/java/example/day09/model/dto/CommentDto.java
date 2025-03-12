package example.day09.model.dto;

import lombok.*;

@Setter @Getter @ToString @Builder
@NoArgsConstructor @AllArgsConstructor
public class CommentDto {

    // 댓글 번호 (PK)
    private int cno;
    // 댓글 내용
    private String cmessage;
    // 댓글 비밀번호( 삭제 사용 )
    private int cpassword;
    // 책 번호 (FK)
    private int bno;

} // c end
