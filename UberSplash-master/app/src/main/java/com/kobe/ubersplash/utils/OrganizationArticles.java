package com.kobe.ubersplash.utils;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Jack on 2017/2/14.
 */

public class OrganizationArticles {

    public class OrArticle implements Serializable {
        private String digest;
        private String img;
        private String title;

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
