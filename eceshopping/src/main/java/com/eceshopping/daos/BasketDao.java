package com.eceshopping.daos;

import org.hibernate.Session;
import org.hibernate.query.SelectionQuery;

import com.eceshopping.configs.HibernateConfig;
import com.eceshopping.models.BasketModel;

import jakarta.persistence.EntityNotFoundException;

public class BasketDao extends Dao<BasketModel, Integer> {
    private HibernateConfig hibernateConfig;

    public BasketDao() {
        super(BasketModel.class);
        hibernateConfig = HibernateConfig.getInstance();
    }

    public BasketModel getBasketByUserId(int userId) throws EntityNotFoundException {
        try (Session session = hibernateConfig.getSessionFactory().openSession()) {
            SelectionQuery<BasketModel> query = session.createNamedSelectionQuery("BasketModel.findByUserId",
                    BasketModel.class);
            query.setParameter("userId", userId);
            BasketModel basket = query.getSingleResult();
            if (basket == null) {
                throw new EntityNotFoundException("Basket with user id " + userId + " does not exist.");
            }
            return basket;
        }
    }
}
