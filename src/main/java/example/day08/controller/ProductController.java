package example.day08.controller;

import example.day08.model.dto.ProductDto;
import example.day08.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 스프링 빈 등록
@RequestMapping("/day08/products") // 공통 URL 정의
@CrossOrigin("http://192.168.40.77:5173") // 리액트 포트 도메인 허용한다.
public class ProductController {

    @Autowired
    private ProductService productService;

    // [1] 제품등록
    @PostMapping("") // (1) http://localhost:8080/day08/products
    public boolean onWrite( @RequestBody ProductDto productDto ){
        System.out.println("ProductController.onWrite");
        System.out.println("productDto = " + productDto);
        return productService.onWrite( productDto );
    } // f end

    // [2] 전체조회
    @GetMapping("") // (1) http://localhost:8080/day08/products
    public List<ProductDto> onRead(){ // (2) 매개타입 구성 ( Rest 명세서 )
        // (3) 리턴타입 구성 ( Rest 명세서 )
        System.out.println("ProductController.onRead");
        return productService.onRead();
    } // f end

    // [3] 제품수정
    @PutMapping("") // (1) http://localhost:8080/day08/products
    public boolean onUpdate( @RequestBody ProductDto productDto ){
        System.out.println("ProductController.onUpdate");
        System.out.println("productDto = " + productDto);
        return productService.onUpdate( productDto );
    } // f end

    // [4] 제품삭제
    @DeleteMapping("") // (1) http://localhost:8080/day08/products
    public boolean onDelete( @RequestParam("id") int id ){
        System.out.println("ProductController.onDelete");
        System.out.println("id = " + id);
        return productService.onDelete( id );
    } // f end

} // c end