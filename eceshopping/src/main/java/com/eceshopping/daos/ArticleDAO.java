package com.eceshopping.daos;

import org.hibernate.Session;
import org.hibernate.query.SelectionQuery;
import com.eceshopping.configs.HibernateConfig;
import com.eceshopping.models.ArticleModel;
import jakarta.persistence.EntityNotFoundException;

public class ArticleDao extends Dao<ArticleModel, Integer> {
    private HibernateConfig hibernateConfig;

    public ArticleDao() {
        super(ArticleModel.class);
        hibernateConfig = HibernateConfig.getInstance();
    }

    /**
     * @param name
     * @return ArticleModel
     * @throws EntityNotFoundException
     */
    public ArticleModel getArticleByName(String name) throws EntityNotFoundException {
        try (Session session = hibernateConfig.getSessionFactory().openSession()) {
            SelectionQuery<ArticleModel> query = session.createNamedSelectionQuery("ArticleModel.findByName",
                    ArticleModel.class);
            query.setParameter("name", name);
            ArticleModel article = query.getSingleResultOrNull();
            if (article == null) {
                throw new EntityNotFoundException("Article with name " + name + " does not exist.");
            }
            return article;
        }
    }
}