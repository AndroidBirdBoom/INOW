package com.kobe.ubersplash.utils;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack on 2017/2/14.
 */

public class OrganizationMessages {

    private Article Article0;
    private Article Article1;
    private Article Article2;
    private Article Article3;
    private Article Article4;

    private List<Article> articles;

    public List<Article> getArticles() {
        if (articles == null) {
            articles = new ArrayList<>();
        }
        articles.add(getArticle0());
        articles.add(getArticle1());
        articles.add(getArticle2());
        articles.add(getArticle3());
        articles.add(getArticle4());
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Article getArticle0() {
        return Article0;
    }

    public void setArticle0(Article article0) {
        Article0 = article0;
    }

    public Article getArticle1() {
        return Article1;
    }

    public void setArticle1(Article article1) {
        Article1 = article1;
    }

    public Article getArticle2() {
        return Article2;
    }

    public void setArticle2(Article article2) {
        Article2 = article2;
    }

    public Article getArticle3() {
        return Article3;
    }

    public void setArticle3(Article article3) {
        Article3 = article3;
    }

    public Article getArticle4() {
        return Article4;
    }

    public void setArticle4(Article article4) {
        Article4 = article4;
    }
}
