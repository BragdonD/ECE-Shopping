package com.eceshopping.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.eceshopping.converter.PurchaseItemConverter;
import com.eceshopping.daos.PurchaseItemDAO;
import com.eceshopping.dto.PurchasedItemDto;
import com.eceshopping.models.PurchasedItemModel;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import javafx.concurrent.Task;

public class PurchasedItemService {
    private PurchaseItemDAO purchaseItemDAO;

    /**
     * Constructor of PurchasedItemService
     */
    public PurchasedItemService() {
        this.purchaseItemDAO = new PurchaseItemDAO();
    }

    /**
     * @param id
     * @return PurchasedItemDto
     * @throws IOException
     * @throws EntityNotFoundException
     */
    public PurchasedItemDto getById(Integer id) throws EntityNotFoundException, IOException {
        return PurchaseItemConverter.convertToDto(purchaseItemDAO.getPurchaseItemById(id));
    }

    /**
     * @param purchasedItemDto
     * @return Task<PurchasedItemDto>
     * @throws EntityNotFoundException
     * @throws IOException
     */
    public Task<PurchasedItemDto> getByIdAsync(PurchasedItemDto purchasedItemDto)
            throws EntityNotFoundException, IOException {
        Task<PurchasedItemDto> task = new Task<PurchasedItemDto>() {
            @Override
            protected PurchasedItemDto call() throws Exception {
                try {
                    System.out.println(purchasedItemDto);
                    purchaseItemDAO.save(PurchaseItemConverter.convertToModel(purchasedItemDto));
                } catch (EntityExistsException e) {
                    throw e;
                }
                return purchasedItemDto;
            }
        };
        return task;
    }

    /**
     * Get all PurchasedItem from database and convert them to PurchasedItemDto
     * 
     * @return Task<List<PurchasedItemDto>>
     */
    public Task<List<PurchasedItemDto>> getAllPurchasedItem() {
        Task<List<PurchasedItemDto>> task = new Task<List<PurchasedItemDto>>() {
            @Override
            protected List<PurchasedItemDto> call() throws Exception {
                List<PurchasedItemDto> PurchasedItemDtos = new ArrayList<>();
                for (PurchasedItemModel article : purchaseItemDAO.getAll()) {
                    PurchasedItemDtos.add(PurchaseItemConverter.convertToDto(article));
                }
                System.out.println("PurchasedItemDtos");
                return PurchasedItemDtos;
            }
        };
        return task;
    }

    /**
     * Save PurchasedItem to database after converting it to PurchasedItemModel
     * 
     * @param purchasedItemDto
     * @return Task<PurchasedItemDto>
     * @throws EntityExistsException
     */

    public Task<PurchasedItemDto> save(PurchasedItemDto purchasedItemDto) throws EntityExistsException {
        Task<PurchasedItemDto> task = new Task<PurchasedItemDto>() {
            @Override
            protected PurchasedItemDto call() throws Exception {
                try {
                    purchaseItemDAO.save(PurchaseItemConverter.convertToModel(purchasedItemDto));
                } catch (EntityExistsException e) {
                    throw e;
                }
                return purchasedItemDto;
            }
        };
        return task;
    }
}