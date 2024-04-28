package pl.com.itsystems.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {

    private ProductRepository productRepository;
    private ProductService productService;

    public ProductController(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @GetMapping("/list")
    public String getCategory(String kategoria, Model model){
        List<Product> productList = productRepository.findByCategory(ProductCategory.valueOf(kategoria.toUpperCase()));
        ProductsDto products = productService.productsDto(productList);
        model.addAttribute("products", products);
        return "list";
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
