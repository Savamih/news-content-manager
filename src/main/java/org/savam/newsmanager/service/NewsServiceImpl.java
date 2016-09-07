package org.savam.newsmanager.service;

import org.savam.newsmanager.dao.ArticleDAO;
import org.savam.newsmanager.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private ArticleDAO articleDAO;

    public void setArticleDAO(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }

    @Transactional
    public void addArticle(Article article) {
        this.articleDAO.addArticle(article);
    }

    @Transactional
    public List<Article> listArticles() {
        return this.articleDAO.listArticles();
    }

    @Override
    @Transactional
    public void updateArticle(Article article) {
         articleDAO.updateArticle(article);
    }

    @Override
    @Transactional
    public void removeArticle(int id) {
        articleDAO.removeArticle(id);

    }

    @Override
    @Transactional
    public Article getArticleById(int id) {
        return articleDAO.getArticleById(id);
    }

}
