package org.savam.newsmanager.controller;

import org.savam.newsmanager.model.Article;
import org.savam.newsmanager.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class MainController {

    private NewsService newsService;

    @Autowired
    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public String listArticles(Model model){
        model.addAttribute("article", new Article());
        model.addAttribute("listArticles", this.newsService.listArticles());
        return "page";
    }
}
