package com.eceshopping.converter;

import com.eceshopping.dto.PurchasedItemDto;
import com.eceshopping.models.PurchasedItemModel;

public class PurchaseItemConverter {
    
    public static PurchasedItemModel convertToModel(PurchasedItemDto purchaseItemDto) {
        PurchasedItemModel purchaseItemModel = new PurchasedItemModel();
        purchaseItemModel.setId(purchaseItemDto.getId());
        purchaseItemModel.setIdArticle(purchaseItemDto.getArticle());
        purchaseItemModel.setIdPurchase(purchaseItemDto.getPurchase());
        return purchaseItemModel;
    }

    public static PurchasedItemDto convertToDto(PurchasedItemModel purchaseItemModel) {
        PurchasedItemDto purchaseItemDto = new PurchasedItemDto();
        purchaseItemDto.setId(purchaseItemModel.getId());
        purchaseItemDto.setArticle(purchaseItemModel.getIdArticle());
        purchaseItemDto.setPurchase(purchaseItemModel.getIdPurchase());
        return purchaseItemDto;
    }

}
