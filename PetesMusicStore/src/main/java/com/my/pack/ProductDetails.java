package com.my.pack;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class ProductDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ProductService productService;

    private long productId;
    private Product product;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public void onload(){
        product = productService.getProduct(productId);
    }

    public Product getProduct() {
        return product;
    }
}
