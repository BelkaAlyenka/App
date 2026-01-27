package org.skypro.skyshop.articles;

import org.skypro.skyshop.search.Searchable;

public final class Article implements Searchable {

    private final String articleTitle;
    private final String articleText;

    public Article(String articleTitle, String articleText) {
        this.articleTitle = articleTitle;
        this.articleText = articleText;
    }

    @Override
    public String toString() {
        return articleTitle + "\n" + articleText;
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return articleTitle;
    }

    @Override
    public String getStringRepresentation() {
        return getName() + " — " + getContentType();
    }
}