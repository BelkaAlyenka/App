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
}
