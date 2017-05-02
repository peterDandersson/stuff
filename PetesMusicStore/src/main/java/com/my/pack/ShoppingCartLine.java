package com.my.pack;

import java.math.BigDecimal;

/**
 * Created by Elev1 on 2017-03-09.
 */
public class ShoppingCartLine {

    private Product product;
    private int quantity;
    private BigDecimal amount;

    public ShoppingCartLine(Product product) {
        this.product = product;
        this.quantity = 1;
        this.amount = product.getPrice();
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
