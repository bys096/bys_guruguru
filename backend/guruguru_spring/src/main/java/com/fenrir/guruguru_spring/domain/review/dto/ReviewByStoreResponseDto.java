package com.fenrir.guruguru_spring.domain.review.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ReviewByStoreResponseDto {

    private Long userId;

    private String userNick;

//    private String imageUrl;

    private Long rid;

    private LocalDateTime createdAt;

    private Integer reviewRating;

    // iine

    private String reviewText;

    @Builder
    public ReviewByStoreResponseDto(String nickName, LocalDateTime createdDate,
        Integer reviewRating, String reviewText, Long userId, Long reviewId) {
        this.userNick = nickName;
        this.createdAt = createdDate;
        this.reviewRating = reviewRating;
        this.reviewText = reviewText;
        this.userId = userId;
        this.rid = reviewId;
    }
}

