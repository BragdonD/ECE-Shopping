package com.eceshopping.converter;

import java.io.IOException;

import com.eceshopping.dto.PurchasedItemDto;
import com.eceshopping.models.PurchasedItemModel;

public class PurchaseItemConverter {

    /**
     * @param purchaseItemDto
     * @return PurchasedItemModel
     */
    public static PurchasedItemModel convertToModel(PurchasedItemDto purchaseItemDto) {
        PurchasedItemModel purchaseItemModel = new PurchasedItemModel();
        purchaseItemModel.setId(purchaseItemDto.getId());
        purchaseItemModel.setArticle(ArticleConverter.convertToModel(purchaseItemDto.getArticle()));
        purchaseItemModel.setPurchase(PurchaseConverter.convertToModel(purchaseItemDto.getPurchase()));
        purchaseItemModel.setQuantity(purchaseItemDto.getQuantity());
        return purchaseItemModel;
    }

    /**
     * @param purchaseItemModel
     * @return PurchasedItemDto
     * @throws IOException
     */
    public static PurchasedItemDto convertToDto(PurchasedItemModel purchaseItemModel) throws IOException {
        PurchasedItemDto purchaseItemDto = new PurchasedItemDto();
        purchaseItemDto.setId(purchaseItemModel.getId());
        purchaseItemDto.setArticle(ArticleConverter.convertToDto(purchaseItemModel.getArticle()));
        purchaseItemDto.setPurchase(PurchaseConverter.convertToDto(purchaseItemModel.getPurchase()));
        purchaseItemDto.setQuantity(purchaseItemModel.getQuantity());
        return purchaseItemDto;
    }

}
