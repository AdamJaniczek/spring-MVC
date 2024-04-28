package pl.com.itsystems.springmvc;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    public ProductsDto productsDto(List<Product> products){
        return new ProductsDto(products, totalAmount(products));
    }

    public double totalAmount(List<Product> products){
        double result = 0;
        if (!products.isEmpty()){
            for (Product product : products) {
                result += product.getPrice();
            }
        }
        return result;
    }

}
