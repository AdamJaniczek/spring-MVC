package pl.com.itsystems.springmvc;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    public ProductRepository(){
        products.add(new Product("Chleb", 5.6, ProductCategory.SPOZYWCZE));
        products.add(new Product("Piwo", 4.75, ProductCategory.INNE));
        products.add(new Product("Gazeta Wyborcza", 9.20, ProductCategory.INNE));
        products.add(new Product("Worki na śmieci", 8.0, ProductCategory.DOMOWE));
    }

    public List<Product> findAll() {
        return products;
    }

    public List<Product> findByCategory(ProductCategory productCategory){
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(productCategory)) {
                result.add(product);
            }
        }
        return result;
    }

    public void save(Product product){
        product.setId();
        products.add(product);
    }

    public Product findById(UUID id){
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return new Product();
    }

    public void remove(Product product){
        products.remove(product);
    }
}
