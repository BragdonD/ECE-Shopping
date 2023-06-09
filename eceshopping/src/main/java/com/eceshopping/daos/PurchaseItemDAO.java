
package com.eceshopping.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.SelectionQuery;
import com.eceshopping.configs.HibernateConfig;
import com.eceshopping.models.PurchaseModel;
import com.eceshopping.models.PurchasedItemModel;

import jakarta.persistence.EntityNotFoundException;

public class PurchaseItemDAO extends Dao<PurchasedItemModel, Integer> {

    private HibernateConfig hibernateConfig;

    public PurchaseItemDAO() {
        super(PurchasedItemModel.class);
        hibernateConfig = HibernateConfig.getInstance();
    }

    /**
     * @param id
     * @return PurchasedItemModel
     * @throws EntityNotFoundException
     */
    public PurchasedItemModel getPurchaseItemById(Integer id) throws EntityNotFoundException {
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

    public List<PurchasedItemModel> getAllPurchasedItemByPurchaseId(PurchaseModel purchase)
            throws EntityNotFoundException {
        try (Session session = hibernateConfig.getSessionFactory().openSession()) {
            SelectionQuery<PurchasedItemModel> query = session.createNamedSelectionQuery(
                    "PurchasedItemModel.findAllByPurchaseId",
                    PurchasedItemModel.class);
            System.out.println("id: " + purchase);
            query.setParameter("purchase", purchase);
            List<PurchasedItemModel> purchaseItems = query.getResultList();
            System.out.println("purchaseItems: " + purchaseItems);
            if (purchaseItems == null) {
                throw new EntityNotFoundException("PurchaseItem does not exist.");
            }
            return purchaseItems;
        }
    }

}
