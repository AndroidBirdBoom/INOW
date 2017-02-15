package com.kobe.ubersplash.utils;

import java.io.Serializable;

/**
 * Created by Jack on 2017/2/14.
 */

public class Article implements Serializable {
    public String title;
    public String content;
    public String image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
