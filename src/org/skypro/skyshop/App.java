package org.skypro.skyshop;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        Product smartphone = new SimpleProduct("смартфон", 13500);
        Product laptop = new SimpleProduct("ноутбук", 70000);
        Product headphones = new FixPriceProduct("наушники");
        Product kettle = new DiscountedProduct("чайник", 1200, 10);
        Product scales = new DiscountedProduct("весы", 600, 20);

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
