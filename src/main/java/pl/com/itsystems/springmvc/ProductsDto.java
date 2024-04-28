package pl.com.itsystems.springmvc;

import java.util.ArrayList;
import java.util.List;

public class ProductsDto {
    private List<Product> products = new ArrayList<>();
    private double totalAmount;

    public ProductsDto(List<Product> products, double totalAmount) {
        this.products = products;
        this.totalAmount = totalAmount;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
