package com.desire323.friends.controller;

import com.desire323.friends.entity.Post;
import com.desire323.friends.service.PostService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public void createPost(@RequestBody Post post) {
        postService.save(post);
    }


}

