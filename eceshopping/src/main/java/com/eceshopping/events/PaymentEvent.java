package com.eceshopping.events;

import com.eceshopping.dto.ArticleDto;
import com.eceshopping.dto.PurchaseDto;

import javafx.event.Event;
import javafx.event.EventType;

public class PaymentEvent extends Event {
    public static final EventType<PaymentEvent> PAYMENT_EVENT = new EventType<>(Event.ANY, "PAYMENT_EVENT");
    private PurchaseDto purchase;

    public PaymentEvent(PurchaseDto purchase) {
        super(PAYMENT_EVENT);
        this.purchase = purchase;
    }

    
    /** 
     * @return ArticleDto
     */
    public PurchaseDto getPurchase() {
        return purchase;
    }

}
