package org.savam.newsmanager.dao;


import org.savam.newsmanager.model.Article;

import java.util.List;

public interface ArticleDAO {

    public void addArticle(Article article);
    public void updateArticle(Article article);
    public void removeArticle(int id);
    public List<Article> listArticles();
    public Article getArticleById(int id);
}
