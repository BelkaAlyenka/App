package org.skypro.skyshop;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> mapProducts;
    private int specialCount = 0;

    public ProductBasket() {
        this.mapProducts = new HashMap<>();
    }
    //добавляем продукты
    public void addProduct(Product product) {
        if (product == null) {
            return;
        }
        String name = product.getProductName();
        List<Product> productsList = mapProducts.computeIfAbsent(name, key -> new LinkedList<>());
        productsList.add(product);
        if (product.isSpecial()) {
            specialCount++;
        }
    }
    //общая стоимость корзины
    public int calculateBasketPrice() {
        return mapProducts.values()
                .stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getProductPrice)
                .sum();
    }
    //печатаем содержимое корзины
    public void printAllProducts() {
        if (mapProducts.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        mapProducts.values()
                .stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);

        System.out.println("Итого: " + calculateBasketPrice());
        System.out.println("Специальных товаров: " + specialCount);
    }
    //сравниваем имя продукта
    public boolean productComparison(String productName) {
        if (productName == null) return false;
        return mapProducts.containsKey(productName);
    }
    //очищаем корзину
    public void clearProductBasket() {
        mapProducts.clear();
        specialCount = 0;
    }
    //удаление продукта по имени
    public List<Product> clearByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Имя продукта не может быть null");
        }
        List<Product> deletedProducts = mapProducts.remove(name);
        if (deletedProducts != null) {
            for (Product product : deletedProducts) {
                if (product.isSpecial()) {
                    specialCount--;
                }
            }
        }
        return deletedProducts != null ? deletedProducts : new LinkedList<>();
    }
}
