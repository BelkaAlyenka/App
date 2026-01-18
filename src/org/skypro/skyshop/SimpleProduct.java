package org.skypro.skyshop;

public class SimpleProduct extends Product {

    private final int productPrice;

    public SimpleProduct(String productName, int productPrice) {
        super(productName);
        this.productPrice = productPrice;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public int getProductPrice() {
        return productPrice;
    }

    @Override
    public String toString() {
        return getProductName() + ":" + getProductPrice();
    }
}
