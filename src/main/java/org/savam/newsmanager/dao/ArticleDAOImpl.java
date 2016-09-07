package org.savam.newsmanager.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.savam.newsmanager.model.Article;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ArticleDAOImpl implements ArticleDAO {

    private static final Logger logger =
            LoggerFactory.getLogger(ArticleDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addArticle(Article article) {

        Session session = this.sessionFactory.getCurrentSession();
        session.persist(article);
        logger.info("Person saved successfully, Person Details="+article);

    }

    public void updateArticle(Article article) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(article);
        logger.info("Person updated successfully, Person Details="+article);
    }

    public void removeArticle(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Article article = (Article) session.load(Article.class, new Integer(id));
        if(null != article){
            session.delete(article);
        }
        logger.info("Person deleted successfully, person details="+article);
    }

    @SuppressWarnings("unchecked")
    public List<Article> listArticles() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Article> articlesList = session.createQuery("from Article").list();
        return articlesList;
    }

    public Article getArticleById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Article article = (Article) session.load(Article.class, new Integer(id));
        logger.info("Person loaded successfully, Person details="+article);
        return article;
    }
}
