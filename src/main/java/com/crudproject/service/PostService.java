package com.crudproject.service;

import com.crudproject.base.exception.ExceptionHandler;
import com.crudproject.base.status.ErrorStatus;
import com.crudproject.dto.PostRequestDto;
import com.crudproject.dto.PostResponseDto;
import com.crudproject.entity.Post;
import com.crudproject.repository.PostRepository;
import com.crudproject.utils.generator.SnowflakeGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public PostResponseDto getPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ExceptionHandler(ErrorStatus.POST_NOT_FOUND)
        );

        return new PostResponseDto(
                post.getId(),
                post.getTitle(),
                post.getContent()
        );
    }

    public PostResponseDto savePost(PostRequestDto postDto) {
        Long snowflakeId = SnowflakeGenerator.generate();

        Post postEntity = Post.builder()
                .id(snowflakeId)
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .build();
        Post saved = postRepository.save(postEntity);

        return new PostResponseDto(
                saved.getId(),
                saved.getTitle(),
                saved.getContent()
        );
    }
}
