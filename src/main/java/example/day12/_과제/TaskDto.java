package example.day12._과제;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class TaskDto {

    // 상품 ID(PK)
    private int product_id;
    // 상품명
    private String product_name;
    // 재고 수량
    private int stock_quantity;


} // class end
