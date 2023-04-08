package com.eceshopping.utils;

public class Route {
    private final String name;
    private final String path;
    private final int index;

    public Route(String name, int index, String path) {
        this.name = name;
        this.index = index;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public int getIndex() {
        return index;
    }
}
