package com.example.mateusz.justrecyclerview;

import java.io.Serializable;

public class MyItem implements Serializable {

    private String title;
    private String content;

    public MyItem(String title, String content) {
        this.title = title;
        this.content = content;
    }

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
}
