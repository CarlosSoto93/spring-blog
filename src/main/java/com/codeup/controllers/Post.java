package com.codeup.controllers;

/**
 * Created by Carlos on 6/19/17.
 */
public class Post {
    private String title;
    private String body;

    public Post(){
        title = this.title;
        body = this.body;
    }

    public Post(String title, String body) {
        this.title = title;
        this.title = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
