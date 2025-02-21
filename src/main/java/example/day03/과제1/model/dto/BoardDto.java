package example.day03.과제1.model.dto;

import lombok.*;

@Setter @Getter @ToString @Builder
@NoArgsConstructor @AllArgsConstructor
public class BoardDto {
    // PK
    private int bno;
    // 제목
    private String title;
    // 내용
    private String content;
} // c end
