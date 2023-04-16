package com.eceshopping.events;

import javafx.event.Event;
import javafx.event.EventType;

public class FocusSearchEvent extends Event {
    public static final EventType<FocusSearchEvent> FOCUS_SEARCH_EVENT = new EventType<>(Event.ANY,
            "FOCUS_SEARCH_EVENT");
    private boolean focus;

    public FocusSearchEvent(boolean focus) {
        super(FOCUS_SEARCH_EVENT);
        this.focus = focus;
    }

    /**
     * @return boolean
     */
    public boolean getFocus() {
        return this.focus;
    }
}
