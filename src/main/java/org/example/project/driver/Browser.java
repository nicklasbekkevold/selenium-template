package org.example.project.driver;

public enum Browser {
    CHROMIUM, CHROME, EDGE, FIREFOX;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
