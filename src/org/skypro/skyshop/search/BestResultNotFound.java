package org.skypro.skyshop.search;

public class BestResultNotFound extends Exception {
    public BestResultNotFound(String searchedRequest) {
        super("Указанного результата не найдено: " + searchedRequest);
    }
}
