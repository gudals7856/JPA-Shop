package jpabook.jpashop;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    // Model에 데이터를 실어서 뷰에 넘길 수 있음. 이름이 data라는 키의 값을 hello!!로 하여 넘김
    public String Hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello"; // hello.html에 데이터 넘기겠다는 뜻.
    }
}
