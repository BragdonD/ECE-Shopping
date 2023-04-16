package com.eceshopping.converter;

import com.eceshopping.dto.PurchaseDto;
import com.eceshopping.models.PurchaseModel;

public class PurchaseConverter {

    
    /** 
     * @param purchaseDto
     * @return PurchaseModel
     */
    public static PurchaseModel convertToModel(PurchaseDto purchaseDto) {
        PurchaseModel purchaseModel = new PurchaseModel();
        purchaseModel.setId(purchaseDto.getId());
        purchaseModel.setAmountPayed(purchaseDto.getAmountPayed());
        purchaseModel.setDate(purchaseDto.getDate());
        purchaseModel.setIdUser(purchaseDto.getUser());
        return purchaseModel;
    }

    
    /** 
     * @param purchaseModel
     * @return PurchaseDto
     */
    public static PurchaseDto convertToDto(PurchaseModel purchaseModel) {
        PurchaseDto purchaseDto = new PurchaseDto();
        purchaseDto.setId(purchaseModel.getId());
        purchaseDto.setAmountPayed(purchaseModel.getAmountPayed());
        purchaseDto.setDate(purchaseModel.getDate());
        purchaseDto.setUser(purchaseModel.getIdUser());
        return purchaseDto;
    }

}
