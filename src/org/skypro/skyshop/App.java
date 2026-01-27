package org.skypro.skyshop;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

public class App {
    public static void main(String[] args) {
        try {
            Product drone = new DiscountedProduct("дрон", 10100, -30);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Product emptyProduct = new SimpleProduct(null, -100);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        ProductBasket basket = new ProductBasket();
        SearchEngine engine = new SearchEngine();

        Product smartphone = new SimpleProduct("смартфон", 13500);
        Product laptop = new SimpleProduct("ноутбук", 70000);
        Product headphones = new FixPriceProduct("наушники");
        Product kettle = new DiscountedProduct("чайник", 1200, 10);
        Product scales = new DiscountedProduct("весы", 600, 20);

        Article aboutSmartphone = new Article("про телефон", "Apple iPhone 6s Plus - это один из самых популярных мобильных телефонов на рынке. Он имеет 5,5-дюймовый экран с высоким разрешением и мощный процессор A9");
        Article aboutHeadphones = new Article("беспроводные наушники", "«Настоящие беспроводные» наушники — это Bluetooth-модели, которые работают без какого-либо провода между наушниками и источником звука (смартфоном, ноутбуком и так далее)");
        Article aboutScales = new Article("взвешивание", "С помощью весов можно взвешивать не только твердые и сыпучие продукты, но и любые жидкости. Прибор умеет измерять объем воды или молока, а также обладает функцией тарирования");

        basket.addProduct(smartphone);
        basket.addProduct(laptop);
        basket.addProduct(headphones);
        basket.addProduct(kettle);
        basket.addProduct(scales);

        basket.printAllProducts();
        System.out.println(basket.productComparison("ноутбук"));
        basket.clearProductBasket();
        basket.printAllProducts();

        engine.add(headphones);
        engine.add(kettle);
        engine.add(scales);
        engine.add(aboutScales);
        engine.add(aboutHeadphones);
        engine.add(aboutSmartphone);

        System.out.println(engine.outputSearch("наушники"));
        System.out.println(engine.outputSearch("чайник"));
        System.out.println(engine.outputSearch("весы"));
        System.out.println(engine.outputSearch("взвешивание"));

        try {
            Searchable result = engine.findMostSuitableMatch("наушники");
            System.out.println("Нашли: "+result.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.err.println(e.getMessage());
        }

        try {
            Searchable result = engine.findMostSuitableMatch("медуза");
            System.out.println("Нашли: "+result.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.err.println(e.getMessage());
        }
    }
}
