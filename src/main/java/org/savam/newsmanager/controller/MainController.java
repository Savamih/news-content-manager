package org.savam.newsmanager.controller;

import org.savam.newsmanager.model.Article;
import org.savam.newsmanager.model.Category;
import org.savam.newsmanager.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private NewsService newsService;

    @Autowired
    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public String listArticles(Model model){
        model.addAttribute("listArticles", this.newsService.listArticles());
        return "news";
    }

    @RequestMapping(value = "/news/add")
    public String addNews(Model model){
        model.addAttribute("article", new Article());
        model.addAttribute("listCategories", newsService.listsCategories());
        return "news_add";
    }

    @RequestMapping(value = "/news/update/{id}")
    public String updateNews(@PathVariable("id") int id, Model model){
        model.addAttribute("article", newsService.getArticleById(id));
        model.addAttribute("listCategories", newsService.listsCategories());
        return "news_add";
    }

    @RequestMapping(value = "/news/add_update", method = RequestMethod.POST)
    public String add_updateNews(@ModelAttribute("article") Article article){
        if(article.getArticle_id() == 0){
            this.newsService.addArticle(article);
        }else {
            this.newsService.updateArticle(article);
        }
        return "redirect:/news";
    }


    @RequestMapping(value = "/news/remove/{id}")
    public String removeArticle(@PathVariable("id") int id){
        this.newsService.removeArticle(id);
        return "redirect:/news";
    }
}
