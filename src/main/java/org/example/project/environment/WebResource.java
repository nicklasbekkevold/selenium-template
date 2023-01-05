package org.example.project.environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URISyntaxException;
import java.net.URL;

public enum WebResource {

    EXAMPLE(getUrlFromResource("/example.html")),
    GOOGLE("https://google.com");

    private static final Logger logger = LoggerFactory.getLogger(WebResource.class);

    private final String url;

    WebResource(String url) {
        this.url = url;
    }

    private static String getUrlFromResource(final String fileName) {
        try {
            URL resource = WebResource.class.getResource(fileName);
            if (resource != null) {
                return resource.toURI().toString().replace("file:/", "file:///");
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        logger.info("Could not find web resource with filename {}", fileName);
        return "";
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return getUrl();
    }

}
