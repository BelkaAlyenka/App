package org.skypro.skyshop;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discountPercentages;

    public DiscountedProduct(String productName, int basePrice, int discountPercentages) {
        super(productName);
        this.basePrice = basePrice;
        this.discountPercentages = discountPercentages;
    }

    @Override
    public int getProductPrice() {
        return (int) (basePrice * (100 - discountPercentages) / 100.0);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getProductName() + " со скидкой:" + getProductPrice();
    }
}
