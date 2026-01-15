package org.skypro.skyshop;

public class FixPriceProduct extends Product {

    private static final int FIXED_PRICE = 1500;

    public FixPriceProduct(String productName) {
        super(productName);
    }

    @Override
    public int getProductPrice() {
        return FIXED_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getProductName() + " c фиксированной ценой:" + getProductPrice();
    }
}
