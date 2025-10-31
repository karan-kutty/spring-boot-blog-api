package com.example.blogapi;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer commentID;

    @ManyToOne
    @JoinColumn(name = "postID", nullable = false)
    private Post post;

    private String author;
    
    private String text;
    
    private Integer parentCommentID;
    
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public Integer getParentCommentID() {
        return parentCommentID;
    }
    
    public void setParentCommentID(Integer parent) {
        if (this.commentID != parent)
        this.parentCommentID = parent;
        else
        new Exception("Comment cannot reference itself as a Parent Comment!");
    }

    public Integer getCommentID() {
        return commentID;
    }

    public void setCommentID(Integer commentID) {
        this.commentID = commentID;
    }
}
