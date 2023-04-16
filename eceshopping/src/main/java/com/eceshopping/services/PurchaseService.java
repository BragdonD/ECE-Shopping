package com.eceshopping.services;

import java.util.ArrayList;
import java.util.List;

import com.eceshopping.converter.PurchaseConverter;
import com.eceshopping.converter.PurchaseItemConverter;
import com.eceshopping.daos.PurchaseDAO;
import com.eceshopping.daos.PurchaseItemDAO;
import com.eceshopping.dto.PurchaseDto;
import com.eceshopping.dto.PurchasedItemDto;
import com.eceshopping.models.PurchaseModel;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import javafx.concurrent.Task;

public class PurchaseService {

    PurchaseDAO purchaseDAO;
    PurchaseItemDAO purchaseItemDAO;

    public PurchaseService() {
        purchaseDAO = new PurchaseDAO();
        purchaseItemDAO = new PurchaseItemDAO();
    }

    /**
     * @param id
     * @return PurchaseModel
     * @throws EntityNotFoundException
     */
    public PurchaseModel getPurchaseById(Integer id) throws EntityNotFoundException {
        return purchaseDAO.getPurchaseById(id);
    }

    /**
     * @param purchaseDto
     * @return Task<PurchaseDto>
     * @throws EntityNotFoundException
     */
    public Task<PurchaseDto> getByIdAsync(PurchaseDto purchaseDto) throws EntityNotFoundException {
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
/**
 * Get all Purchases from database and convert them to PurchaseDto
 * @param purchaseDto
 * @return
 */
    public Task<List<PurchaseDto>> getAllPurchases() {
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

    /**
     * Save a Purchase in database after converting it to PurchaseModel
     * @param purchaseDto
     * @return
     */
    public Task<PurchaseDto> savePurchaseAsync(PurchaseDto purchaseDto) {
        Task<PurchaseDto> task = new Task<PurchaseDto>() {
            @Override
            protected PurchaseDto call() throws Exception {
                try {
                    Integer purchaseId = purchaseDAO.save(PurchaseConverter.convertToModel(purchaseDto));
                    for (PurchasedItemDto items : purchaseDto.getPurchasedItems()) {
                        items.getPurchase().setId(purchaseId);
                        purchaseItemDAO.save(PurchaseItemConverter.convertToModel(items));
                    }
                } catch (EntityExistsException e) {
                    throw e;
                }
                return purchaseDto;
            }
        };
        return task;
    }
}