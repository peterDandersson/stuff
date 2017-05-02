package com.my.pack;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class PopularProducts {

    @Inject
    private ProductService productService;

    private List<Product> products;

    @PostConstruct
    public void initialize(){
        products = productService.getPopularProducts();
    }

    public List<Product> getProducts(){
        return products;
    }
}
