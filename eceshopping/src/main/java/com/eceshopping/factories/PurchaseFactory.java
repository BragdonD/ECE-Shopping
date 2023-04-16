package com.eceshopping.factories;

import java.time.LocalDate;

import com.eceshopping.dto.PurchaseDto;
import com.eceshopping.dto.UserDto;
import com.eceshopping.models.UserModel;

public class PurchaseFactory {

    /**
     * Creates a purchase
     * 
     * @param id
     * @param amountPayed
     * @param date
     * @param idUser
     * @return
     */
    public static PurchaseDto createPurchase(Integer id, Double amountPayed, LocalDate date, UserDto idUser) {
        PurchaseDto newPurchase = new PurchaseDto()
                .id(id)
                .amountPayed(amountPayed)
                .date(date)
                .user(idUser);
        return newPurchase;
    }

}
