package com.crudproject.controller;

import com.crudproject.dto.PostRequestDto;
import com.crudproject.dto.PostResponseDto;
import com.crudproject.entity.Post;
import com.crudproject.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping("/{postId}")
    public ResponseEntity<PostResponseDto> getPost(@PathVariable(name = "postId") Long postId) {
        PostResponseDto postResponseDto = postService.getPost(postId);
        return ResponseEntity.ok(postResponseDto);
    }

    @PostMapping
    public ResponseEntity<PostResponseDto> savePost(PostRequestDto postDto) {
        return ResponseEntity.ok(postService.savePost(postDto));
    }
}
