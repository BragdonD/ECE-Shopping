package com.eceshopping.utils;

/**
 * This class is used to store the route information
 */
public class Route {
    private final String name;
    private final String path;
    private final int index;

    public Route(String name, int index, String path) {
        this.name = name;
        this.index = index;
        this.path = path;
    }

    
    /** 
     * @return String
     */
    public String getName() {
        return name;
    }

    
    /** 
     * @return String
     */
    public String getPath() {
        return path;
    }

    public int getIndex() {
        return index;
    }
}
