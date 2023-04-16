package com.eceshopping.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.SelectionQuery;

import com.eceshopping.configs.HibernateConfig;
import com.eceshopping.models.BasketItemModel;

import jakarta.persistence.EntityNotFoundException;

public class BasketItemDao extends Dao<BasketItemModel, Integer> {
    private HibernateConfig hibernateConfig;

    /**
     * Default constructor for the BasketItemDao class. It gets the instance of the
     * HibernateConfig class.
     */
    public BasketItemDao() {
        super(BasketItemModel.class);
        hibernateConfig = HibernateConfig.getInstance();
    }

    /**
     * This method is used to get a basket item by id.
     * 
     * @param id The id of the basket item to get.
     * @return A BasketItemModel object containing the basket item information.
     * @throws EntityNotFoundException If the basket item does not exist.
     */
    public BasketItemModel getById(int id) throws EntityNotFoundException {
        try (Session session = hibernateConfig.getSessionFactory().openSession()) {
            BasketItemModel basketItem = session.get(BasketItemModel.class, id);
            if (basketItem == null) {
                throw new EntityNotFoundException("Basket item with id " + id + " does not exist.");
            }
            return basketItem;
        }
    }

    public List<BasketItemModel> getByBasketId(int basketId) throws EntityNotFoundException {
        try (Session session = hibernateConfig.getSessionFactory().openSession()) {
            SelectionQuery<BasketItemModel> query = session.createNamedSelectionQuery("BasketItemModel.findByBasketId",
                    BasketItemModel.class);
            query.setParameter("basketId", basketId);
            List<BasketItemModel> basketItems = query.getResultList();
            if (basketItems == null) {
                throw new EntityNotFoundException("Basket items with basket id " + basketId + " does not exist.");
            }
            return basketItems;
        }
    }
}