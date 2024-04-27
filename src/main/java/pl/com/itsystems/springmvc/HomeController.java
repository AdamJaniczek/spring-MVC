package pl.com.itsystems.springmvc;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.UUID;

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

    @GetMapping("/list")
    public String getCategory(String kategoria, Model model){
        double totalPrice = 0;
        List<Product> productList = productRepository.findByCategory(ProductCategory.valueOf(kategoria.toUpperCase()));
        for (Product product : productList) {
            totalPrice += product.getPrice();
        }
        model.addAttribute("products", productList);
        model.addAttribute("totalPrice", totalPrice);
        return "details";
    }

    @GetMapping("/add")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("productCategory", ProductCategory.values());
        return "add";
    }

    @PostMapping("/save")
    public String save(Product product){
        productRepository.save(product);
        return "redirect:/";
    }

    @GetMapping("/remove")
    public String removeById(UUID id){
        Product product = productRepository.findById(id);
        productRepository.remove(product);
        return "redirect:/";

    }

}
