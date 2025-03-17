package web.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import web.service.FileService;

@RestController
@RequestMapping("/api/file")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    // [1] 업로드
    // [POST] http://localhost:8080/api/file/upload
    // Content-Type : multipart/form-data
    // Body : (FORM) name : multipartFile , 임의로 FILE 업로드
    @PostMapping("/upload")
    public String fileUpload(MultipartFile multipartFile){
        System.out.println("FileController.fileUpload");
        System.out.println("multipartFile = " + multipartFile);
        String result = fileService.fileUpload( multipartFile );
        return result;
    } // f end

    // [2] 업로드된 파일 다운로드
    // [GET] http://localhost:8080/api/file/download?filename=[다운로드받을파일명]
    @GetMapping("/download")
    public void fileDownload(@RequestParam String filename , HttpServletResponse resp ){
        System.out.println("FileController.fileDownload");
        System.out.println("filename = " + filename + ", resp = " + resp);
        fileService.fileDownload( filename , resp );
    } // f end

    // [3] 업로드된 파일 삭제
    // [GET] http://localhost:8080/api/file/delete?fileName=[삭제할파일명]
    @GetMapping("/delete")
    public boolean fileDelete(@RequestParam String filename ){
        System.out.println("FileController.fileDelete");
        boolean result = fileService.fileDelete( filename );
        return result;
    } // f end

} // c end
