package org.skypro.skyshop.search;

import java.util.Comparator;

public class NameLengthComparator implements Comparator<Searchable> {

        @Override
        public int compare(Searchable firstElement, Searchable secondElement) {
            int firstLength = firstElement.getName().length();
            int secondLength = secondElement.getName().length();
            int comparisonLength = Integer.compare(secondLength, firstLength);
            if (comparisonLength == 0) {
                return firstElement.getName().compareTo(secondElement.getName());
            }
            return comparisonLength;
        }
    }
