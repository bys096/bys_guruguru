package com.fenrir.guruguru_spring.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewAndCommentListRequestDto {

    private String reviewText;

    private String storeCode;
//    private String
}
