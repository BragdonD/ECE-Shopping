package com.eceshopping.events;

import javafx.event.Event;
import javafx.event.EventType;

public class SearchEvent extends Event {
    public static final EventType<SearchEvent> SEARCH_EVENT = new EventType<>(Event.ANY, "SEARCH_EVENT");
    private String query;

    /**
     * Constructor of SearchEvent
     * 
     * @param query
     */
    public SearchEvent(String query) {
        super(SEARCH_EVENT);
        this.query = query;
    }

    /**
     * @return String
     */
    public String getQuery() {
        return this.query;
    }
}
