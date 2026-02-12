package org.skypro.skyshop.search;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> elements;

    public SearchEngine() {
        this.elements = new HashSet<>();
    }
    //добавляем элементы
    public void add(Searchable element) {
        if (element == null) {
            return;
        }
        elements.add(element);
    }
    //поиск по строке
    public Set<Searchable> search(String message) {
        return elements.stream()
                .filter(element -> element != null &&
                        element.getSearchTerm() != null &&
                        element.getSearchTerm().contains(message))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new NameLengthComparator())));
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
