package org.savam.newsmanager.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.savam.newsmanager.model.Article;
import org.savam.newsmanager.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Category getCategoryById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Category category = (Category) session.load(Category.class, new Integer(id));
        return category;
    }

    @Override
    public List<Category> listCategories() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Category> categoryList= session.createQuery("from Category").list();
        return categoryList;
    }
}
