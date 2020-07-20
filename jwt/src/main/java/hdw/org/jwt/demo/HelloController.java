package hdw.org.jwt.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hdw
 * @create 2020-06-02-11:38
 * @desc 描述
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public  String  hello(){
        return "hello jwt";

    }

    @GetMapping("/admin")
    public String admin(){
        return "hello admin";
    }
}
