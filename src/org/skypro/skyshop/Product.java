package org.skypro.skyshop;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private final String productName;

    public Product(String productName) {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустой строкой или null");
        }
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public abstract boolean isSpecial();

    public abstract int getProductPrice();

    @Override
    public String getSearchTerm() {
        return productName;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getName() {
        return productName;
    }
}
