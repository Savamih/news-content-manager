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


    public void addArticle(Article article) {
        this.articleDAO.addArticle(article);
    }

    public List<Article> listArticles() {
        return this.articleDAO.listArticles();
    }

}
