package org.savam.newsmanager.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.savam.newsmanager.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ArticleDAOImpl implements ArticleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addArticle(Article article) {

        Session session = this.sessionFactory.getCurrentSession();
        session.persist(article);

    }

    public void updateArticle(Article article) {

    }

    public void removeArticle(int id) {

    }

    @SuppressWarnings("unchecked")
    public List<Article> listArticles() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Article> articlesList = session.createQuery("from article").list();

        return articlesList;
    }

    public Article getArticleById(int id) {
        return null;
    }
}
