package org.skypro.skyshop.search;

import java.util.LinkedList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> elements;

    public SearchEngine() {
        this.elements = new LinkedList<>();
    }
    //добавляем элементы
    public void add(Searchable element) {
        if (element == null) {
            return;
        }
        elements.add(element);
    }
    //поиск по строке
    public List<Searchable> search(String message) {
        List<Searchable> results = new LinkedList<>();

        for (Searchable element : elements) {
            if (element != null && element.getSearchTerm() != null && element.getSearchTerm().contains(message)) {
                results.add(element);
            }
        }
        return results;
    }
    //выводим результаты в строковом представлении
    public String outputSearch(String message) {
        List<Searchable> results = search(message);
        List<String> representations = new LinkedList<>();

        for (Searchable result : results) {
            representations.add(result.getStringRepresentation());
        }

        return String.join("\n", representations);
    }
    //поиск наиболее часто встречающегося элемента
    public Searchable findMostSuitableMatch(String search) throws BestResultNotFound {
        if (search == null || search.isEmpty()) {
            throw new IllegalArgumentException("Поисковый запрос не может быть пустым");
        }

        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable current : elements) {
            if (current == null) continue;
            String text = current.getSearchTerm();
            if (text == null) continue;

            int count = 0;
            int index = 0;
            int foundIndex = text.indexOf(search, index);

            while (foundIndex != -1) {
                count++;
                index = foundIndex + search.length();
                foundIndex = text.indexOf(search, index);
            }

            if (count > maxCount) {
                maxCount = count;
                bestMatch = current;
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound(search);
        }
        return bestMatch;
    }
}
