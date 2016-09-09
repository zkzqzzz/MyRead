package com.demo.zk.myread.data;

/**
 * ClassName:com.demo.zk.myread.data
 * Author: zk<p>.
 * time: 2016/9/8 22:27.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class SplashData {
    public String text;
    public String img;

    public String getName() {
        return text;
    }

    public void setName(String name) {
        this.text = name;
    }

    public String getUrl() {
        return img;
    }

    public void setUrl(String url) {
        this.img = url;
    }
}
