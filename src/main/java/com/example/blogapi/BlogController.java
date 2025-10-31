package com.example.blogapi;

import java.util.List;

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
	public String allPosts() {
        List<Post> posts = (List<Post>)postRepository.findAll();
        String result = "<h1>All posts:</h1><br><ul>";

        for (int i = 0; i < posts.size(); i++) {
            Post p = posts.get(i);
            result = result + "<li>" + p.getTitle() + "</li>";
        };

        result = result + "</li>";

        return result;
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
        // c.setPostID(Integer.parseInt(postID));
        c.setAuthor(author);
        c.setText(text);
        
        commentRepository.save(c);

        return "Added new comment!";
    }
    
}
