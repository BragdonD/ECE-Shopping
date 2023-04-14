package com.eceshopping.events;

import javafx.event.Event;
import javafx.event.EventType;

public class LooseFocusEvent extends Event {
    public static final EventType<LooseFocusEvent> LOOSE_FOCUS_EVENT = new EventType<>(Event.ANY, "LOOSE_FOCUS_EVENT");

    public LooseFocusEvent() {
        super(LOOSE_FOCUS_EVENT);
    }
}