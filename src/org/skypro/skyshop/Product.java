package org.skypro.skyshop;

public class Product {
    private final String productName;
    private final int productPrice;

    public Product(String productName, int productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    @Override
    public String toString() {
        return productName + ":" + productPrice;
    }
}
