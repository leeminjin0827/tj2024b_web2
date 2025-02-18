package example.day02._3과제;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/day02/task/board")
public class BoardController {
    @PostMapping("")
    public boolean bPost(){
        System.out.println("BoardController.bPost");
        return true;
    } // f end

} // c end
