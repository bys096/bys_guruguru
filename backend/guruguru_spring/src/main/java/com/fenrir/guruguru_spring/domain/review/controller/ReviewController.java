package com.fenrir.guruguru_spring.domain.review.controller;

import com.fenrir.guruguru_spring.domain.review.dto.ReviewByStoreResponseDto;
import com.fenrir.guruguru_spring.domain.review.dto.ReviewByStoreWithReplyDto;
import com.fenrir.guruguru_spring.domain.review.dto.ReviewCreateRequestDto;
import com.fenrir.guruguru_spring.domain.review.dto.ReviewPaginationRequestDto;
import com.fenrir.guruguru_spring.domain.review.exception.ReviewDuplicateException;
import com.fenrir.guruguru_spring.domain.review.service.ReviewService;
import com.fenrir.guruguru_spring.domain.user.entity.User;
import com.fenrir.guruguru_spring.global.error.exception.BusinessException;
import com.fenrir.guruguru_spring.global.utils.SecurityUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createReview(@Valid @RequestBody ReviewCreateRequestDto dto) {
        log.info("security Context: " + SecurityUtil.getCurrentMemberId());
        log.info(dto.toString());
        reviewService.createReview(dto);
    }

    @DeleteMapping("/{rid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReview(@PathVariable("rid") Long rid) {
        System.out.println("rid");
        reviewService.deleteReview(rid);
    }

    @GetMapping("/list/{storeCode}")
    @ResponseStatus(HttpStatus.OK)
    public Page<ReviewByStoreWithReplyDto> getAllReviewByStore(@PathVariable("storeCode") String storeCode,
                                                               @ModelAttribute ReviewPaginationRequestDto requestDto) {
        log.info("리스트 디버깅");
        log.info(storeCode);
        log.info(requestDto.getPage().toString());
        log.info(requestDto.getLimit().toString());
        log.info("getAllReviewByStore");
        return reviewService.getAllReviewByStore(storeCode, requestDto);
//        return ResponseEntity.ok(reviewService.getAllReviewByStore(storeCode, requestDto));
    }


}
