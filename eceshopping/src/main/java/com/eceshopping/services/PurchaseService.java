package com.eceshopping.services;

import java.util.ArrayList;
import java.util.List;

import com.eceshopping.converter.PurchaseConverter;
import com.eceshopping.converter.PurchaseItemConverter;
import com.eceshopping.daos.PurchaseDAO;
import com.eceshopping.dto.PurchaseDto;
import com.eceshopping.models.PurchaseModel;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import javafx.concurrent.Task;

public class PurchaseService {
    
    PurchaseDAO purchaseDAO;

    public PurchaseService() {
        purchaseDAO = new PurchaseDAO();
    }

    public PurchaseModel getPurchaseById(Integer id) throws EntityNotFoundException {
        return purchaseDAO.getPurchaseById(id);
    }

    public Task<PurchaseDto> getByIdAsync (PurchaseDto purchaseDto) throws EntityNotFoundException {
        Task<PurchaseDto> task = new Task<PurchaseDto>() {
            @Override
            protected PurchaseDto call() throws Exception {
                try {
                    System.out.println(purchaseDto);
                    purchaseDAO.save(PurchaseConverter.convertToModel(purchaseDto));
                } catch (EntityExistsException e) {
                    throw e;
                }
                return purchaseDto;
            }
        };
        return task;
    }

    public Task<List<PurchaseDto>> getAllPurchasedItem() {
        Task<List<PurchaseDto>> task = new Task<List<PurchaseDto>>() {
            @Override
            protected List<PurchaseDto> call() throws Exception {
                List<PurchaseDto> PurchaseDtos = new ArrayList<>();
                for (PurchaseModel article : purchaseDAO.getAll()) {
                    PurchaseDtos.add(PurchaseConverter.convertToDto(article));
                }
                System.out.println("PurchaseDtos");
                return PurchaseDtos;
            }
        };
        return task;
    }
}
