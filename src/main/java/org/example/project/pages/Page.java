package org.example.project.pages;

import java.net.URISyntaxException;

public enum Page {

    EXAMPLE(getUrlFromResource("/example.html")),
    GOOGLE("https://google.com");

    private final String url;

    Page(String url) {
        this.url = url;
    }

    private static String getUrlFromResource(final String fileName) {
        try {
            String path = Page.class.getResource(fileName).toURI().toString();
            return path.replace("file:/", "file:///");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return getUrl();
    }

}
