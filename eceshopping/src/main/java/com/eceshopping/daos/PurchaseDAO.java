package com.eceshopping.daos;
import org.hibernate.Session;
import org.hibernate.query.SelectionQuery;
import com.eceshopping.configs.HibernateConfig;
import com.eceshopping.models.ArticleModel;
import com.eceshopping.models.PurchaseModel;

import jakarta.persistence.EntityNotFoundException;


public class PurchaseDAO extends Dao<PurchaseModel, Integer> {
    private HibernateConfig hibernateConfig;
    public PurchaseDAO() {
        super(PurchaseModel.class);
        hibernateConfig = HibernateConfig.getInstance();
    }

    public PurchaseModel getPurchaseById (Integer id) throws EntityNotFoundException {
        try (Session session = hibernateConfig.getSessionFactory().openSession()) {
            SelectionQuery<PurchaseModel> query = session.createNamedSelectionQuery("PurchaseModel.findById",
                    PurchaseModel.class);
            query.setParameter("id", id);
            PurchaseModel purchase = query.getSingleResultOrNull();
            if (purchase == null) {
                throw new EntityNotFoundException("Purchase with id " + id + " does not exist.");
            }
            return purchase;
        }
    }
}
