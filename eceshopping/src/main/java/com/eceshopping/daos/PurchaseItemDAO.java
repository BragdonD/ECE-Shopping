
package com.eceshopping.daos;
import org.hibernate.Session;
import org.hibernate.query.SelectionQuery;
import com.eceshopping.configs.HibernateConfig;
import com.eceshopping.models.ArticleModel;
import com.eceshopping.models.PurchasedItemModel;

import jakarta.persistence.EntityNotFoundException;


public class PurchaseItemDAO extends Dao<PurchasedItemModel, Integer>{

    private HibernateConfig hibernateConfig;

    public PurchaseItemDAO() {
        super(PurchasedItemModel.class);
        hibernateConfig = HibernateConfig.getInstance();
    }

    public PurchasedItemModel getPurchaseItemById (Integer id) throws EntityNotFoundException {
        try (Session session = hibernateConfig.getSessionFactory().openSession()) {
            SelectionQuery<PurchasedItemModel> query = session.createNamedSelectionQuery("PurchaseItemModel.findById",
                    PurchasedItemModel.class);
            query.setParameter("id", id);
            PurchasedItemModel purchaseItem = query.getSingleResultOrNull();
            if (purchaseItem == null) {
                throw new EntityNotFoundException("PurchaseItem with id " + id + " does not exist.");
            }
            return purchaseItem;
        }
    }
    
}
