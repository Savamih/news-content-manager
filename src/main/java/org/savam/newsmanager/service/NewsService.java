package org.savam.newsmanager.service;


import org.savam.newsmanager.model.Article;
import org.savam.newsmanager.model.Category;

import java.util.List;

public interface NewsService {

    public void addArticle(Article article);
    public List<Article> listArticles();
    public void updateArticle(Article article);
    public void removeArticle(int id);
    public Article getArticleById(int id);
    public List<Category> listsCategories();
}
