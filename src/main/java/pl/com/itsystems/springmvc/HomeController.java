package pl.com.itsystems.springmvc;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private ProductRepository productRepository;

    public HomeController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String homePage(Model model){
        List<Product> productList = productRepository.findAll();
        model.addAttribute("products", productList);
        return "index";
    }
}
