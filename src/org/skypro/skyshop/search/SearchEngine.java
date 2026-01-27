package org.skypro.skyshop.search;

public class SearchEngine {
    private final Searchable[] elements;
    private int size;

    public SearchEngine() {
        this.elements = new Searchable[5];
        this.size = 0;
    }

    public void add(Searchable element) {
        if (size < elements.length) {
            elements[size] = element;
            size++;
        }
    }

    public Searchable[] search(String message) {
        Searchable[] output = new Searchable[5];
        int index = 0;

        for (Searchable element : elements) {
            if (element != null && element.getSearchTerm() != null && element.getSearchTerm().contains(message)) {

                output[index] = element;
                index++;

                if (index == 5) {
                    break;
                }
            }
        }

        Searchable[] finalResults = new Searchable[index];
        System.arraycopy(output, 0, finalResults, 0, index);

        return finalResults;
    }

    public String outputSearch(String message) {
        Searchable[] results = search(message);
        String[] representations = new String[results.length];

        for (int i = 0; i < results.length; i++) {
            representations[i] = results[i].getStringRepresentation();
        }

        return String.join("\n", representations);
    }
    public Searchable findMostSuitableMatch(String search) throws BestResultNotFound {
        if (search == null || search.isEmpty()) {
            throw new IllegalArgumentException("Поисковый запрос не может быть пустым");
        }

        Searchable bestMatch = null;
        int maxCount = 0;

        for (int i = 0; i < size; i++) {
            Searchable current = elements[i];

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
