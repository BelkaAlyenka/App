package org.skypro.skyshop;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        Product smartphone = new Product("смартфон", 13500);
        Product laptop = new Product("ноутбук", 70000);
        Product headphones = new Product("наушники", 1500);
        Product kettle = new Product("чайник", 1200);
        Product scales = new Product("весы", 600);

        basket.addProduct(smartphone);
        basket.addProduct(laptop);
        basket.addProduct(headphones);
        basket.addProduct(kettle);
        basket.addProduct(scales);

        basket.printAllProducts();
        System.out.println(basket.productComparison("ноутбук"));
        basket.clearProductBasket();
        basket.printAllProducts();
    }
}
