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

   // private static final Logger logger =
    //        LoggerFactory.getLogger(ArticleDAOImpl.class);

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
        List<Article> articlesList = session.createQuery("from Article").list();
        for(Article a : articlesList){
            System.out.println(a.getCategory());
            System.out.println(a.getContent());
            //logger.info("Article "+ a);
        }
        return articlesList;
    }

    public Article getArticleById(int id) {
        return null;
    }
}
