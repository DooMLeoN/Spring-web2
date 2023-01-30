package mate.academy.controller;

import mate.academy.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Controller
public class DemoController {
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("massage","Hello Spring");
        return "index";
    }

    @ResponseBody
    @GetMapping("/time")
    public String getCurrentTime( ) {
        return LocalDateTime.now().toString();
    }

    @ResponseBody
    @GetMapping("/phone")
    public Product getProduct() {
        return new Product(1L, "iPhone 10", BigDecimal.valueOf(1596));
    }
}
