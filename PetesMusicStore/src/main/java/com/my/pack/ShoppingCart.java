package com.my.pack;

import javafx.util.converter.BigDecimalStringConverter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class ShoppingCart implements Serializable {

    private final static long serialVersionUID = 1L;
    private final List<ShoppingCartLine> lines = new ArrayList<ShoppingCartLine>();
    private int totalQuantity = 0;
    private BigDecimal totalAmount = BigDecimal.ZERO;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<ShoppingCartLine> getLines() {
        return lines;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void addProduct(Product product){
        boolean productIsNew = true;
        totalAmount = totalAmount.add(product.getPrice());
        for (ShoppingCartLine line: lines){
            if (line.getProduct() == product){
                line.setQuantity(line.getQuantity() + 1);
                productIsNew = false;
            }
        }
        if(productIsNew){
            lines.add(new ShoppingCartLine(product));
        }
        totalQuantity++;
    }

    public void removeProduct(Product product){
        ShoppingCartLine l = null;
        for(ShoppingCartLine line : lines){
            if(line.getProduct() == product){
                totalAmount = totalAmount.subtract(product.getPrice());
                line.setQuantity(line.getQuantity() - 1);
                if(line.getQuantity() < 1){
                    l = line;
                }
            }
        }
        if(null != l){
            lines.remove(l);
        }
        totalQuantity--;
    }
}
