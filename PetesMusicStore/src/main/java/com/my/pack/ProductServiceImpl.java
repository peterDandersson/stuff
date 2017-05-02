package com.my.pack;


import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;
import java.util.*;

@ApplicationScoped
public class ProductServiceImpl implements ProductService {

    private final Map<Long, Product> products;
    private final List<Product> popularProducts;

    public ProductServiceImpl() {
        Map<Long, Product> map = new HashMap<Long, Product>();
        map.put(1L, new Product(1L, "Microphone", "This mic is essential for every singer - this microphone makes your voice sound great.", new BigDecimal(10000.00),"U47"));
        map.put(2L, new Product(2L, "Guitar", "This guitar sounds great and looks cool.",new BigDecimal(900.00),"paul"));
        map.put(3L, new Product(3L, "Microphone", "This mic is essential for every singer - this microphone makes your voice sound great.", new BigDecimal(10000.00),"U47"));
        map.put(4L, new Product(4L, "Guitar", "This guitar sounds great and looks cool.", new BigDecimal(900.00),"paul"));
        map.put(5L, new Product(5L, "Microphone", "This mic is essential for every singer - this microphone makes your voice sound great.", new BigDecimal(10000.00),"U47"));

        products = Collections.unmodifiableMap(map);
        popularProducts = Collections.unmodifiableList(new ArrayList<Product>(new ArrayList<Product>(products.values())));
    }

    public List<Product> getPopularProducts() {
        return popularProducts;
    }

    public Product getProduct(long id) {
        return products.get(id);
    }
}
