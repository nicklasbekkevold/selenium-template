package org.example.project.driver;

public enum Browser {
    CHROME, FIREFOX, EDGE;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
