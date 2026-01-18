package org.skypro.skyshop;

public abstract class Product {
    private final String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public abstract boolean isSpecial();

    public abstract int getProductPrice();

}
