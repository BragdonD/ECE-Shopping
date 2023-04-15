package com.eceshopping.factories;

import com.eceshopping.dto.PurchasedItemDto;
import com.eceshopping.models.ArticleModel;
import com.eceshopping.models.PurchaseModel;

public class PurchasedItemFactory {
    
    public static PurchasedItemDto createPurchasedItem(Integer id, ArticleModel article, PurchaseModel purchase) {
        PurchasedItemDto newPurchasedItem = new PurchasedItemDto()
            .id(id)
            .article(article)
            .purchase(purchase);
        return newPurchasedItem;
    }
}
