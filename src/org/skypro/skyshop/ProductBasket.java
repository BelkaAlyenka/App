package org.skypro.skyshop;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    private final List<Product> products;
    private int specialCount = 0;

    public ProductBasket() {
        this.products = new LinkedList<>();
    }
    //добавляем продукты
    public void addProduct(Product product) {
        if (product == null) {
            return;
        }
        products.add(product);
        if (product.isSpecial()) {
            specialCount++;
        }
    }
    //общая стоимость корзины
    public int calculateBasketPrice() {
        int totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getProductPrice();
        }
        return totalPrice;
    }
    //печатаем содержимое корзины
    public void printAllProducts() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        for (Product product : products) {
            System.out.println(product);
        }

        System.out.println("Итого: " + calculateBasketPrice());
        System.out.println("Специальных товаров: " + specialCount);
    }
    //сравниваем имя продукта
    public boolean productComparison(String productName) {
        if (productName == null) return false;
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }
    //очищаем корзину
    public void clearProductBasket() {
        products.clear();
        specialCount = 0;
    }
    //удаление продукта по имени
    public List<Product> clearByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Имя продукта не может быть null");
        }
        List<Product> deletedProducts = new LinkedList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (p.getName().equals(name)) {
                deletedProducts.add(p);
                iterator.remove();
                if (p.isSpecial()) {
                    specialCount--;
                }
            }
        }
        return deletedProducts;
    }
}
