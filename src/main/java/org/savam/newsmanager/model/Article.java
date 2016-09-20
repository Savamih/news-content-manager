package org.savam.newsmanager.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="ARTICLE")
public class Article {

    private int article_id;
    private String content;
    //@Temporal(TemporalType.DATE)
    private String publication_date;
    private Category category;

    @Id
    @Column(name = "article_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "publication_date")
    public String getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(String publication_date) {
        this.publication_date = publication_date;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN) //TODO
    @JoinColumn(name = "category")
    public Category getCategory() {
        return category;
    }


}
