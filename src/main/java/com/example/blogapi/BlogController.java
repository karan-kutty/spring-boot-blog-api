package com.example.blogapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

	@GetMapping("/all")
	public Iterable<Post> allPosts() {
        return postRepository.findAll();
	}

    @GetMapping("/post")
    public Post getPost(@RequestParam String postID) {
        Integer id = Parser.tryParseStringToInteger(postID);
        
        if (id == null)
            return null;
        else return this.postRepository.findById(id).get();
    }

    @GetMapping("/comments")
    public Iterable<Comment> getComments(@RequestParam String postID) {
        Integer id = Parser.tryParseStringToInteger(postID);
        
        if (id == null)
            return null;
        else {
            return this.getPost(postID).getComments();
        }
    }
    
    @PostMapping("/addPost")
    public String addPost(@RequestParam String title, @RequestParam String author) {
        Post p = new Post();
        p.setTitle(title);
        p.setAuthor(author);
        
        postRepository.save(p);

        return "Added new post!";
    }

    @PostMapping("/addComment")
    public String addComment(@RequestParam String postID, @RequestParam String author, 
    @RequestParam String text) {
        Comment c = new Comment();
        c.setPost(this.postRepository.findById(Integer.parseInt(postID)).get());
        c.setAuthor(author);
        c.setText(text);
        
        commentRepository.save(c);

        return "Added new comment!";
    }    
}
