package org.savam.newsmanager.dao;


import org.savam.newsmanager.model.Article;
import org.savam.newsmanager.model.Category;

import java.util.List;

public interface CategoryDAO {

    public Category getCategoryById(int id);
    public List<Category> listCategories();
}
