package com.example.blogapi;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity // This tells Hibernate to make a table out of this class
public class Post {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer postID;

    private LocalDateTime postDateTime;
    
    private LocalDateTime lastModifiedDateTime;
    
    private String topic;
    
    private String title;
    
    private String author;
    
    private String text;

    @OneToMany(mappedBy = "post")
    private Set<Comment> comments;
    
    public Integer getPostID() {
        return postID;
    }
    
    public void setPostID(Integer id) {
        this.postID = id;
    }
    
    public LocalDateTime getPostDateTime() {
        return postDateTime;
    }

    public void setPostDateTime(LocalDateTime postDateTime) {
        this.postDateTime = postDateTime;
    }

    public LocalDateTime getLastModifiedDateTime() {
        return lastModifiedDateTime;
    }

    public void setLastModifiedDateTime(LocalDateTime lastModifiedDateTime) {
        this.lastModifiedDateTime = lastModifiedDateTime;
    }

    public String getTopic() {
        return topic;
    }
    
    public void setTopic(String name) {
        this.topic = name;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String email) {
        this.title = email;
    }
    
    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String name) {
        this.author = name;
    }
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
