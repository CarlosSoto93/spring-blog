package com.codeup.models;

import javax.persistence.*;

/**
 * Created by Carlos on 6/19/17.
 */

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, columnDefinition = "text")
    private String body;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Post(){
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
