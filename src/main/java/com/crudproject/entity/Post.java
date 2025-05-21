package com.crudproject.entity;

import com.crudproject.utils.generator.SnowflakeId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @SnowflakeId
    private Long id;
    private String title;
    private String content;
}
