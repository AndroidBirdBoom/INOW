package com.kobe.ubersplash.utils;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Jack on 2017/2/8.
 */

public class TeanBeen {

    @SerializedName("美女")
    public List<PeopleBeen> girls;

    public List<PeopleBeen> getGirls() {
        return girls;
    }

    public void setGirls(List<PeopleBeen> girls) {
        this.girls = girls;
    }

    public static class PeopleBeen implements Serializable {
        private String img;
        private String imgsrc;
        private String pixel;
        private int upTimes;
        private String title;
        private String digest;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

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

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getPixel() {
            return pixel;
        }

        public void setPixel(String pixel) {
            this.pixel = pixel;
        }

        public int getUpTimes() {
            return upTimes;
        }

        public void setUpTimes(int upTimes) {
            this.upTimes = upTimes;
        }

        @Override
        public String toString() {
            return "PeopleBeen{" +
                    "img='" + img + '\'' +
                    ", imgsrc='" + imgsrc + '\'' +
                    ", pixel='" + pixel + '\'' +
                    ", upTimes=" + upTimes +
                    ", title='" + title + '\'' +
                    ", digest='" + digest + '\'' +
                    '}';
        }
    }

}
