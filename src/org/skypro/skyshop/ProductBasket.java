package org.skypro.skyshop;

import java.util.Arrays;

public class ProductBasket {
    private final Product[] products;
    private int count;

    public ProductBasket() {
        this.products = new Product[5];
        this.count = 0;
    }
    //добавляем продукты
    public void addProduct(Product product) {
        if (product == null) {
            return;
        }
        if (count < products.length) {
            products[count] = product;
            count++;
        } else {
            System.out.println("Невозможно добавить продукт");
        }
    }
    //общая стоимость корзины
    public int calculateBasketPrice() {
        if (count == 0) {
            return 0;
        }
        int totalPrice = 0;
        for (Product product : products) {
            if (product == null) {
                break;
            }
            totalPrice += product.getProductPrice();
        }
        return totalPrice;
    }
    //печатаем содержимое корзины
    public void printAllProducts() {
        int i = 0;

        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
                i++;
            }
        }

        if (i == 0) {
            System.out.println("В корзине пусто");
        }
        System.out.println("Итого: " + calculateBasketPrice());
    }
    //сравниваем имя продукта
    public boolean productComparison(String productName) {
        if (productName == null) return false;
        for (int i = 0; i < count; i++) {
            if (products[i] != null && products[i].getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }
    //очищаем корзину
    public void clearProductBasket() {
        Arrays.fill(products, null);
    }
}
