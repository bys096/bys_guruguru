package com.fenrir.guruguru_spring.domain.review.repository;

import com.fenrir.guruguru_spring.domain.review.dto.ReviewByStoreRequestDto;
import com.fenrir.guruguru_spring.domain.review.dto.ReviewByStoreResponseDto;
import com.fenrir.guruguru_spring.domain.review.dto.ReviewByStoreWithReplyDto;
import com.fenrir.guruguru_spring.domain.review.dto.ReviewPaginationRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewRepositoryCustom {

//    一つの店のレビューの照会
    Page<ReviewByStoreWithReplyDto> getReviewByStore(String storeCode, Pageable pageable,
                                                     ReviewPaginationRequestDto requestDto);
}
